Feature: Testing My Account Downloadable Products functionalities

  Background: A logged in user is in my account address page
    Given User perform login and go to my account download page

  Scenario: User view the details of an existing order of the downloadable product
    When User click on the order number of a downloadable product
    Then User should be able to view the details of the order

  Scenario: User download the file of the downloadable product
    When User click on the download link of the downloadable product
    Then User should be able to download the file of the downloadable product

