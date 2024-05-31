package com.DemoCarDekhoHybridFramework.qa.basePage;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DemoCarDekhoHybridFramework.qa.baseTest.BaseTest;

/*
 * CarPage contain common  WebElements and actions that are used across all car pages.
 */

public class CarBase {
	
	WebDriver driver;
	BaseTest baseTest;
	
	// Constructor of CarPage class.
	public CarBase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// WebElements or object of CarPage class.
	@FindBy(xpath = "//h1[1]")
	private WebElement carTitle;
	
	@FindBy(xpath="//div[1]/div[1]/div[1]/a[1]/h3[1]")
	private List<WebElement> carNames;
	
	@FindBy(xpath="//div[1]/div[3]/div[1]/span[1]/span[1]")
	private List<WebElement> carPrices;
	
	// Methods or Actions of CarPage class.
	public String getCarTitle() {
	String title=carTitle.getText();
	return title;
	}

	//This method will fetch all carname along with there price.
	public void getCarNameandPrice() {
		
		for(int i = 0 ;i>carPrices.size();i++) {
			System.out.println("Car Name is ---> "+carNames.get(i).getText()+"----Car Price is --->"+carPrices.get(i).getText());
		}
	}
}
