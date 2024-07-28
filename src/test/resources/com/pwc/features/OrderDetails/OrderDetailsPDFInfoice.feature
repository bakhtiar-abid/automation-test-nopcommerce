Feature: A registered customer goto a order details page and can download the order details pdf invoice

  Background: Goto the Product details page before every scenario
    Given User perform login and go to my account orders page
    Then User click on the first order's details

  Scenario: A register user can download a order details from the order details page by clicking PDF invoice button
    Given Click on the PDF invoice button to download the order details and Verify the order details is on downloaded
