package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	private WebElement validProductMessage;
	
	@FindBy(xpath="//input[@id='button-search']//following-sibling::p")
	private WebElement invalidProductMessage;
	
	public SearchPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAnValidProductMessageisDisplay() {
		
		boolean status=validProductMessage.isDisplayed();
		return status;
		
	}
	
	public String validateAninvalidProductMessage() {
		
		String text=invalidProductMessage.getText();
		return text;
		
		
	}
	
}
