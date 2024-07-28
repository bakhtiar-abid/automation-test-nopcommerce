package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.CheckoutPage;
import com.pages.LoginPage;
import com.pages.Shopping_CartPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import com.qa.util.Xls_Reader;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.zh_cn.假如;
import org.junit.jupiter.api.Assertions;

public class CheckoutSteps {
    Page page= DriverFactory.getPage();

    LoginPage loginPage= new LoginPage(page);
    Shopping_CartPage shoppingCartPage= new Shopping_CartPage(page);
    CheckoutPage checkoutPage=new CheckoutPage(page);

    Xls_Reader reader1 = new Xls_Reader("src/test/resources/config/Testdata/Testdata.xlsx");
    Xls_Reader reader2 = new Xls_Reader("src/test/resources/config/Testdata/cartData.xlsx");
    Xls_Reader reader3 = new Xls_Reader("src/test/resources/config/Testdata/addressData.xlsx");
    Xls_Reader reader4=new Xls_Reader("src/test/resources/config/Testdata/CheckoutData.xlsx");

    String sheet1Name = "Login";
    String sheet2Name= "productDetails";
    String sheet3Name="Addresses";
    String sheet4Name="orderConfirm";
    String baseUrl= FileReaderManager.getInstance().getConfigReader().getBaseUrl();
    @And("user logs in and goes to checkout-billing address page with a product in cart")
    public void userLogsInAndGoesToCheckoutBillingAddressPageWithAProductInCart() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader1.getCellData(sheet1Name, "Email", 7));
        loginPage.enterPassword(reader1.getCellData(sheet1Name, "Password", 7));
        loginPage.clickOnLoginButton();
        shoppingCartPage.productsDetailsPage(reader2.getCellData(sheet2Name, "productA", 2));
        shoppingCartPage.pageLoading();
        shoppingCartPage.product_addToCart();
        shoppingCartPage.toCart();
        shoppingCartPage.pageLoading();
        shoppingCartPage.clickOnCheckBoxTermsOfService();
        shoppingCartPage.clickOnCheckoutBtn();
    }

    @Given("user clicks on ship to the same address and click on continue")
    public void userClicksOnShipToTheSameAddressAndClickOnContinue() {
        checkoutPage.continueBtnBillingAddress();
    }

    @Then("user should be redirected to checkout-shipping method page")
    public void userShouldBeRedirectedToCheckoutShippingMethodPage() {
        shoppingCartPage.pageLoading();
        checkoutPage.networkLoading();
        Assertions.assertTrue(checkoutPage.shippingMethodGroundText());
        shoppingCartPage.cleanCart();
    }

    @Given("user selects new address from drop down menu")
    public void userSelectsNewAddressFromDropDownMenu() {
        checkoutPage.selectNewAddressFromBilling();
    }

    @And("user fills up the required fields without first name field")
    public void userFillsUpTheRequiredFieldsWithoutFirstNameField() {
        checkoutPage.fillUpLastNameBilling(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailBilling(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryBilling(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateBilling(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityBilling(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Billing(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipBilling(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneBilling(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnBillingAddress();
    }

    @Then("user should see {string} alert message under the first name field")
    public void userShouldSeeAlertMessageUnderTheFirstNameField(String st1) {
        String actualMsg=checkoutPage.firstNameWarningMsgBilling();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without last name field")
    public void userFillsUpTheRequiredFieldsWithoutLastNameField() {
        checkoutPage.fillUpFirstNameBilling(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpEmailBilling(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryBilling(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateBilling(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityBilling(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Billing(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipBilling(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneBilling(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the last name field")
    public void userShouldSeeAlertMessageUnderTheLastNameField(String st1) {
        String actualMsg=checkoutPage.lastNameWarningMsgBilling();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without email field")
    public void userFillsUpTheRequiredFieldsWithoutEmailField() {
        checkoutPage.fillUpFirstNameBilling(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameBilling(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpCountryBilling(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateBilling(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityBilling(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Billing(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipBilling(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneBilling(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the email field")
    public void userShouldSeeAlertMessageUnderTheEmailField(String st1) {
        String actualMsg=checkoutPage.emailWarningMsgBilling();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields with wrong email in email field")
    public void userFillsUpTheRequiredFieldsWithWrongEmailInEmailField() {
        checkoutPage.fillUpFirstNameBilling(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameBilling(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailBilling(reader3.getCellData(sheet3Name,"Wrong",2));
        checkoutPage.fillUpCountryBilling(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateBilling(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityBilling(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Billing(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipBilling(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneBilling(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnBillingAddress();
    }
    @Then("user should see {string} alert message under the email field for wrong email")
    public void userShouldSeeAlertMessageUnderTheEmailFieldForWrongEmail(String st1) {
        String actualMsg=checkoutPage.wrongEmailWarningMsgBilling();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without selecting any country")
    public void userFillsUpTheRequiredFieldsWithoutSelectingAnyCountry() {
        checkoutPage.fillUpFirstNameBilling(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameBilling(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailBilling(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCityBilling(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Billing(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipBilling(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneBilling(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the Country dropdown.")
    public void userShouldSeeCountryIsRequiredAlertMessageUnderTheCountryDropdown(String st1) {
        String actualMsg=checkoutPage.countryWarningMsgBilling();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without selecting any state")
    public void userFillsUpTheRequiredFieldsWithoutSelectingAnyState() {
        checkoutPage.fillUpFirstNameBilling(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameBilling(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailBilling(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryBilling(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpCityBilling(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Billing(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipBilling(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneBilling(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the state field")
    public void userShouldSeeStateProvinceIsRequiredAlertMessageUnderTheStateField(String st1) {
        String actualMsg=checkoutPage.stateWarningMsgBilling();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without city")
    public void userFillsUpTheRequiredFieldsWithoutCity() {
        checkoutPage.fillUpFirstNameBilling(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameBilling(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailBilling(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryBilling(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateBilling(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpAddress1Billing(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipBilling(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneBilling(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the City field.")
    public void userShouldSeeCityIsRequiredAlertMessageUnderTheCityField(String st1) {
        String actualMsg=checkoutPage.cityWarningMsgBilling();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }


    @And("user fills up the required fields without Street address")
    public void userFillsUpTheRequiredFieldsWithoutStreetAddress() {
        checkoutPage.fillUpFirstNameBilling(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameBilling(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailBilling(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryBilling(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateBilling(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityBilling(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpZipBilling(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneBilling(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the street address field")
    public void userShouldSeeStreetAddressIsRequiredAlertMessageUnderTheStreetAddressField(String st1) {
        String actualMsg=checkoutPage.addressWarningMsgBilling();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }
    @And("user fills up the required fields without zip code")
    public void userFillsUpTheRequiredFieldsWithoutZipCode() {
        checkoutPage.fillUpFirstNameBilling(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameBilling(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailBilling(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryBilling(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateBilling(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityBilling(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Billing(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpPhoneBilling(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.networkLoading();
    }
    @Then("user should see {string} alert message under the Zip code field.")
    public void userShouldSeeZipPostalCodeIsRequiredAlertMessageUnderTheZipCodeField(String st1) {
        String actualMsg=checkoutPage.zipWarningMsgBilling();
        Assertions.assertEquals(st1, actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without phone number")
    public void userFillsUpTheRequiredFieldsWithoutPhoneNumber() {
        checkoutPage.fillUpFirstNameBilling(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameBilling(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailBilling(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryBilling(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateBilling(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityBilling(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Billing(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipBilling(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the Phone number field.")
    public void userShouldSeePhoneIsRequiredAlertMessageUnderThePhoneNumberField(String st1) {
        String actualMsg=checkoutPage.phoneWarningMsgBilling();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields with valid info")
    public void userFillsUpTheRequiredFieldsWithValidInfo() {
        checkoutPage.fillUpFirstNameBilling(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameBilling(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailBilling(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryBilling(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateBilling(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityBilling(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Billing(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipBilling(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneBilling(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.networkLoading();
    }

    @Given("user logs in and goes to checkout-shipping address page with a product in cart")
    public void userLogsInAndGoesToCheckoutShippingAddressPageWithAProductInCart() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader1.getCellData(sheet1Name, "Email", 7));
        loginPage.enterPassword(reader1.getCellData(sheet1Name, "Password", 7));
        loginPage.clickOnLoginButton();
        shoppingCartPage.productsDetailsPage(reader2.getCellData(sheet2Name, "productA", 2));
        shoppingCartPage.pageLoading();
        shoppingCartPage.product_addToCart();
        shoppingCartPage.toCart();
        shoppingCartPage.pageLoading();
        shoppingCartPage.clickOnCheckBoxTermsOfService();
        shoppingCartPage.clickOnCheckoutBtn();
        checkoutPage.uncheckShipToTheSameAddress();
        checkoutPage.continueBtnBillingAddress();
    }

    @Given("user clicks on pickup option")
    public void userClicksOnPickupOption() {
        checkoutPage.clickOnPickupCheckbox();
        checkoutPage.networkLoading();
    }

    @Then("user should see pickup store name {string} with address is displayed")
    public void userShouldSeePickupStoreNameWithAddressIsDisplayed(String st1) {
        String actualMsg=checkoutPage.pickupStoreName();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @Given("user selects new address from drop down menu of shipping address")
    public void userSelectsNewAddressFromDropDownMenuOfShippingAddress() {
        checkoutPage.selectNewAddressFromShipping();
    }

    @And("user fills up the required fields without first name field in shipping address")
    public void userFillsUpTheRequiredFieldsWithoutFirstNameFieldInShippingAddress() {
        checkoutPage.fillUpFirstNameShipping(" ");
        checkoutPage.fillUpLastNameShipping(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailShipping(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryShipping(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateShipping(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityShipping(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Shipping(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipShipping(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneShipping(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the first name field in shipping address")
    public void userShouldSeeAlertMessageUnderTheFirstNameFieldInShippingAddress(String st1) {
        String actualMsg=checkoutPage.firstNameWarningMsgShipping();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without last name field in shipping address")
    public void userFillsUpTheRequiredFieldsWithoutLastNameFieldInShippingAddress() {
        checkoutPage.fillUpFirstNameShipping(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameShipping(" ");
        checkoutPage.fillUpEmailShipping(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryShipping(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateShipping(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityShipping(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Shipping(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipShipping(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneShipping(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the last name field in shipping address")
    public void userShouldSeeAlertMessageUnderTheLastNameFieldInShippingAddress(String st1) {
        String actualMsg=checkoutPage.lastNameWarningMsgShipping();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without email field in shipping address")
    public void userFillsUpTheRequiredFieldsWithoutEmailFieldInShippingAddress() {
        checkoutPage.fillUpFirstNameShipping(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameShipping(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailShipping(" ");
        checkoutPage.fillUpCountryShipping(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateShipping(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityShipping(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Shipping(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipShipping(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneShipping(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the email field in shipping address")
    public void userShouldSeeAlertMessageUnderTheEmailFieldInShippingAddress(String st1) {
        String actualMsg=checkoutPage.emailWarningMsgShipping();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields with wrong email in email field in shipping address")
    public void userFillsUpTheRequiredFieldsWithWrongEmailInEmailFieldInShippingAddress() {
        checkoutPage.fillUpFirstNameShipping(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameShipping(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailShipping(reader3.getCellData(sheet3Name,"Wrong",2));
        checkoutPage.fillUpCountryShipping(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateShipping(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityShipping(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Shipping(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipShipping(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneShipping(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the email field for wrong email in shipping address")
    public void userShouldSeeAlertMessageUnderTheEmailFieldForWrongEmailInShippingAddress(String st1) {
        String actualMsg=checkoutPage.wrongEmailWarningMsgShipping();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without selecting any country in shipping address")
    public void userFillsUpTheRequiredFieldsWithoutSelectingAnyCountryInShippingAddress() {
        checkoutPage.fillUpFirstNameShipping(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameShipping(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailShipping(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCityShipping(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Shipping(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipShipping(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneShipping(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the Country dropdown in shipping address")
    public void userShouldSeeCountryIsRequiredAlertMessageUnderTheCountryDropdownInShippingAddress(String st1) {
        String actualMsg=checkoutPage.countryWarningMsgShipping();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without selecting any state in shipping address")
    public void userFillsUpTheRequiredFieldsWithoutSelectingAnyStateInShippingAddress() {
        checkoutPage.fillUpFirstNameShipping(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameShipping(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailShipping(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryShipping(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpCityShipping(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Shipping(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipShipping(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneShipping(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the state field in shipping address")
    public void userShouldSeeStateProvinceIsRequiredAlertMessageUnderTheStateFieldInShippingAddress(String st1) {
        String actualMsg=checkoutPage.stateWarningMsgShipping();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without city in shipping address")
    public void userFillsUpTheRequiredFieldsWithoutCityInShippingAddress() {
        checkoutPage.fillUpFirstNameShipping(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameShipping(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailShipping(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryShipping(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateShipping(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityShipping(" ");
        checkoutPage.fillUpAddress1Shipping(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipShipping(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneShipping(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the City field in shipping address")
    public void userShouldSeeCityIsRequiredAlertMessageUnderTheCityFieldInShippingAddress(String st1) {
        String actualMsg=checkoutPage.cityWarningMsgShipping();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without Street address in shipping address")
    public void userFillsUpTheRequiredFieldsWithoutStreetAddressInShippingAddress() {
        checkoutPage.fillUpFirstNameShipping(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameShipping(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailShipping(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryShipping(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateShipping(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityShipping(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Shipping(" ");
        checkoutPage.fillUpZipShipping(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneShipping(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the street address field in shipping address")
    public void userShouldSeeStreetAddressIsRequiredAlertMessageUnderTheStreetAddressFieldInShippingAddress(String st1) {
        String actualMsg=checkoutPage.addressWarningMsgShipping();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without zip code in shipping address")
    public void userFillsUpTheRequiredFieldsWithoutZipCodeInShippingAddress() {
        checkoutPage.fillUpFirstNameShipping(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameShipping(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailShipping(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryShipping(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateShipping(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityShipping(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Shipping(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipShipping(" ");
        checkoutPage.fillUpPhoneShipping(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the Zip code field in shipping address")
    public void userShouldSeeZipPostalCodeIsRequiredAlertMessageUnderTheZipCodeFieldInShippingAddress(String st1) {
        String actualMsg=checkoutPage.zipWarningMsgShipping();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields without phone number in shipping address")
    public void userFillsUpTheRequiredFieldsWithoutPhoneNumberInShippingAddress() {
        checkoutPage.fillUpFirstNameShipping(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameShipping(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailShipping(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryShipping(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateShipping(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityShipping(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Shipping(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipShipping(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneShipping(" ");
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.networkLoading();
    }

    @Then("user should see {string} alert message under the Phone number field in shipping address")
    public void userShouldSeePhoneIsRequiredAlertMessageUnderThePhoneNumberFieldInShippingAddress(String st1) {
        String actualMsg=checkoutPage.phoneWarningMsgShipping();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @And("user fills up the required fields with valid info in shipping address")
    public void userFillsUpTheRequiredFieldsWithValidInfoInShippingAddress() {
        checkoutPage.fillUpFirstNameShipping(reader3.getCellData(sheet3Name,"FirstName",2));
        checkoutPage.fillUpLastNameShipping(reader3.getCellData(sheet3Name,"LastName",2));
        checkoutPage.fillUpEmailShipping(reader3.getCellData(sheet3Name,"Email",2));
        checkoutPage.fillUpCountryShipping(reader3.getCellData(sheet3Name,"Country",2));
        checkoutPage.fillUpStateShipping(reader3.getCellData(sheet3Name,"State",2));
        checkoutPage.fillUpCityShipping(reader3.getCellData(sheet3Name,"City",2));
        checkoutPage.fillUpAddress1Shipping(reader3.getCellData(sheet3Name,"Address",2));
        checkoutPage.fillUpZipShipping(reader3.getCellData(sheet3Name,"Zip",2));
        checkoutPage.fillUpPhoneShipping(reader3.getCellData(sheet3Name,"Phone",2));
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.networkLoading();
    }
    @Given("user uses existing address and clicks continue")
    public void userUsesExistingAddressAndClicksContinue() {
        checkoutPage.continueBtnShippingAddress();
    }

    @Given("user logs in and goes to checkout-shipping method page with a product in cart")
    public void userLogsInAndGoesToCheckoutShippingMethodPageWithAProductInCart() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader1.getCellData(sheet1Name, "Email", 7));
        loginPage.enterPassword(reader1.getCellData(sheet1Name, "Password", 7));
        loginPage.clickOnLoginButton();
        shoppingCartPage.productsDetailsPage(reader2.getCellData(sheet2Name, "productA", 2));
        shoppingCartPage.pageLoading();
        shoppingCartPage.product_addToCart();
        shoppingCartPage.toCart();
        shoppingCartPage.pageLoading();
        shoppingCartPage.clickOnCheckBoxTermsOfService();
        shoppingCartPage.clickOnCheckoutBtn();
        checkoutPage.uncheckShipToTheSameAddress();
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.continueBtnShippingAddress();
    }

    @Given("user selects ground method as shipping method")
    public void userSelectsGroundMethodAsShippingMethod() {
        checkoutPage.groundShippingMethodSelect();
        checkoutPage.continueBtnShippingMethod();
        checkoutPage.networkLoading();
    }

    @Then("user should be redirected to checkout-payment method page")
    public void userShouldBeRedirectedToCheckoutPaymentMethodPage() {
        Assertions.assertTrue(checkoutPage.checkOrMoneyOrderText());
        shoppingCartPage.cleanCart();
    }

    @Given("user selects next day air as shipping method")
    public void userSelectsNextDayAirAsShippingMethod() {
        checkoutPage.nextDayShippingMethodSelect();
        checkoutPage.continueBtnShippingMethod();
        checkoutPage.networkLoading();
    }

    @Given("user selects second day air as shipping method")
    public void userSelectsSecondDayAirAsShippingMethod() {
        checkoutPage.secondDayShippingMethodSelect();
        checkoutPage.continueBtnShippingMethod();
        checkoutPage.networkLoading();
    }

    @Given("user logs in and goes to checkout-payment method page with a product in cart")
    public void userLogsInAndGoesToCheckoutPaymentMethodPageWithAProductInCart() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader1.getCellData(sheet1Name, "Email", 7));
        loginPage.enterPassword(reader1.getCellData(sheet1Name, "Password", 7));
        loginPage.clickOnLoginButton();
        shoppingCartPage.productsDetailsPage(reader2.getCellData(sheet2Name, "productA", 2));
        shoppingCartPage.pageLoading();
        shoppingCartPage.product_addToCart();
        shoppingCartPage.toCart();
        shoppingCartPage.pageLoading();
        shoppingCartPage.clickOnCheckBoxTermsOfService();
        shoppingCartPage.clickOnCheckoutBtn();
        checkoutPage.uncheckShipToTheSameAddress();
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.continueBtnShippingMethod();
    }

    @Given("user selects check or money order option as payment method")
    public void userSelectsCheckOrMoneyOrderOptionAsPaymentMethod() {
        checkoutPage.selectCheckOrMoneyOrder();
        checkoutPage.continueBtnPaymentMethod();
        checkoutPage.networkLoading();
    }
    @Given("user selects credit card as payment method")
    public void userSelectsCreditCardAsPaymentMethod() {
        checkoutPage.selectCreditCardOption();
        checkoutPage.continueBtnPaymentMethod();
        checkoutPage.networkLoading();
    }
    @Then("user should see the payment info section is displayed")
    public void userShouldSeeThePaymentInfoSectionIsDisplayed() {
        Assertions.assertTrue(checkoutPage.paymentInfoDiv());
        shoppingCartPage.cleanCart();
    }

    @Given("user logs in and goes to checkout-order confirmation page with a product in cart")
    public void userLogsInAndGoesToCheckoutOrderConfirmationPageWithAProductInCart() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader1.getCellData(sheet1Name, "Email", 7));
        loginPage.enterPassword(reader1.getCellData(sheet1Name, "Password", 7));
        loginPage.clickOnLoginButton();
        shoppingCartPage.productsDetailsPage(reader2.getCellData(sheet2Name, "productA", 2));
        shoppingCartPage.pageLoading();
        shoppingCartPage.productQty(2);
        shoppingCartPage.product_addToCart();
        shoppingCartPage.toCart();
        shoppingCartPage.clickOnCheckBoxTermsOfService();
        shoppingCartPage.clickOnCheckoutBtn();
        checkoutPage.uncheckShipToTheSameAddress();
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.continueBtnShippingMethod();
        checkoutPage.continueBtnPaymentMethod();
        checkoutPage.continueBtnPaymentInfo();
        checkoutPage.networkLoading();
    }

    @Given("user should see the billing address section is displayed")
    public void userShouldSeeTheBillingAddressSectionIsDisplayed() {
        Assertions.assertTrue(checkoutPage.billingAddressSection());
        shoppingCartPage.cleanCart();
    }

    @Given("user should see the shipping address section is displayed")
    public void userShouldSeeTheShippingAddressSectionIsDisplayed() {
        Assertions.assertTrue(checkoutPage.shippingAddressSection());
        shoppingCartPage.cleanCart();
    }

    @Given("user should see the payment method section is displayed")
    public void userShouldSeeThePaymentMethodSectionIsDisplayed() {
        String actualMsg=checkoutPage.paymentMethod();
        String expectedMsg=reader4.getCellData("orderConfirm","payment",2);
        Assertions.assertEquals(expectedMsg,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @Given("user should see the shipping method section is displayed")
    public void userShouldSeeTheShippingMethodSectionIsDisplayed() {
        String actualMsg=checkoutPage.shippingMethod();
        String expectedMsg=reader4.getCellData("orderConfirm","shipping",2);
        Assertions.assertEquals(expectedMsg,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @Given("user should see product's sku is displayed")
    public void userShouldSeeProductSSkuIsDisplayed() {
        String actualMsg=checkoutPage.productSku();
        String expectedMsg=reader4.getCellData("orderConfirm","sku",2);
        Assertions.assertEquals(expectedMsg,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @Given("user clicks on productA's image from order confirm page")
    public void userClicksOnProductASImageFromOrderConfirmPage() {
        checkoutPage.productImageClick();
    }

    @Given("user clicks on productA's name from order confirm page")
    public void userClicksOnProductASNameFromOrderConfirmPage() {
        checkoutPage.productNameClick();
    }

    @Given("user should see product's correct total price is displayed in the table of confirm order page")
    public void userShouldSeeProductSCorrectTotalPriceIsDisplayedInTheTableOfConfirmOrderPage() {
        double unitPrice=shoppingCartPage.unitPriceConverter();
        double totalPrice=shoppingCartPage.totalPriceConverterActualCartTop();
        Assertions.assertEquals(totalPrice,unitPrice*2);
        shoppingCartPage.cleanCart();
    }

    @Given("user clicks on confirm button")
    public void userClicksOnConfirmButton() {
        checkoutPage.networkLoading();
        checkoutPage.clickOnOrderConfirm();
        page.waitForTimeout(3000);
    }

    @Then("user should see order success message is displayed")
    public void userShouldSeeOrderSuccessMessageIsDisplayed() {
        String actualMsg=checkoutPage.orderSuccessMsg();
        String expectedMsg=reader4.getCellData("orderConfirm","order success",2);
        Assertions.assertEquals(expectedMsg,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @Given("user should see product's quantity {string} is displayed in the table of confirm order page")
    public void userShouldSeeProductSQuantityIsDisplayedInTheTableOfConfirmOrderPage(String expectedQnty) {
        String actualQnty=checkoutPage.productQuantity();
        Assertions.assertEquals(expectedQnty,actualQnty);
        shoppingCartPage.cleanCart();
    }

    @Given("user logs in and goes to checkout-order success page with a product in cart")
    public void userLogsInAndGoesToCheckoutOrderSuccessPageWithAProductInCart() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader1.getCellData(sheet1Name, "Email", 7));
        loginPage.enterPassword(reader1.getCellData(sheet1Name, "Password", 7));
        loginPage.clickOnLoginButton();
        shoppingCartPage.productsDetailsPage(reader2.getCellData(sheet2Name, "productA", 2));
        shoppingCartPage.pageLoading();
        shoppingCartPage.productQty(2);
        shoppingCartPage.product_addToCart();
        shoppingCartPage.toCart();
        shoppingCartPage.clickOnCheckBoxTermsOfService();
        shoppingCartPage.clickOnCheckoutBtn();
        checkoutPage.uncheckShipToTheSameAddress();
        checkoutPage.continueBtnBillingAddress();
        checkoutPage.continueBtnShippingAddress();
        checkoutPage.continueBtnShippingMethod();
        checkoutPage.continueBtnPaymentMethod();
        checkoutPage.continueBtnPaymentInfo();
        checkoutPage.clickOnOrderConfirm();
    }

    @Given("user should see order number is displayed")
    public void userShouldSeeOrderNumberIsDisplayed() {
        String actualMsg=checkoutPage.orderNumber();
        String expectedMsg=reader4.getCellData("orderConfirm","order number",2);
        Assertions.assertTrue(actualMsg.contains(expectedMsg));
    }

    @Given("user clicks on order details link")
    public void userClicksOnOrderDetailsLink() {
        checkoutPage.clickOnOrderDetailsLink();
    }

    @Then("user should see order details page is displayed with title")
    public void userShouldSeeOrderDetailsPageIsDisplayedWithTitle() {
        String actualMsg=checkoutPage.pageTitleText();
        String expectedMsg=reader4.getCellData("orderConfirm","page title",2);
        Assertions.assertEquals(expectedMsg,actualMsg);
        shoppingCartPage.cleanCart();
    }
}
