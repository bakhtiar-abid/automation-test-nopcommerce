package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.WishlistPage;
import com.qa.managers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class WishlistSteps {

    Page page = DriverFactory.getPage();

    WishlistPage wishlistPage = new WishlistPage(page);


    @When("User add a product to wishlist")
    public void userAddAProductToWishlist() {
        wishlistPage.pageLoading();
        wishlistPage.clickOnWishlistButton();
        wishlistPage.pageLoading();
    }

    @And("User is on wishlist page")
    public void userIsOnWishlistPage() {
        wishlistPage.goToWishlistPage();
        wishlistPage.pageLoading();
    }

    @Then("User should see the product in wishlist")
    public void userShouldSeeTheProductInWishlist() {
        Assertions.assertTrue(wishlistPage.isWishlistProductDisplayed());
    }

    @And("User remove a product from wishlist with remove button")
    public void userRemoveAProductFromWishlistWithRemoveButton() {
        wishlistPage.clickOnWishlistProductRemoveButton();
        wishlistPage.pageLoading();
    }

    @Then("User should not see the product in wishlist")
    public void userShouldNotSeeTheProductInWishlist() {
        Assertions.assertFalse(wishlistPage.isWishlistProductDisplayed());
    }

    @And("User remove a product from wishlist by setting quantity to {int}")
    public void userRemoveAProductFromWishlistBySettingQuantityTo(int quantity) {
        wishlistPage.setWishlistProductQuantity(quantity);
        wishlistPage.clickOnWishlistProductUpdateButton();
        wishlistPage.pageLoading();
    }

    @And("User update quantity of a product in wishlist with invalid quantity")
    public void userUpdateQuantityOfAProductInWishlistWithInvalidQuantity() {
        wishlistPage.setWishlistProductQuantity(-1);
        wishlistPage.clickOnWishlistProductUpdateButton();
        wishlistPage.pageLoading();
    }

    @And("User update quantity of a product in wishlist with out of range quantity")
    public void userUpdateQuantityOfAProductInWishlistWithOutOfRangeQuantity() {
        wishlistPage.setWishlistProductQuantity(10001);
        wishlistPage.clickOnWishlistProductUpdateButton();
        wishlistPage.pageLoading();
    }

    @And("User update quantity of a product in wishlist")
    public void userUpdateQuantityOfAProductInWishlist() {
        wishlistPage.setWishlistProductQuantity(2);
        wishlistPage.clickOnWishlistProductUpdateButton();
        wishlistPage.pageLoading();
    }

    @Then("User should see the updated quantity of the product in wishlist")
    public void userShouldSeeTheUpdatedQuantityOfTheProductInWishlist() {
        Assertions.assertEquals("2", wishlistPage.getWishlistProductQuantity());
    }

    @And("User add product to cart from wishlist without selecting any product")
    public void userAddProductToCartFromWishlistWithoutSelectingAnyProduct() {
        wishlistPage.clickOnWishlistProductAddToCartButton();
        wishlistPage.pageLoading();
    }

    @And("User add product to cart from wishlist")
    public void userAddProductToCartFromWishlist() {
        wishlistPage.clickOnWishlistProductCheckbox();
        wishlistPage.clickOnWishlistProductAddToCartButton();
        wishlistPage.pageLoading();
    }

    @Then("User should see the product in cart")
    public void userShouldSeeTheProductInCart() {
        Assertions.assertTrue(wishlistPage.isWishlistProductAddedToCart());
    }

    @Then("User should see the error message {string}")
    public void userShouldSeeTheErrorMessage(String errorMessage) {
        Assertions.assertEquals(errorMessage, wishlistPage.getWishlistProductQuantityError());
    }


    @Then("User should see the error message in navigation bar {string}")
    public void userShouldSeeTheErrorMessageInNavigationBar(String notificationMessage) {
        Assertions.assertEquals(notificationMessage, wishlistPage.getWishlistProductAddToCartError());
    }


}
