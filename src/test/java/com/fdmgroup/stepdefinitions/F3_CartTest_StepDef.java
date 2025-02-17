package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertEquals;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F3_CartTest_StepDef {
	
	@Given("User navigates to the Best Buy homepage")
	public void user_navigates_to_the_best_buy_homepage() {
		// Navigation
		Hooks.driver.navigate().to(DataFile.BestBuyURL);
		Hooks.homePage.clickAcceptAll();
	}

	@When("User clicks on the Cart icon")
	public void user_clicks_on_the_cart_icon() {
		
		// Click on cart
		Hooks.homePage.clickCartButton();
	}

	@Then("User should see the message {string}")
	public void user_should_see_the_message(String cartMessage) throws InterruptedException {
	
		// Assert
		Thread.sleep(10000);
		assertEquals(cartMessage, Hooks.cartPage.getEmptyCartMessage());
	}

}
