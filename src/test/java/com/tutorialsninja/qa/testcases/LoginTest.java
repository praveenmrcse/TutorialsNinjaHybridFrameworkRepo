package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base{
	
	public LoginTest() {
		super();
	}
	
	public WebDriver driver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		
		driver=initializeTheBrowserandOpenApplicationURL(prop.getProperty("browserName"));
		
		HomePage homePage=new HomePage(driver);
		homePage.clickMyAccountOption();
		loginPage=homePage.clickLoginOption();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(priority = 1, dataProvider="supplyTestData")
	public void verifyLoginWithValidCredentials(String email, String password) {
		
		loginPage.enterAnEmailText(email);
		loginPage.enterAnPasswordText(password);
		loginPage.clickLoginOption();
		
		Assert.assertTrue(loginPage.validateEditYourAccountInformationText(),"Edit Your Account Information is not displayed");
		
			
	}
	@DataProvider
	public Object[][] supplyTestData() {
		
		Object[][] data= Utilities.supplyTestDataFromExcel("Login");
		return data;
		
	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		
		loginPage.enterAnEmailText(Utilities.generateEmailWithTimeStamp());
		loginPage.enterAnPasswordText(dataProp.getProperty("invalidPassword"));
		loginPage.clickLoginOption();
		
		Assert.assertTrue(loginPage.retirveactualInvalidCredentialsWarningMessage().contains(dataProp.getProperty("invalidCredentialsWarningMessage")), "The Warning message is not displayed");
		
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidPassword() {
		
		loginPage.enterAnEmailText(prop.getProperty("validEmail"));
		loginPage.enterAnPasswordText(dataProp.getProperty("invalidPassword"));
		loginPage.clickLoginOption();
		
		Assert.assertTrue(loginPage.retirveactualInvalidCredentialsWarningMessage().contains(dataProp.getProperty("invalidCredentialsWarningMessage")), "The Warning message is not displayed");
				
		
	}
	
	@Test(priority=4)
	public void verifyLoginwithInvalidEmail() {
		
		loginPage.enterAnEmailText(Utilities.generateEmailWithTimeStamp());
		loginPage.enterAnPasswordText(prop.getProperty("validPassword"));
		loginPage.clickLoginOption();
		
		Assert.assertTrue(loginPage.retirveactualInvalidCredentialsWarningMessage().contains(dataProp.getProperty("invalidCredentialsWarningMessage")), "The Warning message is not displayed");
		
	}
	
	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials() {
		
		loginPage.clickLoginOption();
		
		Assert.assertTrue(loginPage.retirveactualInvalidCredentialsWarningMessage().contains(dataProp.getProperty("invalidCredentialsWarningMessage")), "The Warning message is not displayed");
		
	}
	
}
