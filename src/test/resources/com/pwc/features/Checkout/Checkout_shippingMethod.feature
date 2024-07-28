Feature: Checkout feature test for shipping method

  Background: User logging in and go to checkout-shipping method page by adding a product to cart
    Given user logs in and goes to checkout-shipping method page with a product in cart

    @checkoutShippingMethod
    Scenario: user uses ground method as shipping method
      Given user selects ground method as shipping method
      Then user should be redirected to checkout-payment method page

    @checkoutShippingMethod
    Scenario: user uses next day air as shipping method
      Given user selects next day air as shipping method
      Then user should be redirected to checkout-payment method page

    @checkoutShippingMethod
    Scenario: user uses 2nd day air as shipping method
      Given user selects second day air as shipping method
      Then user should be redirected to checkout-payment method page