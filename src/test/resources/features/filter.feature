Feature: Filter
  Background: User navigates to
  Scenario: filter Z to A
    Given dashboard saucedemo
    When select filter Z to A
    And click name Z to A
    Then user get product Z to A