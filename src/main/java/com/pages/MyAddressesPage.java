package com.pages;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;


public class MyAddressesPage {

    private Page page;

    //locators for login page
    private final String topNavbar_My_Account_link = "//a[@class = 'ico-account']";
    private final String My_Account_Addresses_link = "(//a[text() = 'Addresses'])[1]";
    private final String addNewAddressButton = "//button[@class = 'button-1 add-address-button']";
    private final String firstNameTextBox = "//input[@id = 'Address_FirstName']";
    private final String lastNameTextBox = "//input[@id = 'Address_LastName']";
    private final String emailTextBox = "//input[@id = 'Address_Email']";
    private final String countryDropDown = "//select[@id = 'Address_CountryId']";
    private final String stateProvinceDropDown = "//select[@id = 'Address_StateProvinceId']";
    private final String cityTextBox = "//input[@id = 'Address_City']";
    private final String address1TextBox = "//input[@id = 'Address_Address1']";
    private final String zipPostalCodeTextBox = "//input[@id = 'Address_ZipPostalCode']";
    private final String phoneNumberTextBox = "//input[@id = 'Address_PhoneNumber']";
    private final String addNewAddressSaveButton = "//button[@class = 'button-1 save-address-button']";
    private final String firstNameErrorMessage = "//span[@id = 'Address_FirstName-error']";
    private final String lastNameErrorMessage = "//span[@id = 'Address_LastName-error']";
    private final String emailErrorMessage = "//span[@id = 'Address_Email-error']";
    private final String validationErrorMessage = "//span[@class = 'field-validation-error']";
    private final String cityErrorMessage = "//span[@id = 'Address_City-error']";
    private final String address1ErrorMessage = "//span[@id = 'Address_Address1-error']";
    private final String zipPostalCodeErrorMessage = "//span[@id = 'Address_ZipPostalCode-error']";
    private final String phoneNumberErrorMessage = "//span[@id = 'Address_PhoneNumber-error']";
    private final String addressPageBody = "//div[@class = 'page-body']";
    private final String editAddressButton = "(//button[@class = 'button-2 edit-address-button'])[1]";
    private final String firstAddressDeleteAddressButton = "(//button[@class = 'button-2 delete-address-button'])[1]";
    private final String firstAddressTitle = "(//div[@class = 'title'])[2]/strong";

    //constructor to initialize page
    public MyAddressesPage(Page page) {
        this.page = page;
    }

    //methods for my account addresses page

    public void goToMyAccountPage() {
        page.click(topNavbar_My_Account_link);
    }

    public void goToMyAccountAddressesPage() {
        page.click(My_Account_Addresses_link);
    }

    public void clickOnAddNewAddressButton() {
        page.click(addNewAddressButton);
    }

    public void enterFirstName(String firstName) {
        page.fill(firstNameTextBox, firstName);
    }

    public void enterLastName(String lastName) {
        page.fill(lastNameTextBox, lastName);
    }

    public void enterEmail(String email) {
        page.fill(emailTextBox, email);
    }

    public void selectCountry(String country) {
        page.selectOption(countryDropDown, country);
    }

    public void selectStateProvince(String stateProvince) {page.selectOption(stateProvinceDropDown, stateProvince);
    }

    public void enterCity(String city) {
        page.fill(cityTextBox, city);
    }

    public void enterAddress1(String address1) {
        page.fill(address1TextBox, address1);
    }

    public void enterZipPostalCode(String zipPostalCode) {
        page.fill(zipPostalCodeTextBox, zipPostalCode);
    }

    public void enterPhoneNumber(String phoneNumber) {
        page.fill(phoneNumberTextBox, phoneNumber);
    }

    public void clickOnAddNewAddressSaveButton() {
        page.click(addNewAddressSaveButton);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    public String firstNameErrorMessage() {
        return page.innerText(firstNameErrorMessage);
    }


    public String LastNameErrorMessage() {
        return page.innerText(lastNameErrorMessage);
    }

    public String EmailErrorMessage() {
        return page.innerText(emailErrorMessage);
    }

    public String ValidationErrorMessage() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return page.innerText(validationErrorMessage);
    }

    public String CityErrorMessage() {
        return page.innerText(cityErrorMessage);
    }

    public String Address1ErrorMessage() {
        return page.innerText(address1ErrorMessage);
    }

    public String ZipPostalCodeErrorMessage() {
        return page.innerText(zipPostalCodeErrorMessage);
    }

    public String PhoneNumberErrorMessage() {
        return page.innerText(phoneNumberErrorMessage);
    }

    public String addressBodyHasAddress() {
        return page.innerText(addressPageBody);
    }

    public void clickOnEditAddressButton() {
        page.click(editAddressButton);
    }

    public void clearFirstNameTextBox() {
        page.fill(firstNameTextBox, "");
    }

    public void clearLastNameTextBox() {
        page.fill(lastNameTextBox, "");
    }

    public void clearEmailTextBox() {
        page.fill(emailTextBox, "");
    }

    public void clearCityTextBox() {
        page.fill(cityTextBox, "");
    }

    public void clearAddress1TextBox() {
        page.fill(address1TextBox, "");
    }

    public void clearZipPostalCodeTextBox() {
        page.fill(zipPostalCodeTextBox, "");
    }

    public void clearPhoneNumberTextBox() {
        page.fill(phoneNumberTextBox, "");
    }

    public void clearCountryDropDown() {
        page.selectOption(countryDropDown, "0");
    }

    public void clearStateProvinceDropDown() {
        page.selectOption(stateProvinceDropDown, "0");
    }

    public void clickDeleteAddressButton() {
        page.onDialog(Dialog::accept);
        page.click(firstAddressDeleteAddressButton);

    }

    public String getFirstAddressTitle() {
        return page.innerText(firstAddressTitle);
    }

    public void pageLoading() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }


}
