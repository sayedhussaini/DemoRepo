package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.LoginPage;

public class LoginPageTest {

	WebDriver driver;
	BasePage base;
	Properties prop;
	LoginPage login;

	@BeforeTest

	public void setup() {

		base = new BasePage();
		prop = base.init_properties();
		String browserName = prop.getProperty("browser");
		driver = base.init_Driver(browserName);
		driver.get(prop.getProperty("url"));
		login = new LoginPage(driver);

	}

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {

		String title = login.getPagetitle();
		System.out.println("login page title is :" + title);
		Assert.assertEquals(title, "Hubspot Login");

	}

	@Test(priority = 2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(login.checkSignUpLink());
	}

	@Test(priority = 3)
	public void loginTest() {
		login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterTest

	public void tearDown() {
		
		driver.quit();

	}
}
