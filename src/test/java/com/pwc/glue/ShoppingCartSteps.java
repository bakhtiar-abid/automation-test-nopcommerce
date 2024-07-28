package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.HomepagePage;
import com.pages.LoginPage;
import com.pages.Shopping_CartPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.sql.Driver;

public class ShoppingCartSteps {
    Page page= DriverFactory.getPage();
    LoginPage loginPage= new LoginPage(page);
    HomepagePage homePage = new HomepagePage(page);
    Shopping_CartPage shoppingCartPage= new Shopping_CartPage(DriverFactory.getPage());
    Xls_Reader reader = new Xls_Reader("src/test/resources/config/Testdata/cartData.xlsx");
    String sheet1Name = "productDetails";
    String sheet2Name = "actualCart";
    Xls_Reader reader2 = new Xls_Reader("src/test/resources/config/Testdata/Testdata.xlsx");
    String sheet3Name = "Login";
    final String baseUrl= FileReaderManager.getInstance().getConfigReader().getBaseUrl();
    @Given("user goes to productB's page")
    public void userGoesToProductBSPage() {
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productB", 2));
    }
    @Then("user clicks on add to cart from product details page")
    public void userClicksOnAddToCartFromProductDetailsPage() {
        shoppingCartPage.pageLoading();
        shoppingCartPage.product_addToCart();
    }

    @And("user should get a warning message {string} and {string}")
    public void userShouldGetAWarningMessageAnd(String st1, String st2) {
        String msg1 = shoppingCartPage.warningMsg1ProductB();
        Assertions.assertTrue(msg1.contains(st1));
        String msg2 = shoppingCartPage.warningMsg2ProductB();
        Assertions.assertTrue(msg2.contains(st2));
    }
    @Given("user goes to productA's page")
    public void userGoesToProductASPage() {
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productA", 2));
    }
    @And("user fills in quantity as {int}")
    public void userFillsInQuantityAs(int q1) {
        shoppingCartPage.productQty(q1);
    }

    @And("user should get a warning message {string}")
    public void userShouldGetAWarningMessage(String st1) {
        String msg1=shoppingCartPage.warningMsgOfProduct();
        Assertions.assertTrue(msg1.contains(st1));
    }
    @And("user goes to cart")
    public void userGoesToCart() {
        shoppingCartPage.toCart();
        shoppingCartPage.pageLoading();

    }
    @And("user clicks on update shopping cart")
    public void userClicksOnUpdateShoppingCart() {
        shoppingCartPage.updateShoppingCart();
    }
    @And("user should get a warning message in shopping cart page {string}")
    public void userShouldGetAWarningMessageInShoppingCartPage(String st1) {
    String msg1=shoppingCartPage.CartWarningMsg();
    Assertions.assertTrue(msg1.contains(st1));
    shoppingCartPage.cleanCart();
    }

    @Given("user goes to productC's page")
    public void userGoesToProductCSPage() {
        shoppingCartPage.productCPage(reader.getCellData(sheet1Name, "productC", 2));
    }

    @Then("user should see productA is present in cart")
    public void userShouldSeeProductAIsPresentInCart() {
        String pName=shoppingCartPage.ShoppingCartProductName();
        Assertions.assertTrue(pName.contains(reader.getCellData(sheet1Name, "productA", 2)));
        shoppingCartPage.cleanCart();
    }
    @And("user selects processor,ram,os and software.")
    public void userSelectsProcessorRamOsAndSoftware() {
        shoppingCartPage.pageLoading();
        shoppingCartPage.selectCustomAttributesProductB();
    }
    @And("user should see productB is present in cart")
    public void userShouldSeeProductBIsPresentInCart() {
        String pName=shoppingCartPage.ShoppingCartProductName();
        Assertions.assertTrue(pName.contains(reader.getCellData(sheet1Name, "productB", 2)));
        shoppingCartPage.cleanCart();
    }
    @And("user should see the total price is updated")
    public void userShouldSeeTheTotalPriceIsUpdated() {
    double unitPrice=shoppingCartPage.unitPriceConverter();
    double totalPrice=shoppingCartPage.totalPriceConverterActualCartTop();
    Assertions.assertEquals(totalPrice,unitPrice*10);
    shoppingCartPage.cleanCart();
    }

    @Then("user should see product is present in mini cart")
    public void userShouldSeeProductIsPresentInMiniCart() {
        shoppingCartPage.clickOnCloseButtonNotification();
    String miniCartPName=shoppingCartPage.miniCartProductName();
    Assertions.assertTrue(miniCartPName.contains(reader.getCellData(sheet1Name, "productA", 2)));

    }

