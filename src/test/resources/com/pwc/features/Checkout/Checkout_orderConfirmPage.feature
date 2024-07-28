Feature: Checkout feature test for order confirmation page

  Background: User logging in and go to checkout-order confirmation page by adding a product to cart
    Given user logs in and goes to checkout-order confirmation page with a product in cart


    @checkoutOrderConfirm
    Scenario: user can see billing address is displayed
      Given user should see the billing address section is displayed

    @checkoutOrderConfirm
    Scenario: user can see shipping address is displayed
      Given user should see the shipping address section is displayed

    @checkoutOrderConfirm
    Scenario:user can see payment method is displayed
      Given user should see the payment method section is displayed

    @checkoutOrderConfirm
    Scenario: user can see shipping method is displayed
      Given user should see the shipping method section is displayed

    @checkoutOrderConfirm
    Scenario: user can see product's sku is displayed
      Given user should see product's sku is displayed

    @checkoutOrderConfirm
    Scenario: user can see clicking on product's image redirects to product's details page
      Given user clicks on productA's image from order confirm page
      Then user should be redirected to productA's details page

    @checkoutOrderConfirm
    Scenario: user can see clicking on product's name redirects to product's details page
      Given user clicks on productA's name from order confirm page
      Then user should be redirected to productA's details page

    @checkoutOrderConfirm
    Scenario: user can see product's correct total price is displayed in the table
      Given user should see product's correct total price is displayed in the table of confirm order page

    @checkoutOrderConfirm
    Scenario: user can see product's correct quantity is displayed in the table
      Given user should see product's quantity "2" is displayed in the table of confirm order page

    @checkoutOrderConfirm
    Scenario: user can see product's correct total value is displayed in the footer section
      Given user should see the total value of cart footer is showing correct value
  @checkoutOrderConfirm
    Scenario: user can see confirm button is redirecting to order success page
      Given user clicks on confirm button
      Then user should see order success message is displayed

