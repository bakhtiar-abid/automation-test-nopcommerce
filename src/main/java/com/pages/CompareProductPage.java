package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class CompareProductPage {

    private Page page;

    //locators for compare product page

    private String firstProductAddToCompare = "(//button[text() = 'Add to compare list'])[1]";
    private String secondProductAddToCompare = "(//button[text() = 'Add to compare list'])[2]";
    private String compareProductPageLink = "//a[text() = 'Compare products list']";
    private String compareListFirstProduct = "(//tr[@class = 'product-name']/td/a)[1]";
    private String compareListFourthProduct = "(//tr[@class = 'product-name']/td/a)[4]";
    private String compareListFirstProductRemoveButton = "(//button[@class = 'button-2 remove-button'])[1]";
    private String notificationMessage = "//div[@class = 'bar-notification success']";
    private String clearListButton = "//a[@class = 'clear-list']";
    private String compareListTable = "//table[@class = 'compare-products-table']";
    private String booksCategoryLink = "//a[text() = 'Books ']";
    private String jewelryCategoryLink = "//a[text() = 'Jewelry ']";
    private String giftCardsCategoryLink = "//a[text() = 'Gift Cards ']";


    //constructor to initialize page
    public CompareProductPage(Page page) {
        this.page = page;
    }

    //methods for compare product page

    public void goToHomePage(String baseUrl) {
        page.navigate(baseUrl);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void clickOnFirstProductAddToCompareButton() {
        page.click(firstProductAddToCompare);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForSelector(notificationMessage);
    }

    public void clickOnSecondProductAddToCompareButton() {
        page.click(secondProductAddToCompare);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForSelector(notificationMessage);
    }

    public void clickOnCompareProductPageLink() {
        page.click(compareProductPageLink);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public String getCompareListFirstProduct() {
        return page.innerText(compareListFirstProduct);
    }

    public String getCompareListFourthProduct() {
        return page.innerText(compareListFourthProduct);
    }

    public void clickOnCompareListFirstProductRemoveButton() {
        page.click(compareListFirstProductRemoveButton);
    }

    public void clickOnClearListButton() {
        page.click(clearListButton);
    }

    public boolean isCompareListTableDisplayed() {
        return page.isVisible(compareListTable);
    }
    public void addTwoMoreProductsToCompareList() {
        page.click(booksCategoryLink);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.click(firstProductAddToCompare);
        page.waitForSelector(notificationMessage);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.click(jewelryCategoryLink);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.click(firstProductAddToCompare);
        page.waitForSelector(notificationMessage);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);

    }

    public void addOneMoreProductToCompareList() {
        page.click(giftCardsCategoryLink);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.click(firstProductAddToCompare);
        page.waitForSelector(notificationMessage);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }


    public void pageLoading() {
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

}
