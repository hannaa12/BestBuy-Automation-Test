package com.fdmgroup.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	WebDriver driver;

	// Constructor to initialize the WebDriver and WebElements
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement list for search results (list of products)
	@FindBy(xpath = "//div[contains(@class, 'style-module_col-xs-12__TFIB5') and contains(@class, 'x-productListItem')]")
	private List<WebElement> listElements;

	// WebElement for the brands dropdown
	@FindBy(xpath = "//button[.//span[text()='Brands']]")
	private WebElement brandsDropDown;

	// WebElement for the Apple brand checkbox
	@FindBy(xpath = "//input[@id='facetFilter-Brands_APPLE']")
	private WebElement appleCheckbox;

	// WebElement list for product names
	@FindBy(xpath = "//div[@class='productItemName_3IZ3c' and @itemprop='name']")
	private List<WebElement> productNames;

	// Method to check if phone results are displayed
	public boolean isPhoneResultsDisplayed() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(listElements));
		return listElements.size() > 0;
	}

	// Method to click on the brands dropdown
	public void clickOnBrands() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(brandsDropDown));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", brandsDropDown);
		brandsDropDown.click();
	}

	// Method to check the Apple brand checkbox
	public void checkAppleCheckbox() {
		appleCheckbox.click();
	}

	// Method to verify if all displayed results contain Apple phones
	public boolean allResultsContainApplePhones() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(productNames));
		for (WebElement productName : productNames) {
			String productText = productName.getText().toLowerCase();
			if (!productText.contains("apple")) {
				return false;
			}
		}
		return true;
	}
}
