 Feature: ShoppingCart feature test for a product that has price input option with range

   Background: User logging in and going to productK's page
      Given user logging in and going to product details page of productK

    @priceRangeProduct
    Scenario: user is unable to add product to cart while giving a price out of range to price input-able products
      Given user fills in the price for donation by giving a value out of range
      And user clicks on add to cart from product details page
      Then user should get a warning message "The price must be from $0.50 to $100.00"

    @priceRangeProduct
    Scenario: user can add a price input-able product to cart
      Given user fills in the price for donation
      And user clicks on add to cart from product details page
      Then user goes to cart
      And user should see productK is added to cart