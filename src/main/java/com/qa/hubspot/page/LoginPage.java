package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	WebDriver driver;

	// 1 . locators _ By

	By username = By.id("username");
	By pasword = By.id("password");
	By loginButton = By.id("loginbutton");
	By signUpLink = By.linkText("Sign Up");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// page actions:

	public String getPagetitle() {
		return driver.getTitle();
	}

	public boolean checkSignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}

	public void doLogin(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.pasword).sendKeys(password);
		driver.findElement(signUpLink).click();
	}

}
