Feature: A registered customer goto a order details page and can reorder the product by clicking re-order button

  Background: Goto the Product details page before every scenario
    Given User perform login and go to my account orders page
    Then User click on the first order's details

  Scenario: A register user can re-order a ordered product from the product details page
    Given Click on the re-order button to re-order the product from the product details page
    And Verify that the user will navigate to the cart page
