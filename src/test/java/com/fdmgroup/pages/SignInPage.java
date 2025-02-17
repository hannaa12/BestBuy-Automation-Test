package com.fdmgroup.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;

	// Constructor to initialize the WebDriver and WebElements
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// WebElement for the email input field
	@FindBy(xpath = "//input[contains(@id, 'username')]")
	private WebElement emailField;
	
	// WebElement for the password input field
	@FindBy(xpath = "//input[contains(@id, 'password')]")
	private WebElement passwordField;
	
	// WebElement for the sign-in button
	@FindBy(xpath = "//button[contains(@data-automation, 'sign-in-button')]")
	private WebElement signInButton;
	
	// WebElement for the email error message
	@FindBy(xpath = "//div[contains(@data-automation, 'sign-in-email-inline-error-msg')]")
	private WebElement emailErrorMessage;

	// WebElement for the password error message
	@FindBy(xpath = "//div[contains(@data-automation, 'sign-in-password-inline-error-msg')]")
	private WebElement passwordErrorMessage;

	// Method to enter email into the email field
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	// Method to enter password into the password field
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	// Method to press the enter key on the sign-in button
	public void pressEnterKey() {
		signInButton.sendKeys(Keys.ENTER);
	}

	// Method to check if the email field is enabled
	public boolean isEmailFieldEnabled() {
		return emailField.isEnabled();
	}

	// Method to check if the password field is enabled
	public boolean isPasswordFieldEnabled() {
		return passwordField.isEnabled();
	}

	// Method to get the email error message text
	public String getEmailErrorMessage() {
		return emailErrorMessage.getText();
	}
	
	// Method to get the password error message text
	public String getPasswordErrorMessage() {
		return passwordErrorMessage.getText();
	}
}
