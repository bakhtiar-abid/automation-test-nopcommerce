 Feature: ShoppingCart feature test for checking discount code works properly

   Background: user logging in and going to cart after adding a product to cart
     Given user logging in and going to cart after adding a product to cart

      @discount
    Scenario: user is unable to add invalid discount code
      Given user inserts a invalid discount code
      And user clicks on apply coupon
      Then user should see a warning message under discount box "The coupon code cannot be found"

      @discount
    Scenario: user gets a warning message if discount code box kept empty
      Given user clicks on apply coupon
      Then user should see a warning message under discount box "The coupon code is empty"

      @discount
    Scenario: user is giving valid discount code which adds the discount to total
      Given user inserts a valid discount code
      And user clicks on apply coupon
      And user should see the discount is added in total value
      Then user should get a message under discount box "The coupon code was applied"

      @discount
    Scenario: user can cancel discount code
      Given user inserts a valid discount code
      And user clicks on apply coupon
      And user clicks on remove button of discount code
      Then user should see the discount code is removed

      @discount
    Scenario: after adding discount if user again adds another product, the discount does not get canceled
      Given user inserts a valid discount code
      And user clicks on apply coupon
      And user clicks on continue shopping
      And user goes to productC's page
      Then user clicks on add to cart from product details page
      And user goes to cart
      And user should see the discount is still there

      @discount
    Scenario: Giving valid discount code and gift card code at the same time works
      Given user inserts a valid discount code
      And user clicks on apply coupon
      And user inserts a valid gift card code
      And user clicks on add gift card
      Then user can see both gift card and discount code added