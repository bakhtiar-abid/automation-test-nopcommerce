Feature: Testing My Account Addresses functionalities

  Background: A logged in user is in my account address page
    Given User perform login and go to my account address page

  Scenario: User unable to add new address without filling First name field
    When User click on Add new address button for adding new address
    And User fill up the address form with valid value without the first name field
    And User click on Save button
    Then User should be able to see error message "First name is required." in first name field

  Scenario: User unable to add new address without filling Last name field
    When User click on Add new address button for adding new address
    And User fill up the address form with valid value without the last name field
    And User click on Save button
    Then User should be able to see error message "Last name is required." in last name field

  Scenario: User unable to add new address without filling Email field
    When User click on Add new address button for adding new address
    And User fill up the address form with valid value without the email field
    And User click on Save button
    Then User should be able to see error message "Email is required." in email field

  Scenario: User unable to add new address with wrong email in  Email field
    When User click on Add new address button for adding new address
    And User fill up the address form with wrong email in email field
    And User click on Save button
    Then User should be able to see error message "Wrong email" in email field

  Scenario: User unable to add new address selecting Country field
    When User click on Add new address button for adding new address
    And User fill up the address form without selecting country field
    And User click on Save button
    Then User should be able to see error message "Country is required." in country field

  Scenario: User unable to add new address selecting State field
    When User click on Add new address button for adding new address
    And User fill up the address form without selecting state field
    And User click on Save button
    Then User should be able to see error message "State / province is required." in state field

  Scenario: User unable to add new address without filling City field
    When User click on Add new address button for adding new address
    And User fill up the address form with valid value without the city field
    And User click on Save button
    Then User should be able to see error message "City is required" in city field

  Scenario: User unable to add new address without filling Address field
    When User click on Add new address button for adding new address
    And User fill up the address form with valid value without the address field
    And User click on Save button
    Then User should be able to see error message "Street address is required" in address field

  Scenario: User unable to add new address without filling Zip code field
    When User click on Add new address button for adding new address
    And User fill up the address form with valid value without the zip code field
    And User click on Save button
    Then User should be able to see error message "Zip / postal code is required" in zip code field

  Scenario: User unable to add new address without filling Phone field
    When User click on Add new address button for adding new address
    And User fill up the address form with valid value without the phone field
    And User click on Save button
    Then User should be able to see error message "Phone is required" in phone field

  Scenario: User add new address with all valid information
    When User click on Add new address button for adding new address
    And User fill up the address form with valid value in add new address page
    And User click on Save button
    Then User should be able to see the added address in address page

  Scenario: User unable to edit an existing address without filling First name field
    When User click on Edit button of the first address in address page
    And User clear First name field in edit address page
    And User click on Save button
    Then User should be able to see error message "First name is required." in first name field

  Scenario: User unable to edit an existing address without filling Last name field
    When User click on Edit button of the first address in address page
    And User clear Last name field in edit address page
    And User click on Save button
    Then User should be able to see error message "Last name is required." in last name field

  Scenario: User unable to edit an existing address without filling Email field
    When User click on Edit button of the first address in address page
    And User clear Email field in edit address page
    And User click on Save button
    Then User should be able to see error message "Email is required." in email field

  Scenario: User unable to edit an existing address with wrong Email format in Email field
    When User click on Edit button of the first address in address page
    And User fill in Email field with wrong Email format in edit address page
    And User click on Save button
    Then User should be able to see error message "Wrong email" in email field

  Scenario: User unable to edit an existing address without selecting Country field
    When User click on Edit button of the first address in address page
    And User clear Country field in edit address page
    And User click on Save button
    Then User should be able to see error message "Country is required." in country field

  Scenario: User unable to edit an existing address without selecting State field
    When User click on Edit button of the first address in address page
    And User clear State field in edit address page
    And User click on Save button
    Then User should be able to see error message "State / province is required." in state field

  Scenario: User unable to edit an existing address without filling City field
    When User click on Edit button of the first address in address page
    And User clear City field in edit address page
    And User click on Save button
    Then User should be able to see error message "City is required" in city field

  Scenario: User unable to edit an existing address without filling Address field
    When User click on Edit button of the first address in address page
    And User clear Address field in edit address page
    And User click on Save button
    Then User should be able to see error message "Street address is required" in address field

  Scenario: User unable to edit an existing address without filling Zip code field
    When User click on Edit button of the first address in address page
    And User clear Zip code field in edit address page
    And User click on Save button
    Then User should be able to see error message "Zip / postal code is required" in zip code field

  Scenario: User unable to edit an existing address without filling Phone field
    When User click on Edit button of the first address in address page
    And User clear Phone field in edit address page
    And User click on Save button
    Then User should be able to see error message "Phone is required" in phone field

  Scenario: User edit an existing address with all valid information
    When User click on Edit button of the first address in address page
    And User fill up the address form with valid value for edit address page
    And User click on Save button
    Then User should be able to see the edited address in address page

  Scenario: Delete an existing address
    When User click on Delete button of the first address in address page
    Then User should be able to see the deleted address is not displayed in address page