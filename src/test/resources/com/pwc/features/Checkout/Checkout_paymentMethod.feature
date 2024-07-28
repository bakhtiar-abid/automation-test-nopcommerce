Feature: Checkout feature test for payment method

  Background: User logging in and go to checkout-payment method page by adding a product to cart
    Given user logs in and goes to checkout-payment method page with a product in cart

    @checkoutPaymentMethod
    Scenario: user uses check or money order as payment method
      Given user selects check or money order option as payment method
      Then user should see the payment info section is displayed

    @checkoutPaymentMethod
    Scenario: user uses credit card as payment method
      Given user selects credit card as payment method
      Then user should see the payment info section is displayed