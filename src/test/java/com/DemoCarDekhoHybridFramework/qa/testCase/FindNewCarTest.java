package com.DemoCarDekhoHybridFramework.qa.testCase;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.DemoCarDekhoHybridFramework.qa.basePage.BasePage;
import com.DemoCarDekhoHybridFramework.qa.baseTest.BaseTest;
import com.DemoCarDekhoHybridFramework.qa.pageObject.HomePage;
import com.DemoCarDekhoHybridFramework.qa.pageObject.NewCarPage;
import com.DemoCarDekhoHybridFramework.qa.utils.DataUtil;


public class FindNewCarTest extends BaseTest {

	
	
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	public void findNewCar(String browser, String carBrand, String carTitle, String runMode) {

		
		if(runMode.equals("N")) {
			
			throw new SkipException("Skipping the test as the Run mode is NO");
		}
		
		
		
		setUp(browser);
		HomePage home = new HomePage(driver);
		NewCarPage car = home.findNewCar();

		if (carBrand.equals("bmw")) {

			car.goToBmw();
		} else if (carBrand.equals("toyota")) {

			car.goToToyota();
		} else if (carBrand.equals("kia")) {

			car.goToKia();
		} else if (carBrand.equals("honda")) {

			car.goToHonda();
			//System.out.println(honda.getCarTitle());
			//Assert.assertEquals(carTitle, honda.getCarTitle());
	
			
		}
		
		System.out.println(BasePage.carBase.getCarTitle());
		Assert.assertEquals(carTitle, BasePage.carBase.getCarTitle());
		
	

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
