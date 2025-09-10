
package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountButton;
	
	@FindBy(linkText ="Login")
	private WebElement loginButton;
	
	@FindBy(linkText ="Register")
	private WebElement registerButton;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//div[@id='search']//span//button")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickMyAccountOption() {
			myAccountButton.click();
	}
	
	public LoginPage clickLoginOption() {
			loginButton.click();
			return new LoginPage(driver);
	}
	public RegisterPage clickRegisterOption() {
		registerButton.click();
		return new RegisterPage(driver);
	}
	public void enterAnProductInSearchBox(String productName) {
		searchBox.sendKeys(productName);
	}
	public SearchPage clickAnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	
}
