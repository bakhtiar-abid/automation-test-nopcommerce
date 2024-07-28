Feature: Testing nop Commerce wishlist functionalities

  Background: A user search a product and go to the product details page
    Given User Search for product from testdata and go to product details page of the product

  Scenario: User unable to update product quantity in wishlist with invalid quantity
    When User add a product to wishlist
    And User is on wishlist page
    And User update quantity of a product in wishlist with invalid quantity
    Then User should see the error message "This product is required in the quantity of 0"

  Scenario: User unable to add a product to wishlist with out of range quantity
    When User add a product to wishlist
    And User is on wishlist page
    And User update quantity of a product in wishlist with out of range quantity
    Then User should see the error message "The maximum quantity allowed for purchase is 10000."

  Scenario: User unable to add product to cart from wishlist without selecting any product
    When User add a product to wishlist
    And User is on wishlist page
    And User add product to cart from wishlist without selecting any product
    Then User should see the error message in navigation bar "No products selected to add to cart."

    Scenario: User add a product to wishlist
      When User add a product to wishlist
      And User is on wishlist page
      Then User should see the product in wishlist

    Scenario: User remove a product from wishlist with remove button
      When User add a product to wishlist
      And User is on wishlist page
      And User remove a product from wishlist with remove button
      Then User should not see the product in wishlist

    Scenario: User remove a product from wishlist by setting quantity to 0
      When User add a product to wishlist
      And User is on wishlist page
      And User remove a product from wishlist by setting quantity to 0
      Then User should not see the product in wishlist

  Scenario: User update quantity of a product in wishlist
      When User add a product to wishlist
      And User is on wishlist page
      And User update quantity of a product in wishlist
      Then User should see the updated quantity of the product in wishlist

  Scenario: User add product to cart from wishlist
    When User add a product to wishlist
    And User is on wishlist page
    And User add product to cart from wishlist
    Then User should see the product in cart