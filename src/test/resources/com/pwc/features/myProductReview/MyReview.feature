Feature: Testing My Account Product Review functionalities

  Background: A logged in user is in my account address page
    Given User perform login and go to my account my product reviews page

  Scenario: User should be able to see existing product reviews
    Then User view existing product reviews on my product review page