    @And("user clicks on item\\(s) from mini cart")
    public void userClicksOnItemSFromMiniCart()  {
    shoppingCartPage.clickOnItemsFromMiniCart();
    shoppingCartPage.cleanCart();
    }
    @And("user should be in the shopping cart page with page title {string}")
    public void userShouldBeInTheShoppingCartPageWithPageTitle(String title1) {
        String cartTitle= shoppingCartPage.pageTitle();
        Assertions.assertEquals(title1, cartTitle);
        shoppingCartPage.cleanCart();
    }
    @And("user clicks on productA's name")
    public void userClicksOnProductASName() {
    shoppingCartPage.clickOnMiniCartProductName();
    }

    @And("user should be redirected to productA's details page")
    public void userShouldBeRedirectedToProductASDetailsPage() {
       String a= shoppingCartPage.productANameFromDetailsPage();
       String productAName=reader.getCellData(sheet1Name, "productA", 2);
        Assertions.assertTrue(a.contains(productAName));
        shoppingCartPage.cleanCart();
    }

    @Then("user clicks on go to cart from mini cart")
    public void userClicksOnGoToCartFromMiniCart() {
        shoppingCartPage.clickOnGoToCartFromMiniCart();
    }

    @And("user should see product's correct quantity is displayed")
    public void userShouldSeeProductSCorrectQuantityIsDisplayed() {
        String Qnty=shoppingCartPage.productQuantityChecker();
        Assertions.assertEquals("2",Qnty);
        shoppingCartPage.cleanCart();
    }

    @And("user should see product's correct unit price is displayed")
    public void userShouldSeeProductSCorrectUnitPriceIsDisplayed() {
        double unitPriceActual=shoppingCartPage.productUnitPriceConvertFromMiniCart();
        double unitPriceExpected= shoppingCartPage.productPriceFromProductDetailsPage();
        Assertions.assertEquals(unitPriceExpected,unitPriceActual);
        shoppingCartPage.cleanCart();

    }

    @And("user should see product's correct sub-total price is displayed in mini cart")
    public void userShouldSeeProductSCorrectSubTotalPriceIsDisplayedInMiniCart() {
    double subTotalPriceActual=shoppingCartPage.productSubTotalPriceConvertFromMiniCart();
    double unitPriceExpected= shoppingCartPage.productPriceFromProductDetailsPage();
    double subTotalPriceExpected= 2*unitPriceExpected;
    Assertions.assertEquals(subTotalPriceExpected, subTotalPriceActual);
    shoppingCartPage.cleanCart();
    }

    @Given("user goes to productD's page")
    public void userGoesToProductDSPage() {
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productD", 2));
    }

    @And("user fills in all the required fields of productD")
    public void userFillsInAllTheRequiredFieldsOfProductD() {
    shoppingCartPage.fillInRequiredFieldOfProductD(reader.getCellData(sheet1Name, "recipient's name", 2), reader.getCellData(sheet1Name, "recipient's email", 2));
    }

    @And("user should see productD is present in cart")
    public void userShouldSeeProductDIsPresentInCart() {
        String pName=shoppingCartPage.ShoppingCartProductName();
        Assertions.assertTrue(pName.contains(reader.getCellData(sheet1Name, "productD", 2)));
        shoppingCartPage.cleanCart();
    }

    @Given("user goes to productE's page")
    public void userGoesToProductESPage() {
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productE", 2));
    }

    @And("user should see productE - Black is added to cart")
    public void userShouldSeeProductEBlackIsAddedToCart() {
        String pName=shoppingCartPage.ShoppingCartProductName();
        Assertions.assertTrue(pName.contains(reader.getCellData(sheet1Name, "productE-Black", 2)));
        shoppingCartPage.cleanCart();
    }

    @Given("user goes to productF")
    public void userGoesToProductF() {
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productF", 2));
    }

    @And("user fills in required fields of physical gift card")
    public void userFillsInRequiredFieldsOfPhysicalGiftCard() {
        shoppingCartPage.fillInRequiredFieldOfProductF(reader.getCellData(sheet1Name, "recipient's name", 2));
    }

    @And("user should see the productF is added to cart")
    public void userShouldSeeTheProductFIsAddedToCart() {
        String pName=shoppingCartPage.ShoppingCartProductName();
        Assertions.assertTrue(pName.contains(reader.getCellData(sheet1Name, "productF", 2)));
        shoppingCartPage.cleanCart();
    }

