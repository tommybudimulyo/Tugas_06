Feature: Checkout
  Scenario: checkout cart
    Given cart page
    When click checkout button
    And input first name last name and postal code
    And click countinue
    And click finish
    Then user finish checkout