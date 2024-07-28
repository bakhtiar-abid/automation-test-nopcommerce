Feature: Homepage products: Functionality test
  Navigate to the product details page and check the functionality of the product is working or not

  Background: Go to the homepage before all the scenarios
    Given go to the home page

  Scenario: Navigate to the product details page from the home page
    Given go to the first product from the home page and verify the product name from the product details page
    Then click the logo and verify if is it on the home page

  Scenario: Add product to the cart from the home page showing product
    Given click add to cart button for the third product on the home page
    And verify "The product has been added to your shopping cart" message visible at the top

  Scenario: Add product to the compare list from the home page showing the product
    Given click compare button for the third product on the home page
    And verify "The product has been added to your product comparison" message visible at the top

  Scenario: Add product to the wish list from the home page showing the product
    Given click wish list button for the third product on the home page
    And verify "The product has been added to your wishlist" message visible at the top