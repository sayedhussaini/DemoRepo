package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public String doGetPageTitle() {

		try {
			return driver.getTitle();
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * this method is used to create the webelement on the basis of By locator
	 * 
	 * @param locator
	 * @return
	 */

	public WebElement getElement(By locator) {

		WebElement element = null;

		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception got occured while creating the web element ");
		}
		return element;
	}

	public void doClick(By locator) {

		try {
			getElement(locator).click();
		} catch (Exception e) {

			System.out.println("some exception occured while clicking on the webElement");
		}
	}

	public void doSendKeys(By locator, String value) {
		try {

			WebElement ele = getElement(locator);
			ele.clear();
			ele.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some Exception got occured while entering ...........");
		}
	}

	public boolean doDisplayed(By locator) {

		try {
			getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println();
		}
		return false;

	}

	public String doGetText(By locator) {
		try {

			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("some exception got occured while getting the text from a webelement........");
		}
		return null;
	}

}
