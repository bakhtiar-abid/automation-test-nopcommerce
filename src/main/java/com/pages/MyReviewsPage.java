package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;


public class MyReviewsPage {

    private Page page;

    //locators for my reviews page
    private final String topNavbar_My_Account_link = "//a[@class = 'ico-account']";
    private final String myAccount_My_Product_Reviews_link = "//a[text() = 'My product reviews']";
    private final String productReviews = "//div[@class = 'page-body']";


    //constructor to initialize page
    public MyReviewsPage(Page page) {
        this.page = page;
    }

    //methods for my reviews page
    public void goToMyReviewsPage() {
        page.click(topNavbar_My_Account_link);
        page.click(myAccount_My_Product_Reviews_link);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    public boolean isProductReviewsDisplayed() {
        return page.isVisible(productReviews);
    }

}
