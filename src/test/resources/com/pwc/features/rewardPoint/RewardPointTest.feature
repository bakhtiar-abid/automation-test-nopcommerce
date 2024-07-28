Feature: Testing My Account Reward Points functionalities

  Background: A logged in user is in my account address page
    Given User perform login and go to my account reward points page

  Scenario: User View the reward points of the reward point page
    Then User should see the reward points

