 Feature: ShoppingCart feature test for different type of products which is getting added to cart or not

   Background: User logging in
     Given go to the home page
     Then User perform login

      @differentProducts
    Scenario: Add a virtual gift card to cart
      Given user goes to productD's page
      And user fills in all the required fields of productD
      Then user clicks on add to cart from product details page
      And user goes to cart
      And user should see productD is present in cart

      @differentProducts
    Scenario: Add a grouped product to cart
      Given user goes to productE's page
      And user clicks on add to cart from product details page
      Then user goes to cart
      And user should see productE - Black is added to cart

      @differentProducts
    Scenario: Add a physical gift card to cart
      Given user goes to productF
      And user fills in required fields of physical gift card
      And user clicks on add to cart from product details page
      Then user goes to cart
      And user should see the productF is added to cart

      @differentProducts
    Scenario: Add a product that has print selectable option to cart
      Given user goes to productG's page
      And user selects size, color and print
      And user clicks on add to cart from product details page
      Then user goes to cart
      And user should see productG is added to cart

      @differentProducts
    Scenario: Add a product to cart that has tier pricing
      Given user goes to productH's page
      And user fills in quantity as 3
      And user clicks on add to cart from product details page
      Then user goes to cart
      And user should see the price is reduced and calculated using the tier price

      @differentProducts
    Scenario: Add a recurring product to cart
      Given user goes to productI's page
      And user clicks on add to cart from product details page
      Then user goes to cart
      And user should see productI is added to cart
