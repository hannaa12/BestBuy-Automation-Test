package com.fdmgroup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

	WebDriver driver;

	// Constructor to initialize the WebDriver and WebElements
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// WebElement for the basket icon
	@FindBy(xpath = "//a[@data-automation='x-basket']")
	private WebElement basketIcon;
	
	// WebElement for the search input field
	@FindBy(xpath = "//input[@data-automation='x-search-input']")
	private WebElement searchInputField;

	// WebElement for the search submit button
	@FindBy(xpath = "//button[@data-automation='x-search-submit']")
	private WebElement searchSubmitButton;
	
	// WebElement for the "Accept All" button (cookie consent)
	@FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement acceptAllButton;
	
	// Method to click "Accept All" button after it becomes clickable
	public void clickAcceptAll() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(acceptAllButton));
        acceptAllButton.click();
    }
	
	// Method to click the basket icon
	public void clickCartButton() {
		basketIcon.click();
	}
	
	// Method to check if the search input field is enabled
	public boolean isSearchInputFieldEnabled() {
		return searchInputField.isEnabled();
	}
	
	// Method to input a search keyword into the search field
	public void searchInputField(String searchKeyword) {
		searchInputField.sendKeys(searchKeyword);
	}

	// Method to click the search submit button
	public void clickSearchButton() {
		searchSubmitButton.click();
	}
}
