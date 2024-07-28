package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.managers.FileReaderManager;

public class CustomerInfoPage {

    private Page page;

    //locators for login page
    private final String topNavbar_My_Account_link = "//a[@class = 'ico-account']";
    private final String MyAccount_CustomerInfo_link = "//a[text() = 'Customer info']";
    private final String customerInfo_FirstName_textBox = "//input[@id = 'FirstName']";
    private final String customerInfo_LastName_textBox = "//input[@id = 'LastName']";
    private final String customerInfo_Email_textBox = "//input[@id = 'Email']";
    private final String customerInfoSaveButton = "//button[@id = 'save-info-button']";
    private final String customerInfoFirstNameErrorMessage = "//span[@id = 'FirstName-error']";
    private final String customerInfoLastNameErrorMessage = "//span[@id = 'LastName-error']";
    private final String customerInfoEmailErrorMessage = "//span[@id = 'Email-error']";


    //constructor to initialize page
    public CustomerInfoPage(Page page) {
        this.page = page;
    }

    //methods for login page

    public void goToMyAccountCustomerInfoPage() {
        page.click(topNavbar_My_Account_link);
        page.click(MyAccount_CustomerInfo_link);
    }

    public void clearFirstNameTextBox() {
        page.fill(customerInfo_FirstName_textBox, "");
    }

    public void clickOnSaveButton() {
        page.click(customerInfoSaveButton);
    }

    public String firstNameFieldErrorMessage() {
        return page.innerText(customerInfoFirstNameErrorMessage);
    }

    public void clearLastNameTextBox() {
        page.fill(customerInfo_LastName_textBox, "");
    }

    public String lastNameFieldErrorMessage() {
        return page.innerText(customerInfoLastNameErrorMessage);
    }

    public void clearEmailTextBox() {
        page.fill(customerInfo_Email_textBox, "");
    }

    public String emailFieldErrorMessage() {
        return page.innerText(customerInfoEmailErrorMessage);
    }

    public void enterFirstName(String firstName) {
        page.fill(customerInfo_FirstName_textBox, firstName);
    }

    public void enterLastName(String lastName) {
        page.fill(customerInfo_LastName_textBox, lastName);
    }

    public void enterEmail(String email) {
        page.fill(customerInfo_Email_textBox, email);
    }

    public String getFirstName() {
        return page.inputValue(customerInfo_FirstName_textBox);
    }

    public String getLastName() {
        return page.inputValue(customerInfo_LastName_textBox);
    }

    public String getEmail() {
        return page.inputValue(customerInfo_Email_textBox);
    }

    public void pageLoading() {
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }


}
