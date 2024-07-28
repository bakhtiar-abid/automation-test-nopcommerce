package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.managers.FileReaderManager;

public class HomepagePage {
    Page page; /* Page */
    public HomepagePage(Page page){
        this.page = page;
    }
    //XPaths for Home page
    /* Header section xpath */
    String registerHeaderLinkXpath = "//a[@class = 'ico-register']";
    String loginLinkXpath = "//a[@class = 'ico-login']";
    String logoutLinkXpath = "//a[contains(@class,'ico-logout')]";
    String wishListLinkXpath = "//a[@class = 'ico-wishlist']";
    String shoppingCartLinkXpath = "//a[@class = 'ico-cart']";
    String homeLogoLinkXpath = "//div[contains(@class,'header-logo')]/a/img";
    String booksCategoryXpath = "//ul[contains(@class,'top-menu notmobile')]/li/a[contains(text(),'Books')]";
    String electronicCategoryXpath = "//ul[contains(@class,'top-menu notmobile')]/li/a[contains(text(),'Electronics')]";
    String electronicOthersCategoryXpath = "//ul[contains(@class,'top-menu notmobile')]/li/ul[@class='sublist first-level']/li/a[contains(text(),'Others')]";
    String detailsPageProductNameXpath = "//div[contains(@class,product-name)]/h1";
    String pageBodyTitleXpath = "//div[contains(@class,'page-title')]/h1";
    String featuredProduct1Xpath = "(//h2[@class='product-title']/a)[1]";
    String featuredProduct2Xpath = "(//h2[@class='product-title']/a)[2]";
    String featuredProduct3Xpath = "(//h2[@class='product-title']/a)[3]";
    String featuredProduct4Xpath = "(//h2[@class='product-title']/a)[4]";
    String featured3rdProductCartButtonXpath = "(//div[@class='buttons']/button[contains(@class,'product-box-add-to-cart-button')])[3]";
    String featured3rdProductCompareButtonXpath="(//div[@class='buttons']/button[contains(@class,'add-to-compare-list-button')])[3]";
    String featured3rdProductWishlistButtonXpath="(//div[@class='buttons']/button[contains(@class,'add-to-wishlist-button')])[3]";
    String topBarSuccessMsgXpath = "//p[contains(@class,'content')]";
    /* news xpath */
    String news1Xpath = "(//a[@class = 'news-title'])[1]";
    String news2Xpath = "(//a[@class = 'news-title'])[2]";
    String news3Xpath = "(//a[@class = 'news-title'])[3]";
    String news1DetailsXpath = "(//a[@class = 'read-more'])[1]";
    String news2DetailsXpath = "(//a[@class = 'read-more'])[2]";
    String news3DetailsXpath = "(//a[@class = 'read-more'])[3]";
    String newsArchiveLinkXpath = "//div[@class = 'view-all']/a";
     /* Footer section xpath */
   /*  String siteMapLinkXpath = "//a[text() = 'Sitemap']";
    String shippingAndReturnLinkXpath = "//a[text() = 'Shipping & returns']";
    String privacyNoticeLinkXpath = "//a[text() = 'Privacy notice']";
    String conditionsOfUseLinkXpath = "//a[text() = 'Conditions of Use']";
    String contactUsLinkXpath = "//a[text() = 'Contact us']";
    String aboutUsLinkXpath = "//a[text() = 'About us']";
    String searchLinkXpath = "//a[text() = 'Search']";
    String newsLinkXpath = "//a[text() = 'News']";
    String blogLinkXpath = "//a[text() = 'Blog']";
    String recentlyViewedProductsLinkXpath = "//a[text() = 'Recently viewed products']";
    String compareProductsLinkXpath = "//a[text() = 'Compare products list']";
    String newProductsLinkXpath = "//a[text() = 'New products']";
    String myAccountLinkXpath = "//a[text() = 'My account']";
    String ordersLinkXpath = "//a[text() = 'Orders']";
    String addressesLinkXpath = "//a[text() = 'Addresses']";
    String shoppingCartLinkFooterXpath = "//a[text() = 'Shopping cart']";
    String wishlistLinkFooterXpath = "//a[text() = 'Wishlist']";
    String applyForVendorAccountLinkXpath = "//a[text() = 'Apply for vendor account']";  */

    /* methods */
    public void gotoHomepage(String url){
        page.navigate(url);
    }
    public void load(){
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }
    public String getTitle(){
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return page.title();
    }

    public String getPageBodyTitle(){
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return page.innerText(pageBodyTitleXpath);
    }

    /* Click action methods */
    public void clickHomepageLogo(){
        page.click(homeLogoLinkXpath);
    }

    public void clickRegisterLinkFromHeader(){
        page.click(registerHeaderLinkXpath);
    }

    public void clickLoginLinkFromHeader(){
        page.click(loginLinkXpath);
    }
    public void clickLogoutLinkFromHeader(){
        page.click(logoutLinkXpath);
    }
    public void clickWishListFromHeader(){
        page.click(wishListLinkXpath);
    }
    public void clickFirstNewsTitle(){
        page.click(news1Xpath);
    }
    public void clickFirstNewsDetailsBtn(){
        page.click(news1DetailsXpath);
    }
    public boolean isLogoutButtonVisible(){
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return page.isVisible(logoutLinkXpath);
    }
    public boolean isLoginButtonVisible(){
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return page.isVisible(loginLinkXpath);
    }
    public void clickShoppingCartFromHeader(){
        page.click(shoppingCartLinkXpath);
    }
    public void clickBooksCategory(){
        page.click(booksCategoryXpath);
    }
    public void clickElectronicOthersCategory(){
        page.hover(electronicCategoryXpath);
        page.click(electronicOthersCategoryXpath);
    }
    public void clickFirstHomepageProduct(){
        page.click(featuredProduct1Xpath);
    }
    public String getFirstHomepageProductTitle(){
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return page.innerText(featuredProduct1Xpath);
    }
    public String getDetailsPageProductName(){
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return page.innerText(detailsPageProductNameXpath);
    }
    public String getTopBarSuccessMsg(){
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return page.innerText(topBarSuccessMsgXpath);
    }
    public String get1stNewsTitleFromHomePage(){
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return page.innerText(news1Xpath);
    }
    public void click3rdHomepageProductCartBtn(){
        page.click(featured3rdProductCartButtonXpath);
    }
    public void click3rdHomepageProductWishlistBtn(){
        page.click(featured3rdProductWishlistButtonXpath);
    }
    public void click3rdHomepageProductCompareBtn(){
        page.click(featured3rdProductCompareButtonXpath);
    }
    public void clickFooterOptions(String name){
        String xpath = "//ul[@class='list']/li/a[contains(text(),'" + name + "')]";
        page.click(xpath);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }



}
