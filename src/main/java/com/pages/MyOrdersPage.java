package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class MyOrdersPage {
    private Page page;

    //locators for my orders page
    private final String topNavbar_My_Account_link = "//a[@class = 'ico-account']";
    private final String myAccount_MyOrders_link = "(//a[text() = 'Orders'])[1]";
    private final String firstOrderDetailsLink = "//button[@class = 'button-2 order-details-button']";
    private final String firstOrderReturnLink = "//button[@class = 'button-2 return-items-button']";
    private final String orderDetailsPage = "//h1[text()= 'Order information']";
    private final String returnItemPage = "//div[@class = 'page-title']";

    //constructor to initialize page
    public MyOrdersPage(Page page) {
        this.page = page;
    }

    //methods for my orders page

    public void goToMyOrdersPage() {
        page.click(topNavbar_My_Account_link);
        page.click(myAccount_MyOrders_link);
    }

    public void clickOnFirstOrderDetailsLink() {
        pageLoading();
        page.click(firstOrderDetailsLink);
    }

    public void clickOnFirstOrderReturnItemLink() {
        page.click(firstOrderReturnLink);
    }

    public boolean isOrderDetailsPageDisplayed() {
        return page.isVisible(orderDetailsPage);
    }

    public void pageLoading() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public boolean isReturnItemPageDisplayed() {
        return page.isVisible(returnItemPage);
    }

}
