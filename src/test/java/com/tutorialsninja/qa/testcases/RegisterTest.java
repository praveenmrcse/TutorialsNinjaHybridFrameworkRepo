package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.pages.RegisterSuccessPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
	
	public RegisterTest() {
		super();
	}
	
	RegisterPage registerPage;
	RegisterSuccessPage registerSuccessPage;
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		driver=initializeTheBrowserandOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage=new HomePage(driver);
		homePage.clickMyAccountOption();
		registerPage=homePage.clickRegisterOption();
			
	}
	
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		@Test(priority = 1)
		public void registerAnAccountWithMandatoryFields() {
			
			registerPage.enterAnFirstName(dataProp.getProperty("firstName"));
			registerPage.enterAnLastName(dataProp.getProperty("lastName"));
			registerPage.enterAnemail(Utilities.generateEmailWithTimeStamp());
			registerPage.enterAnTelephone(dataProp.getProperty("telephoneNumber"));
			registerPage.enterAnPassword(prop.getProperty("validPassword"));
			registerPage.enterAnConfirmPassword(prop.getProperty("validPassword"));
			registerPage.clickAnPrivacyPolicyCheckBox();
			registerSuccessPage=registerPage.clickAnContinue();
						
			Assert.assertTrue(registerSuccessPage.retrivedAnActualRegistrationSuccessMessage().contains(dataProp.getProperty("registerSuccessMessage")),"Account is not registered");
		}
		
		@Test(priority = 2)
		public void registerAnAccountWithAllFields() {
			
			registerPage.enterAnFirstName(dataProp.getProperty("firstName"));
			registerPage.enterAnLastName(dataProp.getProperty("lastName"));
			registerPage.enterAnemail(Utilities.generateEmailWithTimeStamp());
			registerPage.enterAnTelephone(dataProp.getProperty("telephoneNumber"));
			registerPage.enterAnPassword(prop.getProperty("validPassword"));
			registerPage.enterAnConfirmPassword(prop.getProperty("validPassword"));
			registerPage.clickAnNewsLetterOption();
			registerPage.clickAnPrivacyPolicyCheckBox();
			registerSuccessPage=registerPage.clickAnContinue();
			
			Assert.assertTrue(registerSuccessPage.retrivedAnActualRegistrationSuccessMessage().contains(dataProp.getProperty("registerSuccessMessage")),"Account is not registered");
		}
		
		@Test(priority = 3)
		public void registerAnAccountWithExistingEmail() {
			
			registerPage.enterAnFirstName(dataProp.getProperty("firstName"));
			registerPage.enterAnLastName(dataProp.getProperty("lastName"));
			registerPage.enterAnemail(prop.getProperty("validEmail"));
			registerPage.enterAnTelephone(dataProp.getProperty("telephoneNumber"));
			registerPage.enterAnPassword(prop.getProperty("validPassword"));
			registerPage.enterAnConfirmPassword(prop.getProperty("validPassword"));
			registerPage.clickAnPrivacyPolicyCheckBox();
			registerSuccessPage=registerPage.clickAnContinue();
			
			Assert.assertEquals(registerPage.retriveAnExistingEmailWarningMessage(), dataProp.getProperty("exisitingEmailWarningMessage"), "Email warning message is not presented");
			
		}
		@Test(priority = 4)
		public void registerAnAccountWithoutProvidingFields() {
			
			registerPage.clickAnContinue();
			
			Assert.assertEquals(registerPage.retriveAnPrivacyPolicyWarningMessage(), dataProp.getProperty("expectedPrivacyPolicyWarningMessage"), "Privacy policy Warning Message is not presented");
			Assert.assertEquals(registerPage.retriveAnFirstNameWarningMessage(), dataProp.getProperty("expectedFirstNameWarningMessage"), "First Name Warning Message is not presented");
			Assert.assertEquals(registerPage.retriveAnlastNameWarningMessage(), dataProp.getProperty("expectedLastNameWarningMessage"), "Last Name Warning Message is not presented");
			Assert.assertEquals(registerPage.retriveAnemailWarningMessage(), dataProp.getProperty("expectedEmailWarningMessage"), "Email Warning Message is not presented");
			Assert.assertEquals(registerPage.retriveAntelephoneWarningMessage(), dataProp.getProperty("expectedTelephoneNumberWarningMessage"), "Telephone Warning Message is not presented");
			Assert.assertEquals(registerPage.retriveAnPasswordWarningMessage(), dataProp.getProperty("expectedPasswordWarningMessage"), "Password Warning Message is not presented");


		}
}
