package com.DemoCarDekhoHybridFramework.qa.basePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
/* Rule
a) BasePage includes only constructor. 
   This will be invoked by every Page Object Class constructor (Re-usability).
b) Every Page Object Classes extends BasePage class. 
   There is Inheritance relationship between BasePage and Page Object Classes
   There Page Object classes extends from BasePage.
*/

public class BasePage {
	
	public WebDriver driver;
	public static CarBase carBase;
	
	//Constructor of BasePage class.
	public BasePage(WebDriver driver) {
		this.driver=driver;
		carBase = new CarBase(driver);
		PageFactory.initElements(driver, this);
	}

}
