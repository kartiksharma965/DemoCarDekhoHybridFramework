package com.DemoCarDekhoHybridFramework.qa.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/*
 * Utilities class contains all static methods or variables that can be used across entire framework.
 */

public class Utilities {
	static public WebDriver driver;
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=10;
	public static final int Expilicit_Wait_TIME=20;
	
	public static String generateEmailWithTimeStamp() {
		Date date = new Date();
		String timeStramp=date.toString().replace(":", "_").replace(" ", "_");
		return "Shree"+timeStramp+"gmail.com";
	}
	
	public String randomString() {
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	
	public String randomNumber() {
		String generateString=RandomStringUtils.randomNumeric(10);
		return generateString;
	}
	
	public String randomAlphaNumeric() {
		String str= RandomStringUtils.randomAlphabetic(3);
		String numb=RandomStringUtils.randomNumeric(3);
		
		String randomAlphaNumeric=str+"@"+numb;
		return randomAlphaNumeric;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;
	}

}
