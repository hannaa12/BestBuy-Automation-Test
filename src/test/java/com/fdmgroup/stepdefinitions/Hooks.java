package com.fdmgroup.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.fdmgroup.pages.CartPage;
import com.fdmgroup.pages.HomePage;
import com.fdmgroup.pages.PhonePage;
import com.fdmgroup.pages.SearchPage;
import com.fdmgroup.pages.SignInPage;
import com.fdmgroup.utilities.DriverUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	static DriverUtilities driverUtilities;
	static WebDriver driver;
	static SignInPage signInPage;
	static HomePage homePage;
	static CartPage cartPage;
	static SearchPage searchPage;
	static PhonePage phonePage;
	
	
	@Before
	public static void init() {
		
		// Setting up the driver
		driverUtilities = DriverUtilities.getInstance();
		driver = driverUtilities.getDriver();
		
		
		// Page initialization
		signInPage = new SignInPage(driver);
		cartPage = new CartPage(driver);
		homePage = new HomePage(driver);
		searchPage = new SearchPage(driver);
		phonePage = new PhonePage(driver);
		

		// Page maximize
		driver.manage().window().maximize();
		
		}
	
	@After
	public static void tearDown() {
		
		// Reset Driver
		DriverUtilities.resetDriver();
	}
}
