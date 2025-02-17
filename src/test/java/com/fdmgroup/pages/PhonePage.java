package com.fdmgroup.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhonePage {
	
	WebDriver driver;

	// Constructor to initialize the WebDriver and WebElements
	public PhonePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// WebElement for the 256GB iPhone option
	@FindBy(xpath = "//a[contains(@class, 'link_3hcyN') and contains(@href, '15726918')]//p[contains(@data-automation, 'option-box-text') and contains(text(), '256 GB')]")
	private WebElement iphone256GBOption;

	// WebElement for the colour option
	@FindBy(xpath = "//div/div[1]/a[contains(@data-automation, 'variant-thumbnail-link')]")
	private WebElement colourOption;
	
	// WebElement for the "Start Activation" button
	@FindBy(xpath = "//div[3]/section[4]/div[4]/div/a/button[contains(@class, 'activateButton_GRXGf') and contains(., 'Start an Activation')]")
	private WebElement startActivationButton;

	// WebElement for the activation title
	@FindBy(xpath = "//h1[contains(@class, 'title_3bP-d')]")
	private WebElement activationTitle;

	// Method to click the 256GB iPhone option
	public void click256GBOption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
        wait.until(ExpectedConditions.elementToBeClickable(iphone256GBOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iphone256GBOption);
        iphone256GBOption.click();
	}
	
	// Method to click the blue colour option
	public void clickBlueColourOption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
        wait.until(ExpectedConditions.elementToBeClickable(colourOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", colourOption);
        colourOption.click();
	}
	
	// Method to click the "Start Activation" button
	public void clickStartActivation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
        wait.until(ExpectedConditions.visibilityOf(startActivationButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", startActivationButton);
		startActivationButton.click();
	}
	
	// Method to check if the activation has started
	public boolean isActivationStarted() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
        wait.until(ExpectedConditions.visibilityOf(activationTitle));
		return activationTitle.isDisplayed();
	}
}
