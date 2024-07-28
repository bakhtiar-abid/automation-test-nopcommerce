Feature: A register customer can return the product from the order details page from the order details page

  Background: Goto the Product details page before every scenario
    Given User perform login and go to my account orders page for return request
    Then User click on the first order's details

  Scenario: A register customer can return a product if the product is returnable and order is shopped to the customer
    Given Click the return item and verify the navigated page title contains "Return Item"