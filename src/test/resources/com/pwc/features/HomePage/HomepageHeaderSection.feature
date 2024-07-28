Feature: Homepage header section: Functionality test
  Navigate all the buttons, and URLs from the homepage header section to check those are working fine

  Background: Go to the homepage before all the scenarios
    Given go to the home page

  Scenario: Navigate the 'Register' link from the Home page header
    Given click the register link from the home page header
    Then verify the page title contains "Register"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate the 'Login' link from the Home page
    Given click the login link from the home page header
    Then verify the page title contains "Login"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate the 'Logout' link from the Home page
    Given click the login link from the home page header
    And User perform login
    Then verify the logout link is visible
    Then click the logout link from the home page header and verify the login link is visible

  Scenario: Navigate the 'Wishlist' link from the Home page
    Given click the wishlist link from the home page header
    Then verify the page title contains "Wishlist"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate the 'Shopping cart' link from the Home page
    Given click the shopping cart link from the home page header
    Then verify the page title contains "Shopping cart"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate the Home page from the Home page by clicking nopCommerce logo
    Given click the logo and verify if is it on the home page