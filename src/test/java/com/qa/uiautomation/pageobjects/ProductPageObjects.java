package com.qa.uiautomation.pageobjects;




import org.junit.Assert;
import org.openqa.selenium.WebDriver;





public class ProductPageObjects {
	
	private WebDriver driver;
	
	public ProductPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locators
	
	//Methods
	public void validateProdPageTitle(String prodPageTitle)
	{
		Assert.assertEquals(true, driver.getTitle().contains(prodPageTitle));
	}
	
	
	
	
	
	
	
	
	
	
	

}
