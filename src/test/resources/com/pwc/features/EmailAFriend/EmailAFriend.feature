Feature: Email a friend nopCommerce product details
  Background: Search a product and go to product details page for the every steps
    Given User Search for product from testdata and go to product details page of the product

  Scenario: A guest user can't email a friend with a registered email in 'Your email address' field
    Given Go to the email a friend page and fill all the field and click on the send button
    And "Only registered customers can use email a friend feature" alert message showing on the top

  Scenario: A guest user can't email a friend without giving a register email on the 'Your email address' field
    Given Go to the email a friend page and fill all the field with an unregistered email on the your email address field and click on the send button
    And "Only registered customers can use email a friend feature" alert message showing on the top

  Scenario: A register user can't email a friend without filling 'Friend's email' field with login
    Given User perform login
    Then Go to the email a friend page and fill all the field without Friend's email field and click on the send button
    Then Verify this "Enter friend's email" error message show bellow the Friend's email field

  Scenario: A register user can email a friend fill only required field
    Given User perform login
    Then Go to the email a friend page and fill only required field and click on the send button
    And Verify that "Your message has been sent." success message is showing on this page

  Scenario: A registered user can email a friend by filling in all the field
    Given User perform login
    Then Go to the email a friend page and fill all the field and click on the send button
    And Verify that "Your message has been sent." success message is showing on this page