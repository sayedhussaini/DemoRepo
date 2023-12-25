package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;

	public WebDriver init_Driver(String browserName) {

		System.out.println("Browser Name is " + browserName);
		if (browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		} else {
			System.out.println("Broweser name " + browserName + "is not Found , Please pass the correct browser");
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();

		// driver.get(url);

		return driver;
	}

	public Properties init_properties() {
		prop = new Properties();

		String path = ".\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties";

		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {

			System.out.println("some issue with config properties ......... Please correct your config......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
