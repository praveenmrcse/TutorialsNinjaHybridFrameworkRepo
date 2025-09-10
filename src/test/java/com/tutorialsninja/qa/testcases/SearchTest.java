package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;


//updated the code

public class SearchTest extends Base{
	
	public SearchTest() {
		super();
	}
	
	public WebDriver driver;
	SearchPage searchPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		
		driver=initializeTheBrowserandOpenApplicationURL(prop.getProperty("browserName"));
		homePage=new HomePage(driver);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void searchWithValidProductName() {
		
		homePage.enterAnProductInSearchBox(dataProp.getProperty("validProduct"));
		searchPage=homePage.clickAnSearchButton();
		
		Assert.assertTrue(searchPage.validateAnValidProductMessageisDisplay());
		
	}
	@Test(priority = 2)
	public void searchWithInvalidProductName() {
		
			homePage.enterAnProductInSearchBox(dataProp.getProperty("invalidProduct"));
			searchPage=homePage.clickAnSearchButton();
			
			
			Assert.assertEquals(searchPage.validateAninvalidProductMessage(), "abc", "Invalid Product error message is not presented");
	}
	@Test(priority = 3, dependsOnMethods = {"searchWithInvalidProductName"})
	public void searchWithNoProductName() {

		searchPage=homePage.clickAnSearchButton();
		
		Assert.assertEquals(searchPage.validateAninvalidProductMessage(), "abc", "Invalid Product error message is not presented");

}

}
