package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertTrue;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F4_AddToCartTest_StepDef {
	
	@Given("User navigates to the Phone page")
	public void user_navigates_to_the_phone_page() {
	    
		// Navigation to Phone page
		Hooks.driver.navigate().to(DataFile.PhoneURL);
		Hooks.homePage.clickAcceptAll();
	}
	
	@When("User selects the storage option")
	public void user_selects_the_storage_option() {
	    
		// Select 256 GB option
		Hooks.phonePage.click256GBOption();
	}

	@When("User selects the color option Midnight")
	public void user_selects_the_color_option_midnight() {
		
		// Select Blue colour option
		Hooks.phonePage.clickBlueColourOption();
	    
	}

	@When("User clicks the Start Activation button")
	public void user_clicks_the_start_activation_button() {
	    
		// Click on Start Activation
		Hooks.phonePage.clickStartActivation();
	}

	@Then("User should see the activation confirmation message")
	public void user_should_see_the_activation_confirmation_message() {
	    
		// Assert comfirmation
		assertTrue(Hooks.phonePage.isActivationStarted());
	}


}
