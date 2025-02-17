# Author: Hani Saravanan
# Date: Oct. 18, 2024
@SearchTest @RegressionTest
Feature: As a user, I want to search for an Apple phone, filter by brand.

  Background:
    Given User navigates to the Best Buy homepage

  @SearchResults
  Scenario: User successfully searches results by "phones" in the search bar and gets results
    When User enters "phones" in the search bar
    And User clicks on the Search button
    Then User should see a list of phones displayed

  @FilterByAppleBrand
  Scenario: User checks the Apple brand filter checkbox
    Given User has searched for "phones"
    When User clicks on the brand dropdown
    And User checks the Apple brand filter checkbox
    Then User should see only Apple phones in the search results