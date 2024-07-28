  Feature: Checkout feature test for billing address

    Background: User logging in and go to checkout-billing address page by adding a product to cart
      Given user logs in and goes to checkout-billing address page with a product in cart

        @checkoutBilling
      Scenario: user checks ship to the same address option working
        Given user clicks on ship to the same address and click on continue
        Then user should be redirected to checkout-shipping method page

      @checkoutBilling
      Scenario: user adds new address without filling first name field
         Given user selects new address from drop down menu
         And user fills up the required fields without first name field
         Then user should see "First name is required." alert message under the first name field

      @checkoutBilling
      Scenario: user adds new address without filling last name field
         Given user selects new address from drop down menu
         And user fills up the required fields without last name field
         Then user should see "Last name is required." alert message under the last name field

      @checkoutBilling
      Scenario: user adds new address without filling email field
         Given user selects new address from drop down menu
         And user fills up the required fields without email field
         Then user should see "Email is required." alert message under the email field

      @checkoutBilling
      Scenario: user adds new address with filling wrong email in email field
         Given user selects new address from drop down menu
         And user fills up the required fields with wrong email in email field
         Then user should see "Wrong email" alert message under the email field for wrong email

      @checkoutBilling
      Scenario: user adds new address without filling country field
        Given user selects new address from drop down menu
        And user fills up the required fields without selecting any country
        Then user should see 'Country is required.' alert message under the Country dropdown.
      @checkoutBilling
      Scenario: user adds new address without filling state
        Given user selects new address from drop down menu
        And user fills up the required fields without selecting any state
        Then user should see 'State / province is required.' alert message under the state field
      @checkoutBilling
      Scenario: user adds new address without filling city
        Given user selects new address from drop down menu
        And user fills up the required fields without city
        Then user should see 'City is required' alert message under the City field.
      @checkoutBilling
      Scenario: user adds new address without filling street address
        Given user selects new address from drop down menu
        And user fills up the required fields without Street address
        Then user should see 'Street address is required' alert message under the street address field
    @checkoutBilling
    Scenario: user adds new address without filling zip code
      Given user selects new address from drop down menu
      And user fills up the required fields without zip code
      Then user should see 'Zip / postal code is required' alert message under the Zip code field.
      @checkoutBilling
      Scenario: user adds new address without filling phone number
        Given user selects new address from drop down menu
        And user fills up the required fields without phone number
        Then user should see 'Phone is required' alert message under the Phone number field.
      @checkoutBilling
      Scenario: user adds new address with all valid info
        Given user selects new address from drop down menu
        And user fills up the required fields with valid info
        Then user should be redirected to checkout-shipping method page