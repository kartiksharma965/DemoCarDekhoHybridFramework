package com.DemoCarDekhoHybridFramework.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.DemoCarDekhoHybridFramework.qa.basePage.BasePage;

public class NewCarPage extends BasePage{

	// Creating constructor of NewCarPage class.
	public NewCarPage(WebDriver driver) {
		super(driver);
	}

	// WebElements or object of NewCarPage class.
	@FindBy(xpath="//div[normalize-space()='BMW']")
	private WebElement bmw;

	@FindBy(xpath="//div[normalize-space()='Kia']")
	private WebElement kia;

	@FindBy(xpath="//div[normalize-space()='Honda']")
	private WebElement honda;

	@FindBy(xpath="//div[normalize-space()='Toyota']")
	private WebElement toyota;

	// Methods or actions of NewCarPage class.
	public BmwCarPage goToBmw() {
		bmw.click();
		return new BmwCarPage(driver);
	}

	public ToyotaCarPage goToToyota() {
		toyota.click();
		return new ToyotaCarPage(driver);
	}

	public HondaCarPage goToHonda() {
		honda.click();
		return new HondaCarPage(driver);
	}

	public KiaCarPage goToKia() {
		kia.click();
		return new KiaCarPage(driver);
	}

}
