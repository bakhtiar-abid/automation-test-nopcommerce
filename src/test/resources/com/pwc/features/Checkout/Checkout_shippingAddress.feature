 Feature: Checkout feature test for shipping address

    Background: User logging in and go to checkout-shipping address page by adding a product to cart
      Given user logs in and goes to checkout-shipping address page with a product in cart

      @checkoutShipping
      Scenario: user checks pickup option in shipping address working
        Given user clicks on pickup option
        Then user should see pickup store name "New York store" with address is displayed

      @checkoutShipping
      Scenario: user adds new address without filling first name field in shipping address
        Given user selects new address from drop down menu of shipping address
        And user fills up the required fields without first name field in shipping address
        Then user should see "First name is required." alert message under the first name field in shipping address

       @checkoutShipping
      Scenario: user adds new address without filling last name field in shipping address
        Given user selects new address from drop down menu of shipping address
        And user fills up the required fields without last name field in shipping address
        Then user should see "Last name is required." alert message under the last name field in shipping address

      @checkoutShipping
      Scenario: user adds new address without filling email field in shipping address
        Given user selects new address from drop down menu of shipping address
        And user fills up the required fields without email field in shipping address
        Then user should see "Email is required." alert message under the email field in shipping address

      @checkoutShipping
      Scenario: user adds new address with filling wrong email in email field in shipping address
        Given user selects new address from drop down menu of shipping address
        And user fills up the required fields with wrong email in email field in shipping address
        Then user should see "Wrong email" alert message under the email field for wrong email in shipping address

      @checkoutShipping
      Scenario: user adds new address without filling country field in shipping address
        Given user selects new address from drop down menu of shipping address
        And user fills up the required fields without selecting any country in shipping address
        Then user should see 'Country is required.' alert message under the Country dropdown in shipping address

      @checkoutShipping
      Scenario: user adds new address without filling state in shipping address
        Given user selects new address from drop down menu of shipping address
        And user fills up the required fields without selecting any state in shipping address
        Then user should see 'State / province is required.' alert message under the state field in shipping address

      @checkoutShipping
      Scenario: user adds new address without filling city in shipping address
        Given user selects new address from drop down menu of shipping address
        And user fills up the required fields without city in shipping address
        Then user should see 'City is required' alert message under the City field in shipping address

      @checkoutShipping
      Scenario: user adds new address without filling street address in shipping address
        Given user selects new address from drop down menu of shipping address
        And user fills up the required fields without Street address in shipping address
        Then user should see 'Street address is required' alert message under the street address field in shipping address

      @checkoutShipping
      Scenario: user adds new address without filling zip code in shipping address
        Given user selects new address from drop down menu of shipping address
        And user fills up the required fields without zip code in shipping address
        Then user should see 'Zip / postal code is required' alert message under the Zip code field in shipping address

      @checkoutShipping
      Scenario: user adds new address without filling phone number in shipping address
        Given user selects new address from drop down menu of shipping address
        And user fills up the required fields without phone number in shipping address
        Then user should see 'Phone is required' alert message under the Phone number field in shipping address

      @checkoutShipping
      Scenario: user adds new address with all valid info in shipping address
        Given user selects new address from drop down menu of shipping address
        And user fills up the required fields with valid info in shipping address
        Then user should be redirected to checkout-shipping method page

      @checkoutShipping
      Scenario: user checks using an existing address works
        Given user uses existing address and clicks continue
        Then user should be redirected to checkout-shipping method page