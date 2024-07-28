package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.managers.FileReaderManager;



public class ChangePasswordPage {
    private Page page;

    //locators for change password page
    private final String topNavbar_myAccount_link = "//a[@class = 'ico-account']";
    private final String myAccount_changePassword_link = "//a[text() = 'Change password']";
    private final String changePassword_oldPassword_textBox = "//input[@id = 'OldPassword']";
    private final String changePassword_newPassword_textBox = "//input[@id = 'NewPassword']";
    private final String changePassword_confirmPassword_textBox = "//input[@id = 'ConfirmNewPassword']";
    private final String changePassword_changePassword_button = "//button[@class='button-1 change-password-button']";
    private final String oldPasswordErrorMessage = "//span[@id = 'OldPassword-error']";
    private final String newPasswordErrorMessage = "//span[@id = 'NewPassword-error']";
    private final String confirmPasswordErrorMessage = "//span[@id = 'ConfirmNewPassword-error']";
    private final String wrongOldPasswordErrorMessage = "//div[@class = 'message-error validation-summary-errors']";
    private final String changePasswordSuccessMessage = "//p[@class = 'content']";


    //constructor to initialize page
    public ChangePasswordPage(Page page) {
        this.page = page;
    }

    //methods for change password page

    public void goToChangePasswordPage() {
        page.click(topNavbar_myAccount_link);
        page.click(myAccount_changePassword_link);
    }

    public void enterOldPassword(String oldPassword) {
        page.fill(changePassword_oldPassword_textBox, oldPassword);
    }

    public void enterNewPassword(String newPassword) {
        page.fill(changePassword_newPassword_textBox, newPassword);
    }

    public void enterConfirmPassword(String confirmPassword) {
        page.fill(changePassword_confirmPassword_textBox, confirmPassword);
    }

    public void clickOnChangePasswordButton() {
        page.click(changePassword_changePassword_button);
    }

    public String oldPasswordErrorMessage() {
        return page.innerText(oldPasswordErrorMessage);
    }

    public String newPasswordErrorMessage() {
        return page.innerText(newPasswordErrorMessage).replaceAll("<[^>]*>", "");
    }

    public String confirmPasswordErrorMessage() {
        return page.innerText(confirmPasswordErrorMessage);
    }

    public String wrongOldPasswordErrorMessage() {
        return page.innerText(wrongOldPasswordErrorMessage);
    }

    public String changePasswordSuccessMessage() {
        return page.innerText(changePasswordSuccessMessage);
    }

    public void pageLoading() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }


}
