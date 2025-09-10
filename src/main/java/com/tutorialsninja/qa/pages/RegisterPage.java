package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstNameText;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox'][@value='1']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
		
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newsLetter;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement existingEmailWarningMessage;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']//following-sibling::div")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath="//input[@id='input-lastname']//following-sibling::div")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath="//input[@id='input-email']//following-sibling::div")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath="//input[@id='input-telephone']//following-sibling::div")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath="//input[@id='input-password']//following-sibling::div")
	private WebElement passwordWarningMessage;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterAnFirstName(String fname) {
		firstNameText.sendKeys(fname);		
	}
	public void enterAnLastName(String lname) {
		lastName.sendKeys(lname);		
	}
	public void enterAnemail(String email) {
		emailAddress.sendKeys(email);		
	}
	public void enterAnTelephone(String tNumber) {
		telephone.sendKeys(tNumber);		
	}
	public void enterAnPassword(String pwd) {
		password.sendKeys(pwd);		
	}
	public void enterAnConfirmPassword(String confirmpwd) {
		confirmPassword.sendKeys(confirmpwd);		
	}
	public void clickAnPrivacyPolicyCheckBox() {
		privacyPolicy.click();
	}
	public RegisterSuccessPage clickAnContinue() {
		continueButton.click();
		return new RegisterSuccessPage(driver);
	}
		
	public void clickAnNewsLetterOption() {
		newsLetter.click();
	}
	
	public String retriveAnExistingEmailWarningMessage() {
		String text=existingEmailWarningMessage.getText();
		return text;
	}
	public String retriveAnPrivacyPolicyWarningMessage() {
		String text=privacyPolicyWarningMessage.getText();
		return text;
	}
	public String retriveAnFirstNameWarningMessage() {
		String text=firstNameWarningMessage.getText();
		return text;
	}
	public String retriveAnlastNameWarningMessage() {
		String text=lastNameWarningMessage.getText();
		return text;
	}
	public String retriveAnemailWarningMessage() {
		String text=emailWarningMessage.getText();
		return text;
	}
	public String retriveAntelephoneWarningMessage() {
		String text=telephoneWarningMessage.getText();
		return text;
	}
	public String retriveAnPasswordWarningMessage() {
		String text=passwordWarningMessage.getText();
		return text;
	}
	
	
}
