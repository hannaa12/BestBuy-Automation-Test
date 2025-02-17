# Author: Hani Saravanan
# Date: Oct. 18, 2024
@StartActivation @RegressionTest
Feature: As a user, I want to select options and start activation for an Apple phone.

  Background:
    Given User navigates to the Phone page
    
  @SelectOptionsAndStartActivation
  Scenario: User selects storage, color and starts the phone activation
    When User selects the storage option
    And User selects the color option Midnight
    And User clicks the Start Activation button
    Then User should see the activation confirmation message
