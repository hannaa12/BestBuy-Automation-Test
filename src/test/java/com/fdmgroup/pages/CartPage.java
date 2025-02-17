package com.fdmgroup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;

	// Constructor to initialize the WebDriver and WebElements
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement for the empty cart message
	@FindBy(xpath = "//div//section/div/div/h2")
	private WebElement emptyCartMessage;

	// Returns the empty cart message text
	public String getEmptyCartMessage() {
		return emptyCartMessage.getText();
	}
}