    @Given("user goes to productG's page")
    public void userGoesToProductGSPage() {
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productG", 2));
    }

    @And("user selects size, color and print")
    public void userSelectsSizeColorAndPrint() {
    shoppingCartPage.selectCustomProductAttributesProductG();
    }

    @And("user should see productG is added to cart")
    public void userShouldSeeProductGIsAddedToCart() {
        String pName=shoppingCartPage.ShoppingCartProductName();
        Assertions.assertTrue(pName.contains(reader.getCellData(sheet1Name, "productG", 2)));
        shoppingCartPage.cleanCart();
    }

    @Given("user goes to productH's page")
    public void userGoesToProductHSPage() {
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productH", 2));
    }

    @And("user should see the price is reduced and calculated using the tier price")
    public void userShouldSeeThePriceIsReducedAndCalculatedUsingTheTierPrice() {
        double tierPriceActual=shoppingCartPage.tierPriceRead();
        double totalPrice=shoppingCartPage.totalPriceConverterActualCartTop();
        Assertions.assertEquals(totalPrice,tierPriceActual*3);
        shoppingCartPage.cleanCart();
    }


    @Given("user goes to productI's page")
    public void userGoesToProductISPage() {
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productI", 2));
    }

    @And("user should see productI is added to cart")
    public void userShouldSeeProductIIsAddedToCart() {
        String pName=shoppingCartPage.ShoppingCartProductName();
        Assertions.assertTrue(pName.contains(reader.getCellData(sheet1Name, "productI", 2)));
        shoppingCartPage.cleanCart();
    }

    @Given("user goes to productK's page")
    public void userGoesToProductKSPage() {
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productK", 2));
    }

    @And("user fills in the price for donation by giving a value out of range")
    public void userFillsInThePriceForDonationByGivingAValueOutOfRange() {
        shoppingCartPage.fillingInPriceForDonation(reader.getCellData(sheet1Name, "invalid price input range", 2));
    }

    @And("user fills in the price for donation")
    public void userFillsInThePriceForDonation() {
        shoppingCartPage.fillingInPriceForDonation(reader.getCellData(sheet1Name, "valid price input range", 2));
    }

    @And("user should see productK is added to cart")
    public void userShouldSeeProductKIsAddedToCart() {
        String pName=shoppingCartPage.ShoppingCartProductName();
        Assertions.assertTrue(pName.contains(reader.getCellData(sheet1Name, "productK", 2)));
        shoppingCartPage.cleanCart();
    }

    @Given("user goes to productJ's page")
    public void userGoesToProductJSPage() {
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productJ", 2));
    }

    @And("user fills in start date and end date by giving a past date")
    public void userFillsInStartDateAndEndDateByGivingAPastDate() {
        shoppingCartPage.fillInDate("10/10/21","10/11/21");
    }

    @And("user fills in start date and end date by giving a future date")
    public void userFillsInStartDateAndEndDateByGivingAFutureDate() {
        shoppingCartPage.fillInDate("10/10/25","10/11/25");
    }

    @And("user should see the productJ is added in cart")
    public void userShouldSeeTheProductJIsAddedInCart() {
        String pName=shoppingCartPage.ShoppingCartProductName();
        Assertions.assertTrue(pName.contains(reader.getCellData(sheet1Name, "productJ", 2)));
        shoppingCartPage.cleanCart();
    }


    @Then("user clicks on remove button")
    public void userClicksOnRemoveButton() {
        shoppingCartPage.cleanCart();
    }

    @And("user should get a message {string}")
    public void userShouldGetAMessage(String st1) {
        String msg1=shoppingCartPage.cartEmptyMsg();
        Assertions.assertEquals(st1,msg1);
    }

    @Then("user clicks on edit option and user changes ram size")
    public void userClicksOnEditOptionAndUserChangesRamSize() {
        shoppingCartPage.clickOnEditButton();
        shoppingCartPage.updateRam();
    }

    @And("user checks the updated ram is added in the cart")
    public void userChecksTheUpdatedRamIsAddedInTheCart() {
        String attributesTextActual=shoppingCartPage.attributesTextOfShoppingCart();
        String attributesTextExpected=reader.getCellData(sheet1Name,"productB", 3);
        Assertions.assertTrue(attributesTextActual.contains(attributesTextExpected));
        shoppingCartPage.cleanCart();
    }

