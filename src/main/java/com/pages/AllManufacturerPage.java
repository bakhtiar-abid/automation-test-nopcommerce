package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class AllManufacturerPage {

    private Page page;

    //locators for all manufacturer page
    private final String bookCategory_link = "(//a[text() = 'Books '])[1]";
    private final String viewAll_link = "(//a[text() = 'View all'])[1]";
    private final String pageTitle = "//div[@class = 'page-title']/h1";

    //constructor to initialize page
    public AllManufacturerPage(Page page) {
        this.page = page;
    }

    //methods for all manufacturer page

    public void goToHomePage(String baseUrl) {
        page.navigate(baseUrl);
    }

    public void clickOnBookCategory() {
        page.click(bookCategory_link);
    }

    public void clickOnViewAll() {
        page.click(viewAll_link);
    }

    public String getPageTitle() {
        return page.innerText(pageTitle);
    }

    public void pageLoading() {
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

}
