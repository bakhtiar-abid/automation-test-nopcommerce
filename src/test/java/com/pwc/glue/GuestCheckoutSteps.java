package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.GuestCheckoutPage;
import com.pages.HomepagePage;
import com.qa.managers.DriverFactory;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class GuestCheckoutSteps {
    Page page = DriverFactory.getPage();
    GuestCheckoutPage guestCheckoutPage = new GuestCheckoutPage(page);
    HomepagePage homepage = new HomepagePage(page);
    Xls_Reader xlsReader = new Xls_Reader("src/test/resources/config/Testdata/guestCheckoutData.xlsx");
    String sheetName = "guestCheckout";

    /* Collect data from excel */
    String firstName = xlsReader.getCellData(sheetName, "firstName", 2);
    String lastName = xlsReader.getCellData(sheetName, "lastName", 2);
    String email = xlsReader.getCellData(sheetName, "email", 2);
    String country = xlsReader.getCellData(sheetName, "country", 2);
    String state = xlsReader.getCellData(sheetName, "state", 2);
    String city = xlsReader.getCellData(sheetName, "city", 2);
    String address1 = xlsReader.getCellData(sheetName, "address1", 2);
    String zip = xlsReader.getCellData(sheetName, "zip", 2);
    String phoneNo = xlsReader.getCellData(sheetName, "phoneNo", 2);
    String expectedOrderSuccessMsg = xlsReader.getCellData(sheetName, "orderSuccessMsg", 2);
    @Then("Add the product to the cart and go for checkout")
    public void addTheProductToTheCartAndGoForCheckout() {
        guestCheckoutPage.clickAddToCartBtnFromProductDetailsPage();
        homepage.clickShoppingCartFromHeader();
        guestCheckoutPage.selectTermsOrServiceCheckbox();
        guestCheckoutPage.clickCheckoutBtn();
        guestCheckoutPage.clickGuestCheckoutBtn();
    }

    @Given("Fill all the field for the billing address shipping address and select the shipping and payment methods")
    public void fillAllTheFieldForTheBillingAddressShippingAddressAndSelectTheShippingAndPaymentMethods() {
        guestCheckoutPage.clickBillingAddressDeleteBtn();
        guestCheckoutPage.fillFirstName(firstName);
        guestCheckoutPage.fillLastName(lastName);
        guestCheckoutPage.fillEmail(email);
        guestCheckoutPage.selectCountryName(country);
        guestCheckoutPage.selectState(state);
        guestCheckoutPage.fillCityName(city);
        guestCheckoutPage.fillAddress1(address1);
        guestCheckoutPage.fillZipCode(zip);
        guestCheckoutPage.fillPhoneNumber(phoneNo);

        guestCheckoutPage.clickBillingAddressContinueBtn();
        guestCheckoutPage.clickShippingAddressContinueBtn();
        guestCheckoutPage.selectShippingMethodGroundOption();
        guestCheckoutPage.clickShippingMethodContinueBtn();
        guestCheckoutPage.selectPaymentMethodMoneyOrderOption();
        guestCheckoutPage.clickPaymentMethodContinueBtn();
        guestCheckoutPage.clickPaymentInfoContinueBtn();
        guestCheckoutPage.clickOrderConfirmBtn();

    }

    @Then("Verify the all over product checkout complete by product price order number and product title")
    public void verifyTheAllOverProductCheckoutCompleteByProductPriceOrderNumberAndProductTitle() {
        String actualOrderConfirmMsg = guestCheckoutPage.getOrderSuccessMsg();
        Assertions.assertEquals(expectedOrderSuccessMsg, actualOrderConfirmMsg);
    }
}
