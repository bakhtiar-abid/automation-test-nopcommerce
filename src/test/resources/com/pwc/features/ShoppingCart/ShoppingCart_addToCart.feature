 Feature: ShoppingCart feature test for adding product to cart from product details page

   Background: User logging in
     Given go to the home page
     Then User perform login

    @addToCart
    Scenario: User is unable to add product to cart without selecting or filling up product attributes
      Given user goes to productB's page
      Then user clicks on add to cart from product details page
      And user should get a warning message "Please select RAM" and "Please select HDD"

    @addToCart
    Scenario: User is unable to add product to cart if product quantity kept less than 1
      Given user goes to productA's page
      And user fills in quantity as -1
      Then user clicks on add to cart from product details page
      And user should get a warning message "Quantity should be positive"

    @addToCart
    Scenario: User is unable to add product to cart given product quantity is more than the limit from product details page
      Given user goes to productA's page
      And user fills in quantity as 111111
      Then user clicks on add to cart from product details page
      And user should get a warning message "The maximum quantity allowed for purchase is 10000."

    @addToCart
    Scenario: User is unable to update invalid quantity of product given as input
      Given user goes to productA's page
      And user clicks on add to cart from product details page
      And user goes to cart
      Then user fills in quantity as 55555
      And user clicks on update shopping cart
      And user should get a warning message in shopping cart page "The maximum quantity allowed for purchase is 10000."

    @addToCart
    Scenario: User is unable to order less than the minimum quantity
      Given user goes to productC's page
      And user fills in quantity as 1
      Then user clicks on add to cart from product details page
      And user should get a warning message "The minimum quantity allowed for purchase is 2."

    @addToCart
    Scenario: User views cart with a product
      Given user goes to productA's page
      And user clicks on add to cart from product details page
      And user goes to cart
      Then user should see productA is present in cart

    @addToCart
    Scenario: User views cart with adding a product that has custom product attributes
      Given user goes to productB's page
      And user selects processor,ram,os and software.
      Then user clicks on add to cart from product details page
      And user goes to cart
      And user should see productB is present in cart

    @addToCart
    Scenario: User updates shopping cart by modifying quantity
      Given user goes to productA's page
      And user clicks on add to cart from product details page
      And user goes to cart
      Then user fills in quantity as 10
      And user clicks on update shopping cart
      And user should see the total price is updated