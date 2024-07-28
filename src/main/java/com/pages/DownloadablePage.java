package com.pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;


public class DownloadablePage {
    private Page page;

    //locators for downloadable page
    private final String topNavbar_My_Account_link = "//a[@class = 'ico-account']";
    private final String downloadableProductPage_link = "//a[text() = 'Downloadable products']";
    private final String downloadLink = "//td[@class = 'download']/div/a";
    private final String firstProductOrderDetailsLink = "//td[@class = 'order']/a";
    private final String orderDetailsPage = "//h1[text()= 'Order information']";
    boolean isDownloaded = false;

    //constructor to initialize page
    public DownloadablePage(Page page) {
        this.page = page;
    }

    //methods for downloadable page

    public void goToDownloadableProductPage() {
        page.click(topNavbar_My_Account_link);
        page.click(downloadableProductPage_link);
    }

    public void clickOnDownloadLink() {
        page.click(downloadLink);
    }

    public void clickOnFirstProductOrderDetailsLink() {
        page.click(firstProductOrderDetailsLink);
    }

    public boolean isOrderDetailsPageDisplayed() {
        return page.isVisible(orderDetailsPage);
    }

    public void pageLoading() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    public void downloadProduct() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        Download download = page.waitForDownload(() -> {
            page.click(downloadLink);
        });
        isDownloaded = true;
    }

    public boolean isDownloaded() {
        return isDownloaded;
    }
}
