package com.irctc.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {

	static String usrDir = System.getProperty("user.dir");
	static Properties pro;
	public static WebDriver driver;

	public testBase() {
		try {
			pro = new Properties();
			FileInputStream fis = new FileInputStream(
					usrDir + "\\src\\main\\java\\com\\irctc\\config\\config.properties");
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initializeDriver() {
		String browserName = pro.getProperty("browser");

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", usrDir + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Launching chrome driver");
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Launching firefox driver");
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Launching edge driver");
		}
		
		
		driver.manage().window().maximize();
		System.out.println("Maximized browser");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pro.getProperty("url"));
		
	}

}
