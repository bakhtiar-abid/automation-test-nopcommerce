package com.pages;
 import com.microsoft.playwright.Page;
 import com.microsoft.playwright.options.LoadState;

public class GroupProductDetailsPage {

    private Page page;

    //locators for group product details page
    private final String homepageSearchBox = "//input[@id = 'small-searchterms']";
    private final String homepageSearchButton = "//button[@class = 'button-1 search-box-button']";
    private final String searchResultPageProductTitle = "//h2[@class = 'product-title']/a";
    private final String productDetailsPageProductName = "//div[@class = 'product-name']/h1";
    private final String productDetailsPageFirstVariantName = "(//div[@class = 'variant-name'])[1]";
    private final String productDetailsPageSecondVariantName = "(//div[@class = 'variant-name'])[2]";

    //constructor to initialize page
    public GroupProductDetailsPage(Page page) {
        this.page = page;
    }

    //methods for group product details page
    public void goToHomePage(String baseUrl) {
        page.navigate(baseUrl);
    }

    public void searchGroupProduct(String productName) {
        page.fill(homepageSearchBox, productName);
        page.click(homepageSearchButton);
    }

    public void clickOnProductTitle() {
        page.click(searchResultPageProductTitle);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    public String getProductDetailsPageProductName() {
        return page.innerText(productDetailsPageProductName);
    }

    public String getProductDetailsPageFirstVariantName() {
        return page.innerText(productDetailsPageFirstVariantName);
    }

    public String getProductDetailsPageSecondVariantName() {
        return page.innerText(productDetailsPageSecondVariantName);
    }



}