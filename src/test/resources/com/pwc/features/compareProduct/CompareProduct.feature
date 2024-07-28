Feature: Nop Commerce compare products functionalities

  Background: User have products in compare product page
    Given User have two products on compare product page and on compare product page

  Scenario: User can remove one product from compare product page
    When User click on remove button
    Then User should see product removed from compare product page

  Scenario:  User can remove all products from compare product page
    When User click on clear list button
    Then User should see all products removed from compare product page

  Scenario: User unable to add more than 4 products in compare product page
    When User add more than four products in compare product page
    Then User should see previous products removed from compare product page