Feature: Recover password for the registered customers

  Background: User should be in forgot password page
    Given User got to login page and click forgot password link

  Scenario: User unable to recover password with invalid email in Your email address field
    Given User enter invalid email in Your email address field
    When User click on Retrieve password button
    Then User should see notification "Email not found."

  Scenario: User unable to recover password with  Wrong email in Your email address field
    Given User enter wrong email in Your email address field
    When User click on Retrieve password button
    Then User should see error message "Wrong email" in email field

  Scenario: User unable to recover password without filling Your email address field
    When User click on Retrieve password button
    Then User should see error message "Enter your email" in email field

  Scenario: User Recover password with valid email in Your email address field
    Given User enter valid email in Your email address field
    When User click on Retrieve password button
    Then User should see notification "Email with instructions has been sent to you."