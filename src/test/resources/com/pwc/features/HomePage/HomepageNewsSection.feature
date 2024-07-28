Feature: Homepage News: Functionality test
  Navigate to the news details page

  Background: Go to the homepage before all the scenarios
    Given go to the home page

  Scenario: Navigate to the first news of the homepage by clicking news title
    Given click on the first news title and verify the page title should be contains news title
    Then click the logo and verify if is it on the home page

  Scenario: Navigate to the first news of the homepage by clicking news details button
    Given click on the first news details button and verify the page title should be contains news title
    Then click the logo and verify if is it on the home page