    @Then("user clicks on image of the product")
    public void userClicksOnImageOfTheProduct() {
        shoppingCartPage.clickOnImageOfProductFromCart();
    }

    @Then("user clicks on name of the product")
    public void userClicksOnNameOfTheProduct() {
        shoppingCartPage.clickOnNameOfProductFromCart();
    }

    @Then("user clicks on back button of browser")
    public void userClicksOnBackButtonOfBrowser() {
        shoppingCartPage.clickOnBackButtonOfBrowser();
        shoppingCartPage.pageLoading();
    }

    @And("user should see total price is updated and not changed due to use of back button")
    public void userShouldSeeTotalPriceIsUpdatedAndNotChangedDueToUseOfBackButton() {
        double unitPrice=shoppingCartPage.unitPriceConverter();
        double totalPrice=shoppingCartPage.totalPriceConverterActualCartTop();
        Assertions.assertEquals(totalPrice,unitPrice*10);
        shoppingCartPage.cleanCart();
    }

    @Then("user selects gift wrapping as yes")
    public void userSelectsGiftWrappingAsYes(){
        shoppingCartPage.selectGiftWrapping();
    }

    @And("user checks the total value has increased")
    public void userChecksTheTotalValueHasIncreased() {
        double actualTotalValueCartFooter= shoppingCartPage.totalValueCartFooter();
        String expectedTotalValueCartFooterString=reader.getCellData(sheet1Name,"cart total1",2);
        double expectedTotalValueCartFooterDouble=Double.parseDouble(expectedTotalValueCartFooterString);
        Assertions.assertEquals(expectedTotalValueCartFooterDouble,actualTotalValueCartFooter);
        shoppingCartPage.cleanCart();
    }

    @Then("user should see the total value of cart footer is showing correct value")
    public void userShouldSeeTheTotalValueOfCartFooterIsShowingCorrectValue() {
        double actualTotalValueCartFooter= shoppingCartPage.totalValueCartFooter();
        String expectedTotalValueCartFooterString=reader.getCellData(sheet1Name,"cart total2",2);
        double expectedTotalValueCartFooterDouble=Double.parseDouble(expectedTotalValueCartFooterString);
        Assertions.assertEquals(expectedTotalValueCartFooterDouble,actualTotalValueCartFooter);
        shoppingCartPage.cleanCart();
    }


    @And("user clicks on estimate shipping")
    public void userClicksOnEstimateShipping() {
        shoppingCartPage.clickOnEstimateShipping();
    }

    @And("user selects country and enters zip code")
    public void userSelectsCountryAndEntersZipCode() {
        shoppingCartPage.selectCountryAndZipEstimateShipping();

    }

    @Then("user should see the shipping methods are displayed")
    public void userShouldSeeTheShippingMethodsAreDisplayed() {
        String actualShippingMethod=shoppingCartPage.shippingMethodDisplay();
        String expectedShippingMethod=reader.getCellData(sheet2Name, "shipping method", 2);
        Assertions.assertEquals(expectedShippingMethod, actualShippingMethod);
        shoppingCartPage.estimateShippingClose();
        shoppingCartPage.cleanCart();
    }

    @And("user deselects the country")
    public void userDeselectsTheCountry() {
        shoppingCartPage.deselectCountryEstimateShipping();
    }

    @Then("user should get a warning message in estimate shipping {string}")
    public void userShouldGetAWarningMessageInEstimateShipping(String st1) {
        String actualWarningMsg= shoppingCartPage.estimateShippingWarningMsg();
        Assertions.assertEquals(st1, actualWarningMsg);
        shoppingCartPage.estimateShippingClose();
        shoppingCartPage.cleanCart();
    }

    @And("user clears zip code field")
    public void userClearsZipCodeField() {
        shoppingCartPage.clearZipCodeEstimateShipping();

    }

    @And("user selects shipping method")
    public void userSelectsShippingMethod() {
        shoppingCartPage.selectShippingMethod();
        shoppingCartPage.estimateShippingClose();
    }

    @Then("user checks the total value")
    public void userChecksTheTotalValue() {
        double actualTotalValueCartFooter= shoppingCartPage.totalValueCartFooter();
        String expectedTotalValueCartFooterString=reader.getCellData(sheet2Name,"total value cart",2);
        double expectedTotalValueCartFooterDouble=Double.parseDouble(expectedTotalValueCartFooterString);
        Assertions.assertEquals(expectedTotalValueCartFooterDouble,actualTotalValueCartFooter);
        shoppingCartPage.cleanCart();
    }

