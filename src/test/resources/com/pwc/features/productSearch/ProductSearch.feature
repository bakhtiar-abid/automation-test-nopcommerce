Feature: Product search for users
  Here user can search product by product name, category, manufacturer and vendor

  Background: Navigate to the search page and user is on search page
    Given Goto the home page and click the search option from the footer

  Scenario: Try to search for a product without giving any search keyword
    Given Click the search button on the search page
    And User get this "Search term minimum length is 3 characters" error message

  Scenario: Try to search for a product by giving less than three characters search keyword
    Given Fill the search box with the length of two characters on the search page
    Then Click the search button on the search page
    And User get this "Search term minimum length is 3 characters" error message

  Scenario: Try to search for a product by giving search keyword
    Given Fill the search box with a existing product name on the search page
    Then Click the search button on the search page
    And Verify the searched product is displayed

  Scenario: Enable advanced search option for searching a product more specifically
    Given Enable the advanced search option
    And Verify the advance search options a visible

  Scenario: Search a product for a specific Category, Vendor and Manufacturer in the advance search option
    Given Fill the search box with a existing product name on the search page
    Then Enable the advanced search option
    And Select the category manufacture and vendor from the dropdown option
    Then Click the search button on the search page
    And Verify the advance search product is visible

  Scenario: Verify the searched product by Display per page
    Given Fill the search box with a existing product name on the search page
    Then Enable the advanced search option
    And Select the category manufacture and vendor from the dropdown option
    Then Click the search button on the search page
    Then Select the display per page number
    And Verify the shown product number less then or equal given display per page number

  @skip
  Scenario: Scenario for search a product and navigate to the product details page
    Given User Search for product from testdata and go to product details page of the product