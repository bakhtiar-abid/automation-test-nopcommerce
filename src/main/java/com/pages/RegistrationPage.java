package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.managers.FileReaderManager;

public class RegistrationPage {
    Page page;
    // Take the base URL from the local.properties file
    private final String baseURL = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    public RegistrationPage(Page page){
        this.page = page;
    }

    /* Store all the --Xpath-- for the registration page here...*/
    String firstNameBoxXpath = "//input[contains(@id,'FirstName')]";
    String lastNameBoxXpath = "//input[contains(@id,'LastName')]";
    String emailBoxXpath = "//input[contains(@id,'Email')]";
    String passwordBoxXpath = "//input[contains(@id,'Password')]";
    String confirmPasswordBoxXpath = "//input[contains(@id,'ConfirmPassword')]";
    String registerButtonXpath = "//button[contains(@id,'register-button')]";
/* Error message xpath */
    String fNameRequiredMsgXpath = "//span/span[contains(@id,'FirstName-error')]";
    String lNameRequiredMsgXpath = "//span/span[contains(@id,'LastName-error')]";
    String emailRequiredMsgXpath = "//span/span[contains(@id,'Email-error')]";
    String passRequiredMsgXpath = "//span/span[contains(@id,'Password-error')]";
    String confirmPassRequiredMsgXpath = "//span/span[contains(@id,'ConfirmPassword-error')]";
    String passLengthErrorMsgXpath = "//*[contains(@id,'Password-error')]/ul/li";
    String existEmailAlertMsgXpath = "//div[contains(@class,'message-error')]/ul/li";
    String registerConfirmMsgXpath = "//div[@class='result']";

    public void fillFirstNameField(String name){
        page.fill(firstNameBoxXpath,name);
    }

    public void fillLastNameField(String name){
        page.fill(lastNameBoxXpath,name);
    }

    public void fillEmailField(String email){
        page.fill(emailBoxXpath,email);
    }

    public void fillPasswordField(String pass){
        page.fill(passwordBoxXpath,pass);
    }

    public void fillConfirmPasswordField(String pass){
        page.fill(confirmPasswordBoxXpath,pass);
    }

    public void clickRegisterButton(){
        page.click(registerButtonXpath);
        load();
    }

    public String getFirstNameRequiredMsg(){
        String text;
//        page.waitForSelector(fNameRequiredMsgXpath);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        text = page.innerText(fNameRequiredMsgXpath);
        System.out.println(text);
        return text;
    }

    public String getLastNameRequiredMsg(){
        String text;
//        page.waitForSelector(lNameRequiredMsgXpath);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        text = page.innerText(lNameRequiredMsgXpath);
        System.out.println(text);
        return text;
    }

    public String getEmailRequiredMsg(){
        String text;
//        page.waitForSelector(emailRequiredMsgXpath);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        text = page.innerText(emailRequiredMsgXpath);
        System.out.println(text);
        return text;
    }

    public String getPasswordRequiredMsg(){
        String text;
//        page.waitForSelector(passRequiredMsgXpath);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        text = page.innerText(passRequiredMsgXpath);
        System.out.println(text);
        return text;
    }

    public String getConfirmPasswordRequiredMsg(){
        String text;
//        page.waitForSelector(confirmPassRequiredMsgXpath);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        text = page.innerText(confirmPassRequiredMsgXpath);
        System.out.println(text);
        return text;
    }

    public String getPasswordLengthRequiredMsg(){
        String text;
//        page.waitForSelector(passLengthErrorMsgXpath);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        text = page.innerText(passLengthErrorMsgXpath);
        System.out.println(text);
        return text;
    }

    public String getExistEmailAlertMsg(){
        String text;
//        page.waitForSelector(existEmailAlertMsgXpath);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        text = page.innerText(existEmailAlertMsgXpath);
        System.out.println(text);
        return text;
    }

    public String getRegisterConfirmMsg(){
        String text;
//        page.waitForSelector(registerConfirmMsgXpath);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        text = page.innerText(registerConfirmMsgXpath);
        System.out.println(text);
        return text;
    }

    public void load(){
        page.waitForLoadState(LoadState.NETWORKIDLE);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.LOAD);
    }

}
