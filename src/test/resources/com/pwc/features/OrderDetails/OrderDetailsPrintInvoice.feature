Feature: A registered customer goto a order details page and can print the order details

  Background: Goto the Product details page before every scenario
    Given User perform login and go to my account orders page
    Then User click on the first order's details

  Scenario: A register user can print a order details from the order details page by clicking Print button
    Given Click on the print button to print the order details and Verify the order details is on printing
