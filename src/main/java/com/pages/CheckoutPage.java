package com.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;
import com.qa.managers.FileReaderManager;

import javax.swing.*;


public class CheckoutPage {
    private Page page;
    private final String continueBtnBillingAddressPath="//button[@class='button-1 new-address-next-step-button']";
    private final String shippingMethodGroundTextPath="//div[@class='method-name']/label";
    private final String addressDropDownBillingAddressPath="//*[@id='billing-address-select']";
    private final String addressDropDownShippingAddressPath="//*[@id='shipping-address-select']";
    private final String firstNameBillingPath="//*[@id='BillingNewAddress_FirstName']";
    private final String lastNameBillingPath="//*[@id='BillingNewAddress_LastName']";
    private final String emailBillingPath="//*[@id='BillingNewAddress_Email']";
    private final String countryBillingPath="//*[@id='BillingNewAddress_CountryId']";
    private final String stateBillingPath="//*[@id='BillingNewAddress_StateProvinceId']";
    private final String cityBillingPath="//*[@id='BillingNewAddress_City']";
    private final String addressBillingPath="//*[@id='BillingNewAddress_Address1']";
    private final String zipBillingPath="//*[@id='BillingNewAddress_ZipPostalCode']";
    private final String phoneNumberBillingPath="//*[@id='BillingNewAddress_PhoneNumber']";
    private final String continueBtnShippingAddressPath="//*[@id='shipping-buttons-container']/button";
    private final String firstNameWarningMsgBillingPath="//span[@class='field-validation-error']";
    private final String lastNameWarningMsgBillingPath="//*[@id='billing-new-address-form']/div/div/div[2]/span[2]";
    private final String emailWarningMsgBillingPath="//*[@id='billing-new-address-form']/div/div/div[3]/span[2]";
    private final String wrongEmailWarningMsgBillingPath="//*[@id='BillingNewAddress_Email-error']";
    private final String stateWarningMsgBillingPath="//*[@id='billing-new-address-form']/div/div/div[6]/span[2]";
    private final String cityWarningMsgBillingPath="//*[@id='billing-new-address-form']/div/div/div[7]/span[2]";
    private final String countryWarningMsgBillingPath="//*[@id='billing-new-address-form']/div/div/div[5]/span[2]";
    private final String addressWarningMsgBillingPath="//*[@id='billing-new-address-form']/div/div/div[8]/span[2]";
    private final String zipCodeWarningMsgBillingPath="//*[@id='billing-new-address-form']/div/div/div[10]/span[2]";
    private final String phoneWarningMsgBillingPath="//*[@id='billing-new-address-form']/div/div/div[11]/span[2]";
    private final String shipToTheSameAddressPath="//*[@id='ShipToSameAddress']";
    private final String pickupCheckBoxPath="//*[@id='PickupInStore']";
    private final String pickupStoreNamePath="//li[@class='single-pickup-point name']";
    private final String firstNameShippingPath="//*[@id='ShippingNewAddress_FirstName']";
    private final String lastNameShippingPath="//*[@id='ShippingNewAddress_LastName']";
    private final String emailShippingPath="//*[@id='ShippingNewAddress_Email']";
    private final String countryShippingPath="//*[@id='ShippingNewAddress_CountryId']";
    private final String stateShippingPath="//*[@id='ShippingNewAddress_StateProvinceId']";
    private final String cityShippingPath="//*[@id='ShippingNewAddress_City']";
    private final String addressShippingPath="//*[@id='ShippingNewAddress_Address1']";
    private final String zipShippingPath="//*[@id='ShippingNewAddress_ZipPostalCode']";
    private final String phoneNumberShippingPath="//*[@id='ShippingNewAddress_PhoneNumber']";
    private final String firstNameWarningMsgShippingPath="//*[@id='shipping-new-address-form']/div/div/div[1]/span[2]";
    private final String lastNameWarningMsgShippingPath="//*[@id='shipping-new-address-form']/div/div/div[2]/span[2]";
    private final String emailWarningMsgShippingPath="//*[@id='shipping-new-address-form']/div/div/div[3]/span[2]";
    private final String wrongEmailWarningMsgShippingPath="//*[@id='shipping-new-address-form']/div/div/div[3]/span[2]";
    private final String stateWarningMsgShippingPath="//*[@id='shipping-new-address-form']/div/div/div[6]/span[2]";
    private final String cityWarningMsgShippingPath="//*[@id='shipping-new-address-form']/div/div/div[7]/span[2]";
    private final String countryWarningMsgShippingPath="//*[@id='shipping-new-address-form']/div/div/div[5]/span[2]";
    private final String addressWarningMsgShippingPath="//*[@id='shipping-new-address-form']/div/div/div[8]/span[2]";
    private final String zipCodeWarningMsgShippingPath="//*[@id='shipping-new-address-form']/div/div/div[10]/span[2]";
    private final String phoneWarningMsgShippingPath="//*[@id='shipping-new-address-form']/div/div/div[11]/span[2]";
    private final String groundShippingMethodPath="//*[@id='shippingoption_0']";
    private final String nextDayShippingMethodPath="//*[@id='shippingoption_1']";
    private final String secondDayShippingMethodPath="//*[@id='shippingoption_2']";
    private final String continueBtnShippingMethodPath="//*[@id='shipping-method-buttons-container']/button";
    private final String checkOrMoneyOrderTextPath="//div[@class='payment-details']/label";
    private final String selectCheckOrMoneyOrderPath="//*[@id='paymentmethod_0']";
    private final String continueBtnPaymentMethodPath="//*[@id='payment-method-buttons-container']/button";
    private final String paymentInfoDivPath="//*[@id='checkout-payment-info-load']/div/div/div";
    private final String continueBtnPaymentInfoPath="//button[@class='button-1 payment-info-next-step-button']";
    private final String billingAddressSectionPath="//div[@class='billing-info']/div/strong";
    private final String shippingAddressSectionPath="//div[@class='shipping-info']/div/strong";
    private final String paymentMethodPath="//li[@class='payment-method']/span";
    private final String shippingMethodSectionPath="//li[@class='shipping-method']/span";
    private final String productSkuPath="//span[@class='sku-number']";
    private final String productImagePath="//td[@class='product-picture']/a/img";
    private final String productNamePath="//a[@class='product-name']";
    private final String quantity="//span[@class='product-quantity']";
    private final String selectCreditCardPath="//*[@id='paymentmethod_1']";
    private final String orderConfirmBtn="//button[@class='button-1 confirm-order-next-step-button']";
    private final String orderSuccessMsgPath="//div[@class='title']/strong";
    private final String orderNumberPath="//div[@class='order-number']/strong";
    private final String orderDetailsLinkPath="//div[@class='details-link']/a";
    private final String pageTitle="//title";
    public CheckoutPage(Page page) {
        this.page = page;
    }
    public void continueBtnBillingAddress(){
        page.click(continueBtnBillingAddressPath);
    }
    public boolean shippingMethodGroundText(){
        return page.isVisible(shippingMethodGroundTextPath);
    }
    public void selectNewAddressFromBilling() { page.selectOption(addressDropDownBillingAddressPath, new SelectOption().setLabel("New Address")); }
    public void fillUpFirstNameBilling(String st1){
        page.fill(firstNameBillingPath,st1);
    }
    public void fillUpLastNameBilling(String st1){
        page.fill(lastNameBillingPath,st1);
    }
    public void fillUpEmailBilling(String st1){
        page.fill(emailBillingPath,st1);
    }
    public void fillUpCountryBilling(String st1){
        page.locator(countryBillingPath).selectOption(st1);
    }
    public void fillUpStateBilling(String st1){
        page.locator(stateBillingPath).selectOption(st1);
    }
    public void fillUpCityBilling(String st1){
        page.fill(cityBillingPath,st1);
    }
    public void fillUpAddress1Billing(String st1){
        page.fill(addressBillingPath,st1);
    }
    public void fillUpZipBilling(String st1){
        page.fill(zipBillingPath,st1);
    }
    public void fillUpPhoneBilling(String st1){
        page.fill(phoneNumberBillingPath,st1);
    }
    public void continueBtnShippingAddress(){
        page.click(continueBtnShippingAddressPath);
    }
    public String firstNameWarningMsgBilling(){
        return page.innerText(firstNameWarningMsgBillingPath);
    }
    public String lastNameWarningMsgBilling(){
        return page.innerText(lastNameWarningMsgBillingPath);
    }
    public String emailWarningMsgBilling(){
        return page.innerText(emailWarningMsgBillingPath);
    }
    public String wrongEmailWarningMsgBilling(){
        return page.innerText(wrongEmailWarningMsgBillingPath);
    }
    public String countryWarningMsgBilling(){
        return page.innerText(countryWarningMsgBillingPath);
    }
    public String stateWarningMsgBilling(){
        return page.innerText(stateWarningMsgBillingPath);
    }
    public String cityWarningMsgBilling(){
        return page.innerText(cityWarningMsgBillingPath);
    }
    public String addressWarningMsgBilling(){
        return page.innerText(addressWarningMsgBillingPath);
    }
    public String zipWarningMsgBilling(){
        return page.innerText(zipCodeWarningMsgBillingPath);
    }
    public String phoneWarningMsgBilling(){
        return page.innerText(phoneWarningMsgBillingPath);
    }
    public void uncheckShipToTheSameAddress(){
        page.click(shipToTheSameAddressPath);
    }
    public void clickOnPickupCheckbox(){
        page.click(pickupCheckBoxPath);
    }
    public String pickupStoreName(){
       return page.innerText(pickupStoreNamePath);
    }
    public void selectNewAddressFromShipping() { page.selectOption(addressDropDownShippingAddressPath, new SelectOption().setLabel("New Address")); }
    public void fillUpFirstNameShipping(String st1){
        page.fill(firstNameShippingPath,st1);
    }
    public void fillUpLastNameShipping(String st1){
        page.fill(lastNameShippingPath,st1);
    }
    public void fillUpEmailShipping(String st1){
        page.fill(emailShippingPath,st1);
    }
    public void fillUpCountryShipping(String st1){
        page.locator(countryShippingPath).selectOption(st1);
    }
    public void fillUpStateShipping(String st1){
        page.locator(stateShippingPath).selectOption(st1);
    }
    public void fillUpCityShipping(String st1){
        page.fill(cityShippingPath,st1);
    }
    public void fillUpAddress1Shipping(String st1){
        page.fill(addressShippingPath,st1);
    }
    public void fillUpZipShipping(String st1){
        page.fill(zipShippingPath,st1);
    }
    public void fillUpPhoneShipping(String st1){
        page.fill(phoneNumberShippingPath,st1);
    }
    public String firstNameWarningMsgShipping(){
        return page.innerText(firstNameWarningMsgShippingPath);
    }
    public String lastNameWarningMsgShipping(){
        return page.innerText(lastNameWarningMsgShippingPath);
    }
    public String emailWarningMsgShipping(){
        return page.innerText(emailWarningMsgShippingPath);
    }
    public String wrongEmailWarningMsgShipping(){
        return page.innerText(wrongEmailWarningMsgShippingPath);
    }
    public String countryWarningMsgShipping(){
        return page.innerText(countryWarningMsgShippingPath);
    }
    public String stateWarningMsgShipping(){
        return page.innerText(stateWarningMsgShippingPath);
    }
    public String cityWarningMsgShipping(){
        return page.innerText(cityWarningMsgShippingPath);
    }
    public String addressWarningMsgShipping(){
        return page.innerText(addressWarningMsgShippingPath);
    }
    public String zipWarningMsgShipping(){
        return page.innerText(zipCodeWarningMsgShippingPath);
    }
    public String phoneWarningMsgShipping(){
        return page.innerText(phoneWarningMsgShippingPath);
    }
    public void networkLoading()  { page.waitForLoadState(LoadState.NETWORKIDLE);
    }
    public void groundShippingMethodSelect(){ page.click(groundShippingMethodPath); }
    public void nextDayShippingMethodSelect() { page.click(nextDayShippingMethodPath); }
    public void secondDayShippingMethodSelect() { page.click(secondDayShippingMethodPath); }
    public void continueBtnShippingMethod(){ page.click(continueBtnShippingMethodPath); }
    public boolean checkOrMoneyOrderText(){
        return page.isVisible(checkOrMoneyOrderTextPath);
    }
    public void selectCheckOrMoneyOrder(){
        page.click(selectCheckOrMoneyOrderPath);
    }
    public void continueBtnPaymentMethod(){
        page.click(continueBtnPaymentMethodPath);
    }
    public boolean paymentInfoDiv(){
       return page.isVisible(paymentInfoDivPath);
    }
    public void continueBtnPaymentInfo(){
        page.click(continueBtnPaymentInfoPath);
    }
    public boolean billingAddressSection(){
        return page.isVisible(billingAddressSectionPath);
    }
    public boolean shippingAddressSection(){
        return page.isVisible(shippingAddressSectionPath);
    }
    public String paymentMethod(){
        return page.innerText(paymentMethodPath);
    }
    public String shippingMethod(){
        return page.innerText(shippingMethodSectionPath);
    }
    public String productSku(){
        return page.innerText(productSkuPath);
    }
    public void productImageClick(){
        page.click(productImagePath);
    }
    public void productNameClick(){
        page.click(productNamePath);
    }
    public String productQuantity() {
        return page.innerText(quantity);
    }
    public void selectCreditCardOption(){
        page.click(selectCreditCardPath);
    }
    public void clickOnOrderConfirm(){
        page.click(orderConfirmBtn);
    }
    public String orderSuccessMsg(){
        return page.innerText(orderSuccessMsgPath);
    }
    public String orderNumber(){
        return page.innerText(orderNumberPath);
    }
    public void clickOnOrderDetailsLink(){
        page.click(orderDetailsLinkPath);
    }
    public String pageTitleText(){
        return page.innerText(pageTitle);
    }
}
