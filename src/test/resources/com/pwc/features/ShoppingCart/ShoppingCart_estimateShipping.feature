  Feature: ShoppingCart feature test for checking estimate shipping functionality

    Background: user logging in and going to cart after adding a product to cart
        Given user logging in and going to cart after adding a product to cart
        Then user clicks on estimate shipping

        @estimateShipping
      Scenario: while user is clicking on estimate shipping button, then entering a country and zip code displays estimated shipping cost
        Given user selects country and enters zip code
        Then user should see the shipping methods are displayed

        @estimateShipping
      Scenario: user can see a warning message without selecting country in estimate shipping
        Given user deselects the country
        Then user should get a warning message in estimate shipping "Country is required"

        @estimateShipping
      Scenario: Without writing zip/postal code in estimate shipping shows a warning message
        Given user clears zip code field
        Then user should get a warning message in estimate shipping "Zip / postal code is required"

        @estimateShipping
      Scenario: Selecting a shipping method and applying adds the cost in total value
        Given user selects country and enters zip code
        And user selects shipping method
        Then user checks the total value