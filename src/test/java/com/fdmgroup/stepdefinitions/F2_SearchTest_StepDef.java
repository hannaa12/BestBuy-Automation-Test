package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F2_SearchTest_StepDef {

	@When("User enters {string} in the search bar")
	public void user_enters_in_the_search_bar(String searchKeyword) {
	    
		// assert to check if search bar is enabled
		assertTrue(Hooks.homePage.isSearchInputFieldEnabled());
		
		// send search keyword
		Hooks.homePage.searchInputField(searchKeyword);
		

	}

	@When("User clicks on the Search button")
	public void user_clicks_on_the_search_button() {
		
	    //clicks the search button
		Hooks.homePage.clickSearchButton();
	}

	@Then("User should see a list of phones displayed")
	public void user_should_see_a_list_of_phones_displayed() throws InterruptedException {
	   
		//is list displayed
		assertTrue(Hooks.searchPage.isPhoneResultsDisplayed());
	}

	@Given("User has searched for {string}")
	public void user_has_searched_for(String searchKeyword) throws InterruptedException {
		
		// do search
		user_enters_in_the_search_bar(searchKeyword);
		user_clicks_on_the_search_button();
		user_should_see_a_list_of_phones_displayed();
		
	}

	@When("User clicks on the brand dropdown")
	public void user_clicks_on_the_dropdown() {
	    
		//clicks on brand
		Hooks.searchPage.clickOnBrands();
	}

	@When("User checks the Apple brand filter checkbox")
	public void user_checks_the_brand_filter_checkbox() {
	    
		// Checks Apple checkbox
		Hooks.searchPage.checkAppleCheckbox();
	}

	@Then("User should see only Apple phones in the search results")
	public void user_should_see_only_apple_phones_in_the_search_results() {
	 
		// Verify all results
		assertTrue(Hooks.searchPage.allResultsContainApplePhones());
	}
}
