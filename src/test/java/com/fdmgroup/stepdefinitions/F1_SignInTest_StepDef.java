package com.fdmgroup.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.fdmgroup.data.DataFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class F1_SignInTest_StepDef {

	@Given("User navigates to the Best Buy sign-in page")
	public void user_navigates_to_the_best_buy_sign_in_page() {

		// Navigation
		Hooks.driver.navigate().to(DataFile.SigInURL);
	}

	@Given("All sign-in fields should be enabled")
	public void all_sign_in_fields_should_be_displayed() {

		// Assert
		assertTrue(Hooks.signInPage.isEmailFieldEnabled());
		assertTrue(Hooks.signInPage.isPasswordFieldEnabled());
	}

	@When("User enters invalid email format {string}")
	public void user_enters_invalid_email_and_a_valid_password(String email) {

		// Send email
		Hooks.signInPage.enterEmail(email);
	}

	@When("Clicks the sign-in button")
	public void clicks_the_sign_in_button() {

		// Clicks button
		Hooks.signInPage.pressEnterKey();
	}

	@Then("User should see the invalid email address format alert {string}")
	public void user_should_see_the_email_alert(String alertMessage) {

		// Assert
		assertEquals(alertMessage, Hooks.signInPage.getEmailErrorMessage());
	}

	@When("User enters valid email {string} and invalid password format {string}")
	public void user_enters_valid_email_and_invalid_password(String email, String password) {

		// Send email
		Hooks.signInPage.enterEmail(email);

		// Send password
		Hooks.signInPage.enterPassword(password);
	}

	@Then("User should see the invalid password format alert {string}")
	public void user_should_see_the_password_alert(String alertMessage) {

		// Assert
		assertEquals(alertMessage, Hooks.signInPage.getPasswordErrorMessage());
	}

}
