  Feature: ShoppingCart feature test for checking gift card code works properly

    Background: user logging in and going to cart after adding a product to cart
        Given user logging in and going to cart after adding a product to cart

      @giftCard
      Scenario: user gets a warning message if gift card code box kept empty
        Given user clicks on add gift card
        Then user should see a warning message under gift cards box "The coupon code you entered couldn't be applied to your order"

      @giftCard
      Scenario: user unable to add invalid gift card code
        Given user inserts a invalid gift card code
        And user clicks on add gift card
        Then user should see a warning message under gift cards box "The coupon code you entered couldn't be applied to your order"

      @giftCard
      Scenario: user giving valid gift card code adds the gift card to total
        Given user inserts a valid gift card code
        And user clicks on add gift card
        And user should see the gift card is added in total value
        Then user should get a message under gift card box "The gift card code was applied"

      @giftCard
      Scenario: user can see gift card is cancelable
        Given user inserts a valid gift card code
        And user clicks on add gift card
        And user clicks on remove button of gift card
        Then user should see the gift card code is removed