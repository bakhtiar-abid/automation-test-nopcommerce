Feature: Homepage footer section: Functionality test
  Navigate all the buttons, and URLs from the homepage footer section to check those are working fine

  Background: Go to the homepage before all the scenarios
    Given go to the home page

  Scenario: Navigate to the 'Sitemap' option from the home page footer
    Given click the "Sitemap" link from the home page footer
    Then verify the page title contains "Sitemap"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'Shipping & returns' option from the home page footer
    Given click the "Shipping & returns" link from the home page footer
    Then verify the page title contains "Shipping & returns"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'Privacy notice' option from the home page footer
    Given click the "Privacy notice" link from the home page footer
    Then verify the page title contains "Privacy notice"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'Conditions of Use' option from the home page footer
    Given click the "Conditions of Use" link from the home page footer
    Then verify the page title contains "Conditions of Use"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'About us' option from the home page footer
    Given click the "About us" link from the home page footer
    Then verify the page title contains "About us"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'Search' option from the home page footer
    Given click the "Search" link from the home page footer
    Then verify the page title contains "Search"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'News' option from the home page footer
    Given click the "News" link from the home page footer
    Then verify the page title contains "News"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'Recently viewed products' option from the home page footer
    Given click the "Recently viewed products" link from the home page footer
    Then verify the page title contains "Recently viewed products"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'Compare products list' option from the home page footer
    Given click the "Compare products list" link from the home page footer
    Then verify the page title contains "Compare products"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'New products' option from the home page footer
    Given click the "New products" link from the home page footer
    Then verify the page title contains "New products"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'My account' option from the home page footer
    Given User perform login
    And click the "My account" link from the home page footer
    Then verify the page body title contains "My account"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'Orders' option from the home page footer
    Given User perform login
    And click the "Orders" link from the home page footer
    Then verify the page body title contains "Orders"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'Addresses' option from the home page footer
    Given User perform login
    And click the "Addresses" link from the home page footer
    Then verify the page body title contains "Addresses"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'Shopping cart' option from the home page footer
    Given click the "Shopping cart" link from the home page footer
    Then verify the page title contains "Shopping cart"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'Wishlist' option from the home page footer
    Given click the "Wishlist" link from the home page footer
    Then verify the page title contains "Wishlist"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'Apply for vendor account' option from the home page footer
    Given User perform login
    And click the "Apply for vendor account" link from the home page footer
    Then verify the page title contains "Apply for vendor account"
    Then click the logo and verify if is it on the home page