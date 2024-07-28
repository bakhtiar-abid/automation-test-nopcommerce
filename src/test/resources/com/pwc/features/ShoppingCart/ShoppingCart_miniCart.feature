  Feature: ShoppingCart feature test of mini cart options
    Background: User logging in and going to productA's page
      Given user logging in and going to product details page of productA

        @miniCart
      Scenario: User clicking on 'item(s)' from mini cart redirects to shopping cart
        Given user clicks on add to cart from product details page
        Then user should see product is present in mini cart
        And user clicks on item(s) from mini cart
        And user should be in the shopping cart page with page title "Your store. Shopping Cart"

        @miniCart
      Scenario: User clicking on the product name from mini cart redirects to product details page
        Given user clicks on add to cart from product details page
        Then user should see product is present in mini cart
        And user clicks on productA's name
        And user should be redirected to productA's details page

        @miniCart
      Scenario: User clicking on go to cart from mini cart redirects to shopping cart
        Given user clicks on add to cart from product details page
        And user should see product is present in mini cart
        Then user clicks on go to cart from mini cart
        And user should be in the shopping cart page with page title "Your store. Shopping Cart"

        @miniCart
      Scenario: User can see product's correct quantity is displayed in mini cart
        Given user fills in quantity as 2
        And user clicks on add to cart from product details page
        Then user should see product is present in mini cart
        And user should see product's correct quantity is displayed

        @miniCart
      Scenario: User can see product's correct unit price is displayed in mini cart
        Given user fills in quantity as 2
        And user clicks on add to cart from product details page
        Then user should see product is present in mini cart
        And user should see product's correct unit price is displayed

        @miniCart
      Scenario: User can see product's correct total price is displayed in mini cart
        Given user fills in quantity as 2
        And user clicks on add to cart from product details page
        Then user should see product is present in mini cart
        And user should see product's correct sub-total price is displayed in mini cart