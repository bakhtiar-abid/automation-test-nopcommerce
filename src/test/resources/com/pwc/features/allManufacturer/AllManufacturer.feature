Feature: UAT automation of NopCommerce All manufacturer

  Scenario: User navigate to all manufacturer page
    When User click on a category on the home page
    And User click on view all in the manufacturer section
    Then User should be able to see all manufacturer on "Manufacturer List" page