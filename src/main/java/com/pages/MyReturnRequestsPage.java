package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.managers.FileReaderManager;

public class MyReturnRequestsPage {

    private Page page;

    //locators for my account page
    private final String topNavbar_myAccount_link = "//a[@class = 'ico-account']";
    private final String myAccount_returnRequests_link = "//a[text() = 'Return requests']";
    private final String returnRequestsItem = "(//div[@class = 'title']/strong)[2]";

    //constructor to initialize page
    public MyReturnRequestsPage(Page page) {
        this.page = page;
    }

    //methods for my account page

    public void goToMyAccountReturnRequestsPage() {
        page.click(topNavbar_myAccount_link);
        page.click(myAccount_returnRequests_link);
    }

    public boolean isReturnRequestsItemDisplayed() {
        return page.isVisible(returnRequestsItem);
    }

    public void pageLoading() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }


}