    @Then("user inserts a invalid discount code")
    public void userInsertsAInvalidDiscountCode() {
        shoppingCartPage.insertDiscountCode(reader.getCellData(sheet2Name,"invalid discount",2));
    }

    @And("user clicks on apply coupon")
    public void userClicksOnApplyCoupon() {
        shoppingCartPage.clickOnapplyDiscount();
    }

    @And("user should see a warning message under discount box {string}")
    public void userShouldSeeAWarningMessageUnderDiscountBox(String st1) {
        String actualMsg=shoppingCartPage.discountMsg();
        Assertions.assertEquals(st1, actualMsg);
        shoppingCartPage.cleanCart();
    }

    @Then("user inserts a valid discount code")
    public void userInsertsAValidDiscountCode() {
        shoppingCartPage.insertDiscountCode(reader.getCellData(sheet2Name, "valid discount",2));

    }

    @And("user should see the discount is added and a message {string}")
    public void userShouldSeeTheDiscountIsAddedAndAMessage(String st1) {

    }
    @And("user should see the discount is added in total value")
    public void userShouldSeeTheDiscountIsAddedInTotalValue() {
        double actualTotalValueCartFooter= shoppingCartPage.totalValueCartFooter();
        String expectedTotalValueCartFooterString=reader.getCellData(sheet2Name,"total after discount",2);
        double expectedTotalValueCartFooterDouble=Double.parseDouble(expectedTotalValueCartFooterString);
        Assertions.assertEquals(expectedTotalValueCartFooterDouble,actualTotalValueCartFooter);
    }
    @And("user should get a message under discount box {string}")
    public void userShouldGetAMessageUnderDiscountBox(String st1) {
        String actualMsg=shoppingCartPage.discountMsg();
        Assertions.assertEquals(st1, actualMsg);
        shoppingCartPage.removeDiscount();
        shoppingCartPage.cleanCart();
    }

    @And("user clicks on remove button of discount code")
    public void userClicksOnRemoveButtonOfDiscountCode() {
        shoppingCartPage.removeDiscount();
    }

    @And("user should see the discount code is removed")
    public void userShouldSeeTheDiscountCodeIsRemoved() {
        Assertions.assertTrue(shoppingCartPage.discountCodeRemoved());
        shoppingCartPage.cleanCart();
    }

    @And("user clicks on continue shopping")
    public void userClicksOnContinueShopping() {
        shoppingCartPage.clickOnContinueShopping();
    }

    @And("user should see the discount is still there")
    public void userShouldSeeTheDiscountIsStillThere() {
        String actualDiscountCoupon=shoppingCartPage.discountCouponCodeMsg();
        String expectedDiscountCoupon=reader.getCellData(sheet2Name,"valid discount",2);
        Assertions.assertTrue(actualDiscountCoupon.contains(expectedDiscountCoupon));
        shoppingCartPage.removeDiscount();
        shoppingCartPage.cleanCart();
    }

    @And("user clicks on add gift card")
    public void userClicksOnAddGiftCard() {
        shoppingCartPage.applyGiftCard();
    }

    @Then("user should see a warning message under gift cards box {string}")
    public void userShouldSeeAWarningMessageUnderGiftCardsBox(String st1) {
        String actualMsg=shoppingCartPage.giftCardMsg();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.cleanCart();
    }

    @Then("user inserts a invalid gift card code")
    public void userInsertsAInvalidGiftCardCode() {
        shoppingCartPage.insertGiftCardCode(reader.getCellData(sheet2Name,"invalid giftcard",2));
    }

    @Then("user inserts a valid gift card code")
    public void userInsertsAValidGiftCardCode() {
        shoppingCartPage.insertGiftCardCode(reader.getCellData(sheet2Name,"valid giftcard",2));
    }
    @And("user should see the gift card is added in total value")
    public void userShouldSeeTheGiftCardIsAddedInTotalValue() {
        double actualTotalValueCartFooter= shoppingCartPage.totalValueCartFooter();
        String expectedTotalValueCartFooterString=reader.getCellData(sheet2Name,"total after using giftcard",2);
        double expectedTotalValueCartFooterDouble=Double.parseDouble(expectedTotalValueCartFooterString);
        Assertions.assertEquals(expectedTotalValueCartFooterDouble,actualTotalValueCartFooter);
    }

    @And("user should get a message under gift card box {string}")
    public void userShouldGetAMessageUnderGiftCardBox(String st1) {
        String actualMsg=shoppingCartPage.giftCardMsg();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.removeGiftCard();
        shoppingCartPage.cleanCart();
    }

