package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.managers.FileReaderManager;


public class RewardPointsPage {

    private Page page;

    //locators for reward points page
    private final String topNavbar_myAccount_link = "//a[@class = 'ico-account']";
    private final String myAccount_rewardPoints_link = "//a[text() = 'Reward points']";
    private final String rewardPointsPage_title = "//div[@class = 'page-title']";

    //constructor to initialize page
    public RewardPointsPage(Page page) {
        this.page = page;
    }

    //methods for reward points page

    public void goToMyAccountRewardPointsPage() {
        page.click(topNavbar_myAccount_link);
        page.click(myAccount_rewardPoints_link);
    }

    public boolean isRewardPointsPageTitleDisplayed() {
        return page.isVisible(rewardPointsPage_title);
    }

    public void pageLoading() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

}
