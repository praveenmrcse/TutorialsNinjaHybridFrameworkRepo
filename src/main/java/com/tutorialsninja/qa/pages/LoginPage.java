package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailText;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordText;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Edit your account information']")
	private WebElement editYourAccountInformation;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement actualInvalidCredentialsWarningMessage;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterAnEmailText(String emailField) {
		
		emailText.sendKeys(emailField);
		
	}
	
	public void enterAnPasswordText(String passwordField) {
		
		passwordText.sendKeys(passwordField);
		
	}
	
	public void clickLoginOption() {
		loginButton.click();
	}
	
	public boolean validateEditYourAccountInformationText() {
		boolean status=editYourAccountInformation.isDisplayed();
		return status;
	}
	
	public String retirveactualInvalidCredentialsWarningMessage() {
		
		String warningMessage=actualInvalidCredentialsWarningMessage.getText();
		return warningMessage;
	}
	
}
