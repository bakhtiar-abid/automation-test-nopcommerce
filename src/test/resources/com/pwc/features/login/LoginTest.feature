Feature: Login feature test

  Background: User is in login page
    Given User is in login page


  Scenario: Login with valid Email and invalid password
    When User enter valid Email and invalid password from test data
    And User click on Login button
    Then User should unable to login and get an alert message for incorrect credentials

  Scenario: Login with invalid Email and invalid password
    When User enter invalid Email and invalid password from test data to the Email and Password field
    And User click on Login button
    Then User should unable to login and get an alert message for incorrect credentials

  Scenario: Login without filling Email field
    When Blank Email field and valid password from test data to the Password field
    And User click on Login button
    Then User should unable to login and get a warning message

  Scenario: Login without filling Password field
    When User enter valid Email and blank Password field from test data
    And User click on Login button
    Then User should unable to login and get an alert message for incorrect credentials

  Scenario: Login with wrong email in Email field
    When User enter wrong Email and valid password from test data to the Email and Password field
    And User click on Login button
    Then User should unable to login and get a warning message

  Scenario: Login with valid Email and valid password
    When User enter valid Email and valid password from test data to the Email and Password field
    And User click on Login button
    Then User should be logged in

  Scenario: Perform features
    Given User perform login
    Then User should be logged in