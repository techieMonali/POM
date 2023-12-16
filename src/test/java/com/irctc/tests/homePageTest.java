package com.irctc.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.irctc.pages.homePage;
import com.irctc.util.testUtil;

public class homePageTest extends homePage{
	homePageTest obj;
	
	homePageTest(){
		super();
	}
	
	

	@BeforeMethod
	public void setup() {
		initializeDriver();
		obj = new homePageTest();
	}
	
	@Test(description="Launching website and verfying Heading & Logo")
	public void launchWebsiteAndVerify() {
		
		obj.closeAllPopUp();
		Assert.assertTrue(obj.verifyHeadingAndLogo());
		
	}
	
	@DataProvider
	public Object[][] getTestData() {
		Object data[][]=testUtil.getTestData("Sheet1");
		System.out.println("I was here");

		return data;
	}

	@Test(dataProvider="getTestData")
	public void addLocationsInFields(String from, String to) throws InterruptedException {
		obj.addLocations(from, to);
	}
	
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
}
