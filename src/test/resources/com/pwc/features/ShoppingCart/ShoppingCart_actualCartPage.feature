 Feature: ShoppingCart feature test for options of actual cart page

   Background: User logging in
     Given go to the home page
     Then User perform login

    @actualCart
    Scenario: user removes a product from cart
      Given user goes to productA's page
      And user clicks on add to cart from product details page
      And user goes to cart
      Then user clicks on remove button
      And user should get a message "Your Shopping Cart is empty!"

    @actualCart
    Scenario: user modifies a product attribute using 'Edit' option from cart
      Given user goes to productB's page
      And user selects processor,ram,os and software.
      And user clicks on add to cart from product details page
      And user goes to cart
      Then user clicks on edit option and user changes ram size
      And user clicks on add to cart from product details page
      And user goes to cart
      And user checks the updated ram is added in the cart

    @actualCart
    Scenario: user clicking on image of a product redirects to products details page from cart page
      Given user goes to productA's page
      And user clicks on add to cart from product details page
      And user goes to cart
      Then user clicks on image of the product
      And user should be redirected to productA's details page

    @actualCart
    Scenario: user clicking on product name redirects to products details page
      Given user goes to productA's page
      And user clicks on add to cart from product details page
      And user goes to cart
      Then user clicks on name of the product
      And user should be redirected to productA's details page

    @actualCart
    Scenario: user using back button after updating shopping cart does not change the cart
      Given user goes to productA's page
      And user clicks on add to cart from product details page
      And user goes to cart
      And user fills in quantity as 10
      And user clicks on update shopping cart
      Then user clicks on back button of browser
      And user should see total price is updated and not changed due to use of back button

    @actualCart
    Scenario: user selecting  gift wrapping as 'Yes' adds the extra cost in total value
      Given user goes to productA's page
      And user clicks on add to cart from product details page
      And user goes to cart
      Then user selects gift wrapping as yes
      And user checks the total value has increased

    @actualCart
    Scenario: user can see total value before checkout button is showing correct value
      Given user goes to productA's page
      And user fills in quantity as 2
      And user clicks on add to cart from product details page
      And user goes to cart
      Then user should see the total value of cart footer is showing correct value


