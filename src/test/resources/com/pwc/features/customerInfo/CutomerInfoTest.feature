Feature: Testing My Account Customer Info functionalities

  Background: User should be logged in and in customer info page
    Given User is logged in from a non admin account for customer info edit
    And User is in customer info page

  Scenario: User unable to edit customer info without filling First name field
    When User clears First name field in customer info page
    And User clicks on Save button in customer info page
    Then User should see error message "First name is required." in First name field of customer info page

  Scenario: User unable to edit customer info without filling Last name field
    When User clears Last Name field in customer info page
    And User clicks on Save button in customer info page
    Then User should see error message "Last name is required." in Last name field of customer info page

  Scenario: User unable to edit customer info without filling Email field
    When User clears Email field in customer info page
    And User clicks on Save button in customer info page
    Then User should see error message "Email is required." in Email field of customer info page

  Scenario: User unable to edit customer info with wrong email in Email field
    When User enters wrong email in Email field in customer info page
    And User clicks on Save button in customer info page
    Then User should see error message "Wrong email" in Email field of customer info page

  Scenario: User edit customer info with valid info
    When User enters all valid info in customer info page
    And User clicks on Save button in customer info page
    Then User should see edited information in customer info page