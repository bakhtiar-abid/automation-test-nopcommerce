Feature: Homepage category section: Functionality test
  Navigate to categories from the homepage to check those are working fine

  Background: Go to the homepage before all the scenarios
    Given go to the home page

  Scenario: Navigate to the 'Books' category
    Given click on the books category
    Then verify the page title contains "Books"
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the 'Electronics > Others' category
    Given hover to the electronics category and click the other sub-category
    Then verify the page title contains "Others"
    Then click the logo and verify if is it on the home page

