package com.qa.uiautomation.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.Scenario;

public class SignUpOrLoginPageObjects {

	private WebDriver driver;
	Scenario scn;

	public SignUpOrLoginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	private By loginEmailIdField = By.xpath("//input[@placeholder='Email Address' and @data-qa='login-email']");
	private By loginPasswordField = By.xpath("//input[@placeholder='Password' and @data-qa='login-password']");
	private By loginButton = By.xpath("//button[text()='Login']");
	private By ErrorMsg = By.xpath("//p[text()='Your email or password is incorrect!']");



	public void sendTextToLoginField(String userRegEmailIDtxt) {
		WebElement loginEmailIdFieldEle = driver.findElement(loginEmailIdField);
		loginEmailIdFieldEle.sendKeys(userRegEmailIDtxt);
	}

	public void sendTextToPasswordField(String userRegPasswordtxt) {
		WebElement loginPasswordFieldEle = driver.findElement(loginPasswordField);
		loginPasswordFieldEle.sendKeys(userRegPasswordtxt);
	}

	public void clickOnLoginButton() {
		WebElement loginButtonEle = driver.findElement(loginButton);
		loginButtonEle.click();
	}

	public void EmailIdForLogin(String emailIdforLogin) {
		WebElement loginEmailIdFieldEle = driver.findElement(loginEmailIdField);
		loginEmailIdFieldEle.sendKeys(emailIdforLogin);
	}

	public void PasswordForLogin(String PwForLogin) {
		WebElement loginPasswordFieldEle = driver.findElement(loginPasswordField);
		loginPasswordFieldEle.sendKeys(PwForLogin);
	}

	public void clickonloginbuttn() {
		WebElement loginButtonEle = driver.findElement(loginButton);
		loginButtonEle.click();
	}

	public void valErrorMsgVisible(String ErrorMsgVisible) {
		WebElement ErrorMsgEle = driver.findElement(ErrorMsg);
		Assert.assertEquals(true, ErrorMsgEle.getText().contains(ErrorMsgVisible));
	}

}
