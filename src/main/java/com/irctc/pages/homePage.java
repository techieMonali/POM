package com.irctc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.junit.Assert;  

import com.irctc.base.testBase;


public class homePage extends testBase{
	
	//page factory or OR(Object repository)
	@FindBy(css="div.textheading label")
	WebElement heading;
	
	//POM
	By irctcLogo = By.xpath("//span[@class='h_logo_right_div']");
	By closeDishapopUP = By.cssSelector("#disha-banner-close");
	By cubeBox = By.xpath("//img[contains(@src,'cubebox/cross.png')]");
	By fromBox = By.xpath("//input[contains(@class,'ng-tns-c57-8')]");
	By toBox = By.xpath("//input[contains(@class,'ng-tns-c57-9')]");
	
	WebDriverWait wait;
	
	public homePage(){
		PageFactory.initElements(driver, this); //initialization required for page factory elements
	}
	
	public boolean verifyHeadingAndLogo() {
		WebElement logo = driver.findElement(irctcLogo);
		
		return logo.isDisplayed();
		//System.out.println("Logo is displayed");
	}
	
	public void closeAllPopUp() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(closeDishapopUP)));
		driver.findElement(closeDishapopUP).click();
		System.out.println("Minimized disha po-up");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cubeBox)));
		driver.findElement(cubeBox).click();
		System.out.println("Closed cube box");
	}
	
	public void addLocations(String from, String to) throws InterruptedException {
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(fromBox)));
		driver.findElement(fromBox).sendKeys(from);
		driver.findElement(toBox).sendKeys(to);
		Thread.sleep(3000);
	}
}
