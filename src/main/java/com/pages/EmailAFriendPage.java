package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import org.apache.poi.ss.formula.functions.PPMT;

public class EmailAFriendPage {
    Page page;
    public EmailAFriendPage(Page page){
        this.page = page;
    }

    /* Xpath */
    String emailAFrirndBtnXpath = "//div[@class='email-a-friend']/button";
    String friendEmailBoxXpath = "//input[@class='friend-email']";
    String yourEmailBoxXpath = "//input[@class='your-email']";
    String msgBoxXpath = "//*[@id='PersonalMessage']";
    String sendBtnXpath = "//button[contains(@class,'send-email-a-friend-button')]";
    String friendEmailErrorXpath = "//span[contains(text(),'Enter friend')]";
    String yourEmailErrorXpath = "//*[@id='YourEmailAddress-error']";
    String sendEmailSuccessMsgXpath = "//div[@class='result']";
    String nonRegisterUserEmailAlertMsgXpath = "//div[@class='message-error validation-summary-errors']/ul/li";

    public void clickEmailAFriendBtn(){
        page.waitForLoadState(LoadState.NETWORKIDLE);
        page.click(emailAFrirndBtnXpath);
    }
    public void clickSendEmailBtn(){
        page.click(sendBtnXpath);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }
    public void fillFriendEmailField(String email){
        page.fill(friendEmailBoxXpath, email);
    }
    public void fillYourEmailField(String email){
        page.fill(yourEmailBoxXpath, email);
    }
    public void fillMsgField(String msg){
        page.fill(msgBoxXpath, msg);
    }
    public String getFriendEmailAlertMsg(){
        page.waitForLoadState(LoadState.LOAD);
        return page.innerText(friendEmailErrorXpath);
    }
    public String getYourEmailAlertMsg(){
        return page.innerText(yourEmailErrorXpath);
    }
    public String getSendEmailSuccessMsg() {
        return page.innerText(sendEmailSuccessMsgXpath);
    }
    public String getNonRegisterUsersAlertMsg(){
        return page.innerText(nonRegisterUserEmailAlertMsgXpath);
    }
}
