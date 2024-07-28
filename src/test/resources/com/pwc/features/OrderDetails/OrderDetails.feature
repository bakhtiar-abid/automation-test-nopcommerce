Feature: A registered customer see the order details page after purchase a product

  Background: To see order details page user should logged in before every scenario
    Given Go to the homepage and click the login button
    Then User perform login

  Scenario: A register user navigate to the order details page on the My account header section
    Given Go to the order details page from the my account on the header section and verify the order details by order number

  Scenario: A register user navigate to the order details page on the footer section
    Given Go to the order details page from the footer section and verify the order details by order number