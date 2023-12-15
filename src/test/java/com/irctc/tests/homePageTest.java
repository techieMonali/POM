package com.irctc.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.irctc.pages.homePage;

public class homePageTest extends homePage{
	homePageTest obj;
	
	homePageTest(){
		super();
	}

	@BeforeMethod
	public void setup() {
		initializeDriver();
		
	}
	
	@Test(description="Launching website and verfying Heading & Logo")
	public void launchWebsiteAndVerify() {
		obj = new homePageTest();
		obj.closeAllPopUp();
		Assert.assertTrue(obj.verifyHeadingAndLogo());
		
	}
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
}
