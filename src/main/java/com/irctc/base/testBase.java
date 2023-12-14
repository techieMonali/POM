package com.irctc.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {
	//WebDriverManager driver = new WebDriverManager();
	static String usrDir = System.getProperty("user.dir");
	static Properties pro = new Properties();
	static WebDriver driver;
	
	testBase(){
		try {
			FileInputStream fis = new FileInputStream(usrDir+"\\src\\main\\java\\com\\irctc\\config\\config.properties");
			pro.load(fis);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initializeDriver() {
		String browserName = pro.getProperty("browser");
		
		if(browserName == "chrome") {
			//ChromeOptions chromeOptions = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		System.out.println(usrDir);
	}

	public static void main(String [] args) {
		testBase.print();
	}
}
