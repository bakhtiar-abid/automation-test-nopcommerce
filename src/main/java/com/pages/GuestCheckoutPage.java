package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class GuestCheckoutPage {
    Page page;
    public GuestCheckoutPage(Page page){
        this.page = page;
    }
    /* Xpath */
    String addToCartBtnXpath = "//button[contains(@id,'add-to-cart-button')]";
    String termsOrServiceCheckboxXpath = "//*[@id='termsofservice']";
    String checkoutBtnXpath= "//*[@id='checkout']";
    String guestCheckoutBtnXpath = "//button[contains(@class,'checkout-as-guest-button')]";
    String addressDeleteButtonXpath = "//button[@id='delete-address-button']";
    String firstNameBoxXpath = "//*[@id='BillingNewAddress_FirstName']";
    String lastNameBoxXpath = "//*[@id='BillingNewAddress_LastName']";
    String emailBoxXpath = "//*[@id='BillingNewAddress_Email']";
    String countryDropdownXpath = "//*[@id='BillingNewAddress_CountryId']";
    String stateDropdownXpath = "//*[@id='BillingNewAddress_StateProvinceId']";
    String cityBoxXpath = "//*[@id='BillingNewAddress_City']";
    String addressBoxXpath = "//*[@id='BillingNewAddress_Address1']";
    String zipcodeBoxXpath = "//*[@id='BillingNewAddress_ZipPostalCode']";
    String phoneNoBoxXpath = "//*[@id='BillingNewAddress_PhoneNumber']";
    String billingAddressContinueXpath = "//div[@id='billing-buttons-container']/button[contains(@class,'new-address-next-step-button')]";
    String shippingMethodGroundXpath = "//input[contains(@id,'shippingoption')]/../label[contains(text(),'Ground')]/../input";
    String paymentMethodMoneyOrderXpath = "//input[contains(@id,'paymentmethod')]/../label[contains(text(),'Money Order')]/../input";
    String shippingAddressContinueBtnXpath = "//div[@id='shipping-buttons-container']/button";
    String shippingMethodsContinueBtnXpath = "//div[@id='shipping-method-buttons-container']/button";
    String paymentMethodsContinueBtnXpath = "//div[@id='payment-method-buttons-container']/button";
    String paymentInfoContinueBtnXpath = "//div[@id='payment-info-buttons-container']/button";
    String orderConfirmBtnXpath = "//div[@id='confirm-order-buttons-container']/button";
    String orderConfirmSuccessMsgXpath = "//div[contains(@class,'order-completed')]/div/strong";

    public String getUrl(){
        return page.url();
    }
    public void clickAddToCartBtnFromProductDetailsPage(){
        page.click(addToCartBtnXpath);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
    public void selectTermsOrServiceCheckbox(){
        page.check(termsOrServiceCheckboxXpath);
    }
    public void clickCheckoutBtn(){
        page.click(checkoutBtnXpath);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
    public void clickGuestCheckoutBtn(){
        page.click(guestCheckoutBtnXpath);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
    public void fillFirstName(String fName){
        page.fill(firstNameBoxXpath, fName);
    }
    public void fillLastName(String lName){
        page.fill(lastNameBoxXpath, lName);
    }
    public void fillEmail(String email){
        page.fill(emailBoxXpath, email);
    }
    public void selectCountryName(String country){
        page.selectOption(countryDropdownXpath, country);
    }
    public void selectState(String state){
        page.selectOption(stateDropdownXpath,state);
    }
    public void clickBillingAddressDeleteBtn(){
        if (page.isVisible(addressDeleteButtonXpath)){
            page.click(addressDeleteButtonXpath);
            page.waitForLoadState(LoadState.NETWORKIDLE);
        }
    }
    public void fillCityName(String city){
        page.fill(cityBoxXpath, city);
    }
    public void fillAddress1(String address){
        page.fill(addressBoxXpath,address);
    }
    public void fillZipCode(String zip){
        page.fill(zipcodeBoxXpath,zip);
    }
    public void fillPhoneNumber(String phoneNo){
        page.fill(phoneNoBoxXpath, phoneNo);
    }
    public void clickBillingAddressContinueBtn(){
        page.click(billingAddressContinueXpath);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
    public void clickShippingAddressContinueBtn(){
        if (page.isVisible(shippingAddressContinueBtnXpath)){
            page.click(shippingAddressContinueBtnXpath);
            page.waitForLoadState(LoadState.NETWORKIDLE);
        }
    }
    public void selectShippingMethodGroundOption(){
        page.check(shippingMethodGroundXpath);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
    public void clickShippingMethodContinueBtn(){
        page.click(shippingMethodsContinueBtnXpath);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
    public void selectPaymentMethodMoneyOrderOption(){
        page.check(paymentMethodMoneyOrderXpath);
    }
    public void clickPaymentMethodContinueBtn(){
        page.click(paymentMethodsContinueBtnXpath);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
    public void clickPaymentInfoContinueBtn(){
        page.click(paymentInfoContinueBtnXpath);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
    public void clickOrderConfirmBtn(){
        page.click(orderConfirmBtnXpath);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
    public String getOrderSuccessMsg(){
        return page.innerText(orderConfirmSuccessMsgXpath);
    }
}