    @And("user clicks on remove button of gift card")
    public void userClicksOnRemoveButtonOfGiftCard() {
        shoppingCartPage.removeGiftCard();
    }

    @And("user should see the gift card code is removed")
    public void userShouldSeeTheGiftCardCodeIsRemoved() {
        Assertions.assertTrue(shoppingCartPage.giftCardCodeRemoved());
        shoppingCartPage.cleanCart();
    }

    @And("user can see both gift card and discount code added")
    public void userCanSeeBothGiftCardAndDiscountCodeAdded() {
        Assertions.assertFalse(shoppingCartPage.discountCodeRemoved());
        Assertions.assertFalse(shoppingCartPage.giftCardCodeRemoved());
        shoppingCartPage.removeDiscount();
        shoppingCartPage.removeGiftCard();
        shoppingCartPage.cleanCart();
    }

    @And("user should see a pop-up of terms of service with warning message {string}")
    public void userShouldSeeAPopUpOfTermsOfServiceWithWarningMessage(String st1) {
        String actualMsg=shoppingCartPage.termsOfServiceWarningMsg();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.closeTermsOfServiceMsgBox();
        shoppingCartPage.cleanCart();
    }
    @Then("user clicks on checkbox of terms of service")
    public void userClicksOnCheckboxOfTermsOfService() {
        shoppingCartPage.clickOnCheckBoxTermsOfService();
    }

    @And("user clicks on checkout")
    public void userClicksOnCheckout() {
        shoppingCartPage.clickOnCheckoutBtn();
    }
    @And("user should see the checkout page loaded with title {string}")
    public void userShouldSeeTheCheckoutPageLoadedWithTitle(String st1) {
        String checkoutTitle = shoppingCartPage.pageTitle();
        Assertions.assertEquals(st1, checkoutTitle);
        shoppingCartPage.cleanCart();
    }

    @Then("user clicks on read link of terms of service")
    public void userClicksOnReadLinkOfTermsOfService() {
        shoppingCartPage.clickOnReadLinkOfTerms();
    }

    @And("user should see the terms of service pop-up with headline {string}")
    public void userShouldSeeTheTermsOfServicePopUpWithHeadline(String st1) {
        String actualMsg=shoppingCartPage.termsOfServiceConditions();
        Assertions.assertEquals(st1,actualMsg);
        shoppingCartPage.closeTermsOfServiceMsgBox();
        shoppingCartPage.cleanCart();
    }


    @Given("user logging in and going to cart after adding a product to cart")
    public void userLoggingInAndGoingToCartAfterAddingAProductToCart() {
        homePage.gotoHomepage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader2.getCellData(sheet3Name, "Email", 7));
        loginPage.enterPassword(reader2.getCellData(sheet3Name, "Password", 7));
        loginPage.clickOnLoginButton();
        loginPage.goToHomePage(baseUrl);
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productA", 2));
        shoppingCartPage.pageLoading();
        shoppingCartPage.product_addToCart();
        shoppingCartPage.toCart();
        shoppingCartPage.pageLoading();
    }

    @And("user logging in and going to product details page of productA")
    public void userLoggingInAndGoingToProductDetailsPageOfProductA() {
        homePage.gotoHomepage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader2.getCellData(sheet3Name, "Email", 7));
        loginPage.enterPassword(reader2.getCellData(sheet3Name, "Password", 7));
        loginPage.clickOnLoginButton();
        loginPage.goToHomePage(baseUrl);
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productA", 2));
    }

    @And("user logging in and going to product details page of productK")
    public void userLoggingInAndGoingToProductDetailsPageOfProductK() {
        homePage.gotoHomepage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader.getCellData(sheet3Name, "Email", 7));
        loginPage.enterPassword(reader.getCellData(sheet3Name, "Password", 7));
        loginPage.clickOnLoginButton();
        loginPage.goToHomePage(baseUrl);
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productK", 2));
    }

    @And("user logging in and going to product details page of productJ")
    public void userLoggingInAndGoingToProductDetailsPageOfProductJ() {
        homePage.gotoHomepage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader.getCellData(sheet3Name, "Email", 7));
        loginPage.enterPassword(reader.getCellData(sheet3Name, "Password", 7));
        loginPage.clickOnLoginButton();
        loginPage.goToHomePage(baseUrl);
        shoppingCartPage.productsDetailsPage(reader.getCellData(sheet1Name, "productJ", 2));
    }
}
