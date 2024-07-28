Feature: Testing My Account Change Password functionalities

  Background: A logged in user is in my account address page as new test user
    Given User perform login and go to my account change password page

  Scenario: User unable to change password without filling Old password field
    When User enter valid info without filling old password field
    And User click on change password button
    Then User should see error message "Old password is required." in old password field

  Scenario: User unable to change password without filling New password field
    When User enter valid info without filling new password field
    And User click on change password button
    Then User should see error message "Password is required." in new password field

  Scenario: User unable to change password without filling Confirm password field
    When User enter valid info without filling confirm password field
    And User click on change password button
    Then User should see error message "Password is required." in confirm password field

  Scenario: User unable to change password  with wrong password in Old password field
    When User enter valid info and wrong password in old password field
    And User click on change password button
    Then User should see error message "Old password doesn't match"

  Scenario: User unable to change password with invalid length for New password field
    When User enter valid info and invalid length password for new password field
    And User click on change password button
    Then User should see error message "must have at least 6 characters" in new password field for invalid length

  Scenario: User unable to change password with mismatching New password and Confirm password field
    When User enter valid info and mismatching password in new password and confirm password field
    And User click on change password button
    Then User should see error message "The new password and confirmation password do not match." in confirm password field

  Scenario: User change password with valid data
    When User enter valid info in all fields
    And User click on change password button
    Then User should see success message "Password was changed"