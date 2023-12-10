package com.qa.uiautomation.stepdefs;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.uiautomation.stepdefs.StepDef;
import com.qa.uiautomation.core.WebDriverFactory;
import com.qa.uiautomation.pageobjects.CmnPageObjects;
import com.qa.uiautomation.pageobjects.LandingPageObjects;
import com.qa.uiautomation.pageobjects.ProductPageObjects;
import com.qa.uiautomation.pageobjects.SignUpOrLoginPageObjects;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	private static final Logger logger = LogManager.getLogger(StepDef.class);
	private WebDriver driver;
	Scenario scn;
	LandingPageObjects landingPageObject;
	ProductPageObjects productPageObject;
	CmnPageObjects cmnPageObject;
	SignUpOrLoginPageObjects signUpOrLoginPageObject;

	@Before
	public void setUp(Scenario scn) throws Exception {
		this.scn = scn;
		String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.setWebDriverForBrowser(browserName);
		//driver = WebDriverFactory.setUpBrowser(browserName);
		landingPageObject = new LandingPageObjects(driver);
		productPageObject = new ProductPageObjects(driver);
		cmnPageObject = new CmnPageObjects(driver);
		signUpOrLoginPageObject = new SignUpOrLoginPageObjects(driver);

	}

	@After(order = 1)
	public void cleanUp() {
		WebDriverFactory.quitDriver();
		logger.info("Browser got closed");
	}

	@After(order = 2)
	public void takescreenshot() {
		WebDriverFactory.failedScnScreenshot(scn);
	}

	@Given("user navigate to the home application url {string}")
	public void user_navigate_to_the_home_application_url(String url) {
		WebDriverFactory.navigateToTheUrl(url);
		
		logger.info("user navigate to the home application url");
	}


	@Then("User Verify that home page is visible successfully")
	public void user_verify_that_home_page_is_visible_successfully() {
		landingPageObject.homePageTitle();
		logger.info("home page is visible successfully");
	}

	@Then("application logo is displayed")
	public void application_logo_is_displayed() {
		landingPageObject.validateAppLogo();
		logger.info("application log is displayed as automation excise");
	}
    
	@When("homepage headersection is visible")
	public void homepage_headersection_is_visible() {
		landingPageObject.validateHomePageBtns();
	}

	@Then("on homepage list of buttons are displayed")
	public void on_homepage_list_of_buttons_are_displayed(List<String> buttonsNameList) {

		landingPageObject.validateHomepageButtonList(buttonsNameList);
	}

	@Given("User Scroll down to footer of the page")
	public void user_scroll_down_to_footer_of_the_page() {
		landingPageObject.userscrollDownPage();
	}

	@When("After scrooling down user is able to see {string} keyword")
	public void after_scrooling_down_user_is_able_to_see_keyword(String SUBSCRIPTION) {
		landingPageObject.verifySubscriptionTxt(SUBSCRIPTION);

	}

	@When("User enter email address {string} in input")
	public void user_enter_email_address_in_input(String emailForSubscription) {
		landingPageObject.enterEmailForSubscription(emailForSubscription);
	}

	@When("User click on arrow button")
	public void user_click_on_arrow_button() {
		landingPageObject.clickArrowBtn();
		logger.info("clicked on the arrow button");
	}

	@Then("User Verify success message {string} is visible")
	public void user_verify_success_message_is_visible(String subscriptionsuccessMsg) {
		landingPageObject.verifySubscriptionSuccessMsg(subscriptionsuccessMsg);
	}

	@Given("User click on Signup\\/Login button")
	public void user_click_on_signup_login_button() {

		landingPageObject.clickOnSignUpLoginBtn();
		logger.info("clicked on the Signup button");
	}

	@When("user enters valid registered email id as {string}")
	public void user_enters_valid_registered_email_id_as(String userRegEmailIDtxt) {
		signUpOrLoginPageObject.sendTextToLoginField(userRegEmailIDtxt);
		logger.info("entered correct registered emilid as " + userRegEmailIDtxt);

	}

	@When("user enters valid password as {string}")
	public void user_enters_valid_password_as(String userRegPasswordtxt) {
		signUpOrLoginPageObject.sendTextToPasswordField(userRegPasswordtxt);
		logger.info("entered correct registered password as " + userRegPasswordtxt);
	}

	@Then("Logged in as {string} as user name just after Successful.")
	public void logged_in_as_as_user_name_just_after_successful(String loggedInUserName) {
		landingPageObject.validateUserNameLoggedInAs(loggedInUserName);

	}

	@Given("User click signup\\/login button")
	public void user_click_signup_login_button() {
		landingPageObject.clickOnSignUpLoginBtn();
		logger.info("clicked on the signup button");
	}

	@Given("User click on signup\\/login buttonn")
	public void user_click_on_signup_login_buttonn() {
		landingPageObject.clickOnSignUpLoginBtn();
		logger.info("clicked on the signup button");
	}

	@When("User enter {string}")
	public void user_enter(String usercredential) {
		signUpOrLoginPageObject.EmailIdForLogin(usercredential);
		logger.info("entered correct  emilid as " + usercredential);

	}

	@When("User enter the {string}")
	public void user_enter_the(String PwForLogin) {
		signUpOrLoginPageObject.PasswordForLogin(PwForLogin);
		logger.info("entered correct  password as " + PwForLogin);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		signUpOrLoginPageObject.clickonloginbuttn();
		logger.info("clicked on the login button");
	}

	@Then("User validate the error message {string}")
	public void user_validate_the_error_message(String ErrorMsgVisible) {
		signUpOrLoginPageObject.valErrorMsgVisible(ErrorMsgVisible);
		logger.info("error msg succefuly displayed");
	}

}
