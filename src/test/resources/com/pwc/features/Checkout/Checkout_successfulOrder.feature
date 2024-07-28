  Feature: Checkout feature test for successful order place

    Background: User logging in and go to checkout-order success page by adding a product to cart
      Given user logs in and goes to checkout-order success page with a product in cart

      @checkoutOrderSuccess
      Scenario: user checks order number is displayed and clicks on order details link which redirects to order details page
        Given user should see order number is displayed
        And user clicks on order details link
        Then user should see order details page is displayed with title
