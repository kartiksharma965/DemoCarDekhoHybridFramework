package com.DemoCarDekhoHybridFramework.qa.baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import com.DemoCarDekhoHybridFramework.qa.utils.ExcelReader;
import com.DemoCarDekhoHybridFramework.qa.utils.Utilities;


public class BaseTest {
	public WebDriver driver;
	public Logger logger;
	protected Properties configProp;
	protected Properties testDataProp;
	public ExcelReader excel = new ExcelReader(".\\testData\\testdata.xlsx");
	public WebDriverWait wait;

	public void setUp(String browserName) {

		logger=LogManager.getLogger(this.getClass());

		// fetching data at runtime from config.properties file.
		configProp = new Properties();
		File configFile = new File(".\\src\\test\\java\\com\\DemoCarDekhoHybridFramework\\qa\\config\\config.properties");
		try{
			FileInputStream fis = new FileInputStream(configFile);
			configProp.load(fis);	
		}catch(Throwable e) {
			e.printStackTrace();	
		}

		// fetching data at runtime from testdata.properties file.
		testDataProp = new Properties();
		File testDataFile = new File(".\\testData\\testdata.properties");
		try {
			FileInputStream fis = new FileInputStream(testDataFile);
			testDataProp.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}


		if(browserName.equalsIgnoreCase("chrome")) {
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			//options.setHeadless(false);
			driver = new ChromeDriver(options);
			driver = new ChromeDriver();
			logger.info("Chrome Browser launched");

		} else if (browserName.equalsIgnoreCase("fireFox")) {
			driver = new FirefoxDriver();
			logger.info("FireFox Browser launched");
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			logger.info("Edge Browser launched");
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			logger.info("Safari Browser launched");
		}			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		wait = new WebDriverWait(driver,Duration.ofSeconds(Utilities.Expilicit_Wait_TIME));
		driver.get(configProp.getProperty("url"));
		logger.info("Navigating to : " + configProp.getProperty("url"));				
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
			logger.info("----Test Execution Finished-----");
		}
	}
}
