Feature: Testing My Account Return Requests page

  Background: A logged in user is in my account address page
    Given User perform login and go to my account return requests page

  Scenario: User view the list of the return requested orders
    Then User should see the list of the return requested orders


