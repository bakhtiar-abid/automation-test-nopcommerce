Feature: Automation for simple product's product details page

  Scenario: User Go to a simple product's product details page and check the details
    Given user is on the product details page for a simple product
    Then the user should see the products name


  Scenario: User try to estimate shipping cost without selecting county in product details page estimate shipping cost
    Given user is on the product details page for a simple product
    When user try to estimate shipping cost without selecting county
    Then the user should see the error message "Country is required"

  Scenario: User try to estimate shipping cost without filling zip code in product details page estimate shipping cost
    Given user is on the product details page for a simple product
    When user try to estimate shipping cost without filling zip code
    Then the user should see the error message "Zip / postal code is required"

  Scenario: User estimate shipping cost with valid data in product details page estimate shipping cost
    Given user is on the product details page for a simple product
    When user estimate shipping cost with valid data
    Then the user should see the shipping costs

  Scenario: User download the product's sample file
    Given user is on the product details page for a downloadable simple product
    Then user download the product's sample file

  Scenario: User see the specification attribute in product details page
    Given user is on the product details page for a simple product with specification attribute
    Then user see the specification attribute in product details page