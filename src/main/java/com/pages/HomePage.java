package com.pages;

import com.microsoft.playwright.Page;
import com.qa.managers.FileReaderManager;

public class HomePage {
    String baseURL = FileReaderManager.getInstance().getConfigReader().getBaseUrl();
    Page page;

     public HomePage(Page page){
         this.page = page;
     }
     String registerLinkXpath = "//a[@class = 'ico-register']";
     String loginLinkXpath = "//a[@class = 'ico-login']";
     String myAccountHeaderXpath = "//a[@class = 'ico-account']";
     String myAccountFooterXpath = "//ul[@class='list']/li/a[text()='My account']";
     String ordersInMyAccountXpath = "(//a[contains(text(),'Orders')])[1]";

     public void gotoHomePage(){
         page.navigate(baseURL);
     }
     public void clickLoginBtn(){
         page.click(loginLinkXpath);
     }

     public void clickRegistrationBtnFromHeader(){
         page.click(registerLinkXpath);
     }
     public void clickMyAccountBtnFromHeader(){
         page.click(myAccountHeaderXpath);
     }
     public void clickMyAccountBtnFromFooter(){
         page.click(myAccountFooterXpath);
     }
     public void clickOrdersInMyAccountPage(){
         page.click(ordersInMyAccountXpath);
     }
     public void clickOrderFromFooter(){
         page.click("//a[normalize-space()='Orders']");
     }

}
