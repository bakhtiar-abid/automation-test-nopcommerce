Feature: User registration for nopCommerce, A guest user will register in nopCommerce site


  Background: Go to the home page and click the registration button
    Given Go to the homepage and click the registration button from the header

  @Reg
  Scenario: Guest customer unable to register with First name field empty
    Given Fill the last name field on the registration page
    Then Fill the email field on the registration page
    Then Fill the password field on the registration page
    And Fill the confirm password field on the registration page
    Then Click the register button on the registration page
    But User get an alert message "First name is required." under the first name field on the registration page

  @Reg
  Scenario: Guest customer unable to register with Last name field empty
    Given Fill the first name field on the registration page
    Then Fill the email field on the registration page
    Then Fill the password field on the registration page
    And Fill the confirm password field on the registration page
    Then Click the register button on the registration page
    But User get an alert message "Last name is required." under the last name field on the registration page

  @Reg
  Scenario: Guest customer unable to register with Email field empty
    Given Fill the first name field on the registration page
    Then Fill the last name field on the registration page
    Then Fill the password field on the registration page
    And Fill the confirm password field on the registration page
    Then Click the register button on the registration page
    But User get an alert message "Email is required." under the email field on the registration page

  @Reg
  Scenario: Guest customer unable to register with Password field empty
    Given Fill the first name field on the registration page
    Then Fill the last name field on the registration page
    Then Fill the email field on the registration page
    Then Click the register button on the registration page
    But User get an alert message "Password is required." under the password field on the registration page

  @Reg
  Scenario: Guest customer unable to register with Confirm password field empty
    Given Fill the first name field on the registration page
    Then Fill the last name field on the registration page
    Then Fill the email field on the registration page
    And Fill the password field on the registration page
    Then Click the register button on the registration page
    But User get an alert message "Password is required." under the confirm password field on the registration page

  @Reg
  Scenario: Guest customer unable to register with mismatching password and Confirm Password
    Given Fill the first name field on the registration page
    Then Fill the last name field on the registration page
    Then Fill the email field on the registration page
    And Fill the password field on the registration page
    And Fill the confirm password field with the mismatch password on the registration page
    Then Click the register button on the registration page
    But User get an alert message "The password and confirmation password do not match." under the confirm password field on the registration page

  @Reg
  Scenario: Guest customer unable to register with invalid length of password
    Given Fill the first name field on the registration page
    Then Fill the last name field on the registration page
    Then Fill the email field on the registration page
    And Fill the password field without meet minimum length on the registration page
    And Fill the confirm password field on the registration page
    Then Click the register button on the registration page
    But User get an alert message "must have at least 6 characters" under the password field on the registration page

  @Reg
  Scenario: Guest customer unable to register with a wrong email
    Given Fill the first name field on the registration page
    Then Fill the last name field on the registration page
    Then Fill the email field on the registration page with a wrong email
    Then Fill the password field on the registration page
    And Fill the confirm password field on the registration page
    Then Click the register button on the registration page
    But User get an alert message "Wrong email" under the email field on the registration page

  @Reg
  Scenario: A register user should able to register with all the valid data
    Given Fill the first name field on the registration page
    Then Fill the last name field on the registration page
    Then Fill the email field on the registration page
    And Fill the password field on the registration page
    And Fill the confirm password field on the registration page
    Then Click the register button on the registration page
    But User able to register and see "Your registration completed" register success message

  @Reg
  Scenario: Guest user should unable to register with existing email
    Given Fill the first name field on the registration page
    Then Fill the last name field on the registration page
    Then Fill the email field with existing email on the registration page
    And Fill the password field on the registration page
    And Fill the confirm password field on the registration page
    Then Click the register button on the registration page
    But User unable to register and see "The specified email already exists" alert message