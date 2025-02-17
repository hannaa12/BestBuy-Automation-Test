# Author: Hani Saravanan
# Date: Oct. 18, 2024
@Login @RegressionTest
Feature: As a user, I want to test the Best Buy sign-in page to ensure proper validation for invalid input formats.

  Background: 
    Given User navigates to the Best Buy sign-in page
    And All sign-in fields should be enabled

  @InvalidEmailFormat
  Scenario Outline: User should not be able to sign in with an invalid email address format
    When User enters invalid email format "<email>"
    And Clicks the sign-in button
    Then User should see the invalid email address format alert "Please enter a valid email address."

    Examples: 
      | email           |
      | notAnEmail      | 
      | 1@missingdomain |

  @InvalidPasswordFormat
  Scenario Outline: User should not be able to sign in with an invalid password format
    When User enters valid email "<email>" and invalid password format "<password>"
    And Clicks the sign-in button
    Then User should see the invalid password format alert "Please enter your password. It must be 6 to 30 characters and contain at least one number and one letter."

    Examples: 
      | email            | password |
      | user@bestbuy.com |    12345 |
      | test@bestbuy.com | short    |

  