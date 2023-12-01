package com.qa.uiautomation.pageobjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.uiautomation.ReusableUtilities.JavaScriptExecutorUtil;

import io.cucumber.java.Scenario;

public class LandingPageObjects {

	private static final Logger logger = LogManager.getLogger(LandingPageObjects.class);
	private WebDriver driver;
	private WebDriverWait wait;
	Scenario scn;
	JavaScriptExecutorUtil javaScriptExecutorUtil;

	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 15);
		javaScriptExecutorUtil = new JavaScriptExecutorUtil(driver);
	}

	
	private By landingPageLogo = By.xpath("//img[@alt='Website for automation practice']");
	private By loggedInUserNameTxt = By.xpath("//a[text()= ' Logged in as ']/b");
	private By prodBtn = By.xpath("//a[text()=' Products']");
	private By cartBtn = By.xpath("//a[text()=' Cart']");
	private By signUpBtn = By.xpath("//a[text()=' Signup / Login']");
	private By subscriptionText = By.xpath("//h2[text()='Subscription']");
	private By emailSubscription = By.xpath("//input[@id='susbscribe_email']");
	private By arrowBtn = By.xpath("//button[@id='subscribe']");
	private By successTxt = By.xpath("//div[text()='You have been successfully subscribed!']");
	private By HomepageBtns = By.xpath("//ul[@class='nav navbar-nav']");


	public void homePageTitle() {
		String expectedTitle = "Automation Exercise";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	public void validateAppLogo() {
		WebElement landingPageLogoEle = driver.findElement(landingPageLogo);
		Assert.assertEquals(true, landingPageLogoEle.isDisplayed());
	}

	public void validatehomepagebtns() {
		WebElement HomepageBtnsEle = driver.findElement(HomepageBtns);
		Assert.assertEquals(true, HomepageBtnsEle.isDisplayed());
	}

	public void clickProductsBtn() {
		WebElement prodBtnEle = driver.findElement(prodBtn);
		wait.until(ExpectedConditions.visibilityOf(prodBtnEle));
		prodBtnEle.click();
	}

	public void clickCartBtn() {
		WebElement cartBtnEle = driver.findElement(cartBtn);
		wait.until(ExpectedConditions.visibilityOf(cartBtnEle));
		cartBtnEle.click();
	}

	public void userscrollDownPage() {
		javaScriptExecutorUtil.scrollPageDown();
	}

	public void verifySubscriptionTxt(String SUBSCRIPTION) {
		WebElement subscriptionTxtEle = driver.findElement(subscriptionText);
		wait.until(ExpectedConditions.visibilityOf(subscriptionTxtEle));
		Assert.assertEquals(SUBSCRIPTION, subscriptionTxtEle.getText());
	}

	public void enterEmailForSubscription(String emailForSubscription) {
		WebElement EmailForSubscriptionEle = driver.findElement(emailSubscription);
		EmailForSubscriptionEle.sendKeys(emailForSubscription);
	}

	public void clickArrowBtn() {
		WebElement arrowBtnEle = driver.findElement(arrowBtn);
		arrowBtnEle.click();
	}

	public void verifySubscriptionSuccessMsg(String subscriptionsuccessMsg) {
		WebElement successMsgEle = driver.findElement(successTxt);
		Assert.assertEquals(subscriptionsuccessMsg, successMsgEle.getText());
	}

	public void clickOnSignUpLoginBtn() {
		WebElement signupLoginButtonEle = driver.findElement(signUpBtn);
		signupLoginButtonEle.click();
	}

	public void validateUserNameLoggedInAs(String loggedInUserName) {
		WebElement loggedInUserNameTxtEle = driver.findElement(loggedInUserNameTxt);
		Assert.assertEquals(loggedInUserName, loggedInUserNameTxtEle.getText().trim());
	}

}
