package com.pages;

import com.microsoft.playwright.Page;
import com.qa.managers.FileReaderManager;

public class PasswordRecoveryPage {
    private Page page;

    //locators for password recovery page
    private final String forgotPasswordLink = "//a[text() = 'Forgot password?']";
    private final String emailTextBox = "//input[@id = 'Email']";
    private final String recoveryButton = "//button[@class='button-1 password-recovery-button']";
    private final String emailFieldErrorMessage = "//span[@id = 'Email-error']";
    private final String notificationMessage = "//p[@class = 'content']";


    //constructor to initialize page
    public PasswordRecoveryPage(Page page) {
        this.page = page;
    }

    //methods for password recovery page

    public void clickForgotPasswordLink() {
        page.click(forgotPasswordLink);
    }

    public void enterEmail(String email) {
        page.fill(emailTextBox, email);
    }

    public void clickOnSendPasswordRecoveryEmailButton() {
        page.click(recoveryButton);
    }

    public String emailError() {
        return page.innerText(emailFieldErrorMessage);
    }

    public String notificationMessage() {
        return page.innerText(notificationMessage);
    }

}
