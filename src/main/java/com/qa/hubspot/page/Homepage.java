package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class Homepage extends BasePage {

	WebDriver driver;

	ElementUtil element;

	By header = By.cssSelector("h1.private-page__title");
	By accountName = By.cssSelector("span.account-name");

	public Homepage(WebDriver driver) {
		this.driver = driver;
		element = new ElementUtil(driver);

	}

	public String getHomePageTitle() {
		return element.doGetPageTitle();
	}

	public String getHomePageHeader() {
		return element.doGetText(header);
	}

	public String getLoggedInUserAccountName() {
		return element.doGetText(accountName);
	}
}
