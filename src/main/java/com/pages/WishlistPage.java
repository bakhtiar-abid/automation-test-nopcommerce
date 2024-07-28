package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class WishlistPage {

    private Page page;

    //locators for wishlist page
    private final String wishlistButton = "//div[contains(@class,'add-to-wishlist')]/button";
    private final String topNavbar_wishlist_link = "//span[@class = 'wishlist-label']";
    private final String wishlistProduct = "//td[@class = 'product']";
    private final String wishlistProductRemoveButton = "//button[@class = 'remove-btn']";
    private final String wishlistProductQuantity = "//input[@class = 'qty-input']";
    private final String wishlistProductUpdateButton = "//button[@class = 'button-2 update-wishlist-button']";
    private final String wishlistProductQuantityError = "//div[@class = 'message-error']";
    private final String wishlistProductAddToCartButton = "//button[@class = 'button-2 wishlist-add-to-cart-button']";
    private final String notificationBar = "//p[@class = 'content']";
    private final String productCheckBox = "//input[@name = 'addtocart']";
    private final String cartPageTitle = "//h1[text() = 'Shopping cart']";


    //constructor to initialize page
    public WishlistPage(Page page) {
        this.page = page;
    }

    //methods for wishlist page

    public void clickOnWishlistButton() {
        page.click(wishlistButton);
    }

    public void pageLoading() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void goToWishlistPage() {
        page.click(topNavbar_wishlist_link);
    }

    public boolean isWishlistProductDisplayed() {
        return page.isVisible(wishlistProduct);
    }

    public void clickOnWishlistProductRemoveButton() {
        page.click(wishlistProductRemoveButton);
    }

    public void setWishlistProductQuantity(int quantity) {
        page.fill(wishlistProductQuantity, String.valueOf(quantity));
    }

    public void clickOnWishlistProductUpdateButton() {
        page.click(wishlistProductUpdateButton);
    }

    public String getWishlistProductQuantity() {
        return page.getAttribute(wishlistProductQuantity, "value");
    }


    public void clickOnWishlistProductAddToCartButton() {
        page.click(wishlistProductAddToCartButton);
    }

    public void clickOnWishlistProductCheckbox() {
        page.click(productCheckBox);
    }

    public boolean isWishlistProductAddedToCart() {
        return page.isVisible(cartPageTitle);
    }

    public String getWishlistProductQuantityError() {
        return page.innerText(wishlistProductQuantityError);
    }

    public String getWishlistProductAddToCartError() {
        return page.innerText(notificationBar);
    }

}
