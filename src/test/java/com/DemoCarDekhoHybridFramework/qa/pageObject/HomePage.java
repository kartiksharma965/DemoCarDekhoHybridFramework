package com.DemoCarDekhoHybridFramework.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.DemoCarDekhoHybridFramework.qa.basePage.BasePage;

public class HomePage extends BasePage{

	// Constructor of HomePage class.
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// WebElements or objects of HomePage class.
	@FindBy(xpath="//div[normalize-space()='NEW CARS']")
	private WebElement newCarsMenu;
	
	@FindBy(xpath="//div[contains(text(),'Find New Cars')]")
	private WebElement findNewCars;
	
	// methods or actions of HomePage class.
	public NewCarPage findNewCar() {
		new Actions(driver).moveToElement(newCarsMenu).build().perform();
		findNewCars.click();
		return new NewCarPage(driver);
	}
}
