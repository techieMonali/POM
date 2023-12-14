package com.irctc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;  

import com.irctc.base.testBase;


public class homePage extends testBase{
	
	//page factory or OR(Object repository)
	@FindBy(css="div.textheading label")
	WebElement heading;
	
	//POM
	By irctcLogo = By.xpath("//span[@class='h_logo_right_div']");

	public homePage(){
		PageFactory.initElements(driver, this); //initialization required for page factory elements
	}
	
	public void verifyHeadingAndLogo() {
		WebElement logo = driver.findElement(irctcLogo);
		
		Assert.assertTrue(logo.isDisplayed());
		System.out.println("Loggo is displayed");
	}
}
