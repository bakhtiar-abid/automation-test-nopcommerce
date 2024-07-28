Feature: A guest can checkout product without register or login to the nopCommerce site

  Background: Search a product and add to the cart and go for checkout before every scenario
    Given User Search for product from testdata and go to product details page of the product
    Then Add the product to the cart and go for checkout

  Scenario: Checkout products and verify that a guest customer can successfully checkout
    Given Fill all the field for the billing address shipping address and select the shipping and payment methods
    Then Verify the all over product checkout complete by product price order number and product title