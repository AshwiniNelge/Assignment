package com.qa.uiautomation.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CmnPageObjects {

	private WebDriver driver;
	private WebDriverWait wait;

	public CmnPageObjects(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
	}

	// Methods
	public void verifycartPageTitle(String cartPageTitle) {
		Assert.assertEquals(true, driver.getTitle().contains(cartPageTitle));
	}

}
