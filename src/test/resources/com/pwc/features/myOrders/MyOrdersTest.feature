Feature: Testing My Account Orders page functionalities

  Background: A logged in user is in my account address page
    Given User perform login and go to my account orders page

  Scenario: User view the details of an existing order
    When User click on the first order's details
    Then User should be able to see the order details page

  Scenario: User navigate to return item page of an order
    When User click on the first order's return item
    Then User should be able to see the return item page