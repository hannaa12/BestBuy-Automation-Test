# Author: Hani Saravanan
# Date: Oct. 18, 2024
@CartTest @RegressionTest
Feature: As a user, I want to verify that the cart is empty before adding any items so that I can proceed with shopping.

  @EmptyCart
  Scenario: User should see that the cart is empty before adding items
    Given User navigates to the Best Buy homepage
    When User clicks on the Cart icon
    Then User should see the message "Looks like it's empty!"
