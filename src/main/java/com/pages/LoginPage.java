package com.pages;

import com.microsoft.playwright.Page;


public class LoginPage {
    private Page page;

    //locators for login page
    private final String topNavbar_login_link = "//a[@class = 'ico-login']";
    private final String emailTextBox = "//input[@id = 'Email']";
    private final String passwordTextBox = "//input[@id = 'Password']";
    private final String loginButton = "//button[@class='button-1 login-button']";
    private final String logoutLink = "//a[@class = 'ico-logout']";
    private final String loginFailedAlert = "//div[@class = 'message-error validation-summary-errors']";
    private final String warningMessage = "//span[@id ='Email-error']";


    //constructor to initialize page
    public LoginPage(Page page) {
        this.page = page;
    }

    //methods for login page
    public void goToHomePage(String baseUrl) {
        page.navigate(baseUrl);
    }

    public void goToLoginPage() {
        page.click(topNavbar_login_link);
    }

    public void enterEmail(String email) {
        page.fill(emailTextBox, email);
    }

    public void enterPassword(String password) {
        page.fill(passwordTextBox, password);
    }

    public void clickOnLoginButton() {
        page.click(loginButton);
    }

    public boolean isLogoutLinkDisplayed() {
        return page.isVisible(logoutLink);
    }

    public boolean isLoginFailedAlertDisplayed() {
        return page.isVisible(loginFailedAlert);
    }

    public boolean getWarningMessageText() {
        return page.isVisible(warningMessage);
    }

}
