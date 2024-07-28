package com.pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class SimpleProductDetailsPage {

    private Page page;

    //locators for simple product details page
    private final String homepageSearchBox = "//input[@id = 'small-searchterms']";
    private final String homepageSearchButton = "//button[@class = 'button-1 search-box-button']";
    private final String searchResultPageProductTitle = "//h2[@class = 'product-title']/a";
    private final String productDetailsPageProductName = "//div[@class = 'product-name']/h1";
    private final String productDetailsPageEstimateShippingCostLink = "//div[@class = 'product-estimate-shipping']/a";
    private final String productDetailsPageEstimateShippingCostCountryDropdown = "//select[@id = 'CountryId']";
    private final String productDetailsPageEstimateShippingCostZipCodeBox = "//input[@id = 'ZipPostalCode']";
    private final String productDetailsPageEstimateShippingCostApplyButton = "//div[@class = 'apply-shipping-button-container']/button";
    private final String productDetailsPageEstimateShippingCostErrorMessage = "//div[@class = 'message-failure']";
    private final String productDetailsPageEstimateShippingCostResults = "//div[@class = 'shipping-options']";
    private final String productDetailsPageSampleDownloadLink = "//div[@class = 'download-sample']/a";
    private final String ProductDetailsPageSpecificationAttribute = "//strong[text() = 'Products specifications']";
    boolean isDownloaded = false;

    //constructor to initialize page
    public SimpleProductDetailsPage(Page page) {
        this.page = page;
    }

    //methods for simple product details page

    public void goToHomePage(String baseUrl) {
        page.navigate(baseUrl);
    }

    public void searchSimpleProduct(String productName) {
        page.fill(homepageSearchBox, productName);
        page.click(homepageSearchButton);
    }

    public void clickOnSimpleProduct() {
        page.click(searchResultPageProductTitle);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    public String getProductName() {
        return page.innerText(productDetailsPageProductName);
    }

    public void clickOnEstimateShippingCostLink() {
        page.click(productDetailsPageEstimateShippingCostLink);
    }

    public void selectCountry(String country) {
        page.selectOption(productDetailsPageEstimateShippingCostCountryDropdown, country);
    }

    public void setZipCode(String zipCode) {
        page.fill(productDetailsPageEstimateShippingCostZipCodeBox, zipCode);
    }

    public void clickOnApplyButton() {
        page.click(productDetailsPageEstimateShippingCostApplyButton);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    public String getEstimateShippingCostErrorMessage() {
        return page.innerText(productDetailsPageEstimateShippingCostErrorMessage);
    }

    public boolean isEstimateShippingCostResultsDisplayed() {
        return page.isVisible(productDetailsPageEstimateShippingCostResults);
    }

    public void clickOnSampleDownloadLink() {
        Download download = page.waitForDownload(() -> page.click(productDetailsPageSampleDownloadLink));
        download.path();
        isDownloaded = true;

    }

    public boolean isDownloaded() {
        return isDownloaded;
    }

    public boolean isSpecificationAttributeDisplayed() {
        return page.isVisible(ProductDetailsPageSpecificationAttribute);
    }
}
