Feature: Login
  Scenario: Success Login
    Given Halaman login saucedemo
    When Input username
    And Input password
    And click login button
    Then User in on dashboard

  Scenario: Failed Login Password
    Given Halaman login saucedemo
    When Input username
    And input empty password
    And click login button
    Then User get error message empty password