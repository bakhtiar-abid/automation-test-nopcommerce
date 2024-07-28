  Feature: ShoppingCart feature test for product that has rental option

    Background: User logging in and going to productJ's page
      Given user logging in and going to product details page of productJ

    @rentalProduct
    Scenario: user is unable to add product to cart without giving any date in rental products
      Given user clicks on add to cart from product details page
      Then user should get a warning message "Enter rental start date"

    @rentalProduct
    Scenario: user is unable to add product to cart while giving past date in rental products
      Given user fills in start date and end date by giving a past date
      And user clicks on add to cart from product details page
      Then user should get a warning message "Rental start date should be the future date"

    @rentalProduct
    Scenario: user is adding a rental item to cart
      Given user fills in start date and end date by giving a future date
      Then user clicks on add to cart from product details page
      And user goes to cart
      And user should see the productJ is added in cart