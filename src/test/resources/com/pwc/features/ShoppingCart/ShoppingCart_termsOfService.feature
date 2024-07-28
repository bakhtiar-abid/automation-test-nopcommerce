  Feature: ShoppingCart feature test for terms of service box check

    Background: user logging in and going to cart after adding a product to cart
      Given user logging in and going to cart after adding a product to cart

      @terms
      Scenario: user is unable to checkout without checking terms of service box
        Given user clicks on checkout
        Then user should see a pop-up of terms of service with warning message "Please accept the terms of service before the next step."

      @terms
      Scenario: after checking terms of service box user is allowed to checkout
        Given user clicks on checkbox of terms of service
        And user clicks on checkout
        Then user should see the checkout page loaded with title "Your store. Checkout"
      @terms
      Scenario: user clicking on 'Read' link of terms of service displays the terms of service by popping up
        Given user clicks on read link of terms of service
        Then user should see the terms of service pop-up with headline "Conditions of Use"