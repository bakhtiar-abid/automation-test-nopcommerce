package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.managers.FileReaderManager;

public class Shopping_CartPage {
    private Page page;
    private final String searchBar = "//*[@id='small-searchterms']";
    private final String searchButton = "//*[@id='small-search-box-form']/button";
    private final String searchedResultProduct = "(//h2[@class='product-title']/a)[1]";
    private final String productBWarningMsg1 = "(//*[@id='bar-notification']/div/p)[1]";
    private final String productBWarningMsg2 = "(//*[@id='bar-notification']/div/p)[2]";
    private final String cart_button_product = "//button[@class='button-1 add-to-cart-button']";
    private final String productWarningMsg1 = "(//*[@id='bar-notification']/div/p)[1]";
    private final String productQntyInput = "//input[@class='qty-input']";
    private final String shoppingCartBtnFromNotification = "//*[@id='bar-notification']/div/p/a";
    private final String shoppingCartBtnFromMiniCart = "//*[@id='topcartlink']/a/span[1]";
    private final String removeBtnShoppingCart = "//button[@class='remove-btn']";
    private final String productIsPresent = "//table[@class='cart']";
    private final String updateShoppingCartButton = "//*[@id='updatecart']";
    private final String shoppingCartWarningMsg = "//div[@class='message-error']/ul/li";
    private final String cartProductName = "//a[@class='product-name'][1]";
    private final String processor = "//*[@id='product_attribute_1']";
    private final String ram = "//*[@id='product_attribute_2']";
    private final String hdd = "//*[@id='product_attribute_3_6']";
    private final String os = "//*[@id='product_attribute_4_8']";
    private final String software = "//*[@id='product_attribute_5_11']";
    private final String productUnitPrice = "//span[@class='product-unit-price']";
    private final String productTotalPriceActualCartTop = "//span[@class='product-subtotal']";
    private final String miniCartProduct = "//div[@class='name']/a";
    private final String miniCartHover = "//li[@id='topcartlink']/a";
    private final String miniCartItemsLink = "//div[@class='mini-shopping-cart']/div/a";
    private final String pageTitle = "//title";
    private final String nameProductA = "//div[@class='product-name']/h1";
    private final String goToCartBtnFromMiniCart = "//button[@class='button-1 cart-button']";
    private final String productQuantityMiniCart = "//div[@class='quantity']/span";
    private final String productUnitPriceMiniCart = "//div[@class='price']/span";
    private final String productDetailsPagePrice = "//div[@class='product-price']/span";
    private final String productSubTotalPriceMiniCart="//div[@class='totals']/strong";
    private final String notificationBarClose="//div[@id='bar-notification']/div/span";
    private final String recipientNameProductD="//input[@id='giftcard_43_RecipientName']";
    private final String recipientEmailProductD="//input[@id='giftcard_43_RecipientEmail']";
    private final String recipientNameProductF="//input[@id='giftcard_44_RecipientName']";
    private final String size="//select[@id='product_attribute_6']";
    private final String color="//select[@id='product_attribute_7']";
    private final String print="//span[@class='attribute-square']";
    private final String tierPriceFromTable="//td[@class='item-price'][1]";
    private final String priceInputField="//div[@class='price-input']/input";
    private final String startDate="//*[@id='rental_start_date_40']";
    private final String endDate="//*[@id='rental_end_date_40']";
    private final String cartEmpty="//div[@class='no-data']";
    private final String editButtonShoppingCart="//div[@class='edit-item']/a";
    private final String attributesOfProductInShoppingCart="//div[@class='product']/div[2]";
    private final String productImageLinkFromCart="//td[@class='product-picture']/a";
    private final String giftWrapping="//select[@id='checkout_attribute_1']";
    private final String totalValueCartFooter="//span[@class='value-summary']/strong";
    private final String estimateShippingButton="//a[@class='estimate-shipping-button']";
    private final String selectCountryEstimateShipping="//*[@id='CountryId']";
    private final String zipCodeEstimateShipping="//*[@id='ZipPostalCode']";
    private final String estimateShippingMethodText="//div[@class='estimate-shipping-row-item shipping-item'][1]";
    private final String estimateShippingCloseBtn="//button[@class='mfp-close']";
    private final String estimateShippingWarningMsg="//div[@class='message-failure']/div[1]";
    private final String selectEstimateShippingPickup="//*[@id='estimate-shipping-popup']/div[4]/div[2]/div[4]/div[1]/label";
    private final String applyButtonEstimateShipping="//button[@class='button-2 apply-shipping-button']";
    private final String discountField="//*[@id='discountcouponcode']";
    private final String discountApplyButton="//*[@id='applydiscountcouponcode']";
    private final String discountMsgPath="//div[@class='coupon-box']/div[4]";
    private final String removeButtonDiscountPath="//button[@class='remove-discount-button']";
    private final String continueShoppingButtonPath="//button[@class='button-2 continue-shopping-button']";
    private final String discountCouponCodeMsgPath="//span[@class='applied-discount-code']";
    private final String giftCardApplyButton="//*[@id='applygiftcardcouponcode']";
    private final String giftCardMsgPath="//div[@class='giftcard-box']/div[4]";
    private final String giftCardField="//*[@id='giftcardcouponcode']";
    private final String removeButtonGiftCardPath="//button[@class='remove-gift-card-button']";
    private final String checkBoxTermsOfServicePath="//*[@id='termsofservice']";
    private final String checkoutBtnPath="//*[@id='checkout']";
    private final String termsOfServiceWarningMsgPath="//*[@id='terms-of-service-warning-box']/p";
    private final String termsOfServiceReadLinkPath="//*[@id='read-terms']";
    private final String termsOfServiceMsgPath="//*[@id='ph-title']/h1";
    private final String closeBtnTermsOfServiceMsgPath="//div[@class='ui-dialog-titlebar ui-corner-all ui-widget-header ui-helper-clearfix ui-draggable-handle']/button";
    public Shopping_CartPage(Page page) {
        this.page = page;
    }

    public void productsDetailsPage(String product) {
        page.fill(searchBar, product);
        page.click(searchButton);
        page.click(searchedResultProduct);
    }

    public void product_addToCart() {
        page.click(cart_button_product);
    }
    public void clickOnCloseButtonNotification(){
        page.click(notificationBarClose);
    }

    public String warningMsg1ProductB() {
        return page.innerText(productBWarningMsg1);
    }

    public String warningMsg2ProductB() {
        return page.innerText(productBWarningMsg2);
    }

    public void pageLoading() {
        page.waitForLoadState(LoadState.LOAD);
    }

    public void productQty(int a) {
        String st1 = Integer.toString(a);
        page.fill(productQntyInput, st1);
    }

    public String warningMsgOfProduct() {
        return page.innerText(productWarningMsg1);
    }

    public void toCart() {
        page.click(shoppingCartBtnFromNotification);
    }

    public void updateShoppingCart() {
        page.click(updateShoppingCartButton);
    }

    public String CartWarningMsg() {
        return page.innerText(shoppingCartWarningMsg);
    }

    public void productCPage(String productC) {
        page.fill(searchBar, productC);
        page.click(searchButton);
        page.click(searchedResultProduct);
    }

    public String ShoppingCartProductName() {
        return page.innerText(cartProductName);
    }

    public void cleanCart() {
        page.click(shoppingCartBtnFromMiniCart);
        while (page.isVisible(productIsPresent)) {
            page.click(removeBtnShoppingCart);

        }
    }

    public void selectCustomAttributesProductB() {
        page.locator(processor).selectOption("1");
        page.locator(ram).selectOption("4");
        page.click(hdd);
        page.click(os);
        page.click(software);
    }

    public double unitPriceConverter() {
        String a = page.innerText(productUnitPrice);
        String unitPriceString = a.replace("$", "").replace(",", "");
        double unitPriceDouble = Double.parseDouble(unitPriceString);
        return unitPriceDouble;
    }

    public double totalPriceConverterActualCartTop() {
        String b = page.innerText(productTotalPriceActualCartTop);
        String totalPriceString = b.replace("$", "").replace(",", "");
        double totalPriceDouble = Double.parseDouble(totalPriceString);
        return totalPriceDouble;
    }

    public String miniCartProductName() {
       page.hover(miniCartHover);
        return page.innerText(miniCartProduct);
    }

    public void clickOnItemsFromMiniCart() {
        page.hover(miniCartHover);
        page.click(miniCartItemsLink);
    }

    public String pageTitle() {
        return page.innerText(pageTitle);
    }

    public void clickOnMiniCartProductName() {
        page.hover(miniCartHover);
        page.click(miniCartProduct);
    }

    public String productANameFromDetailsPage() {
        return page.innerText(nameProductA);
    }

    public void clickOnGoToCartFromMiniCart() {
        page.click(goToCartBtnFromMiniCart);
    }

    public String productQuantityChecker() {
        return page.innerText(productQuantityMiniCart);

    }

    public double productUnitPriceConvertFromMiniCart() {
        String a = page.innerText(productUnitPriceMiniCart);
        String unitPriceMiniCartString = a.replace("$", "").replace(",", "");
        double unitPriceMiniCartDouble = Double.parseDouble(unitPriceMiniCartString);
        return unitPriceMiniCartDouble;
    }

    public double productPriceFromProductDetailsPage() {
        String a = page.innerText(productDetailsPagePrice);
        String productDetailsPagePriceString = a.replace("$", "").replace(",", "");
        double productDetailsPagePriceDouble = Double.parseDouble(productDetailsPagePriceString);
        return productDetailsPagePriceDouble;
    }

    public double productSubTotalPriceConvertFromMiniCart() {
        String a=page.innerText(productSubTotalPriceMiniCart);
        String subTotalPriceMiniCartString=a.replace("$", "").replace(",", "");
        double subTotalPriceMiniCartDouble=Double.parseDouble(subTotalPriceMiniCartString);
        return subTotalPriceMiniCartDouble;
    }
    public void fillInRequiredFieldOfProductD(String recipientName, String recipientEmail){
        page.fill(recipientNameProductD, recipientName);
        page.fill(recipientEmailProductD, recipientEmail);
    }
    public void fillInRequiredFieldOfProductF(String recipientName){
        page.fill(recipientNameProductF, recipientName);
    }
    public void selectCustomProductAttributesProductG(){
        page.locator(size).selectOption("15");
        page.locator(color).selectOption("18");
        page.click(print);
    }
    public double tierPriceRead(){
        page.goBack();
        String a = page.innerText(tierPriceFromTable);
        String tierPriceString = a.replace("$", "").replace(",", "");
        double tierPriceDouble = Double.parseDouble(tierPriceString);
        page.goForward();
        return tierPriceDouble;
    }
    public void fillingInPriceForDonation(String price){
        page.fill(priceInputField, price);
    }
    public void fillInDate(String start, String end){
        page.fill(startDate, start);
        page.fill(endDate, end);
    }
    public String cartEmptyMsg(){
        return page.innerText(cartEmpty);
    }
    public void clickOnEditButton(){
        page.click(editButtonShoppingCart);
    }
    public void updateRam(){
        page.locator(ram).selectOption("5");
    }
    public String attributesTextOfShoppingCart(){
        return page.innerText(attributesOfProductInShoppingCart);
    }
    public void clickOnImageOfProductFromCart(){
        page.click(productImageLinkFromCart);
    }
    public void clickOnNameOfProductFromCart(){
        page.click(cartProductName);
    }
    public void clickOnBackButtonOfBrowser(){
        page.goBack();

    }
    public void selectGiftWrapping() {
        page.locator(giftWrapping).selectOption("2");
        page.reload();
    }
    public double totalValueCartFooter(){
        page.waitForTimeout(2000);
        String a = page.innerText(totalValueCartFooter);
        String totalValueCartFooterString = a.replace("$", "").replace(",", "");
        double totalValueCartFooterDouble = Double.parseDouble(totalValueCartFooterString);
        return totalValueCartFooterDouble;
    }
    public void clickOnEstimateShipping(){
        page.click(estimateShippingButton);
    }
    public void selectCountryAndZipEstimateShipping(){
        page.locator(selectCountryEstimateShipping).selectOption("237") ;
        page.fill(zipCodeEstimateShipping, "1234");
    }
    public String shippingMethodDisplay(){
        return page.innerText(estimateShippingMethodText);
    }
    public void estimateShippingClose(){
        page.click(estimateShippingCloseBtn);
    }
    public void deselectCountryEstimateShipping(){
        page.locator(selectCountryEstimateShipping).selectOption("237") ;
        page.locator(selectCountryEstimateShipping).selectOption("0");
    }
    public String estimateShippingWarningMsg(){
        return page.innerText(estimateShippingWarningMsg);
    }
    public void clearZipCodeEstimateShipping(){
        page.locator(selectCountryEstimateShipping).selectOption("237") ;
        page.fill(zipCodeEstimateShipping, " ");
    }
    public void selectShippingMethod(){
        page.click(selectEstimateShippingPickup);
        page.click(applyButtonEstimateShipping);

    }
    public void insertDiscountCode(String code){
        page.fill(discountField,code);
    }
    public void clickOnapplyDiscount(){
        page.click(discountApplyButton);
    }
    public String discountMsg(){
        return page.innerText(discountMsgPath);
    }
    public void removeDiscount(){
        page.click(removeButtonDiscountPath);
    }
    public boolean discountCodeRemoved(){
        return page.isHidden(discountMsgPath);
    }

    public void clickOnContinueShopping(){
        page.click(continueShoppingButtonPath);
    }
    public String discountCouponCodeMsg(){
       return page.innerText(discountCouponCodeMsgPath);
    }
    public void applyGiftCard(){
        page.click(giftCardApplyButton);
    }
    public String giftCardMsg(){
        return page.innerText(giftCardMsgPath);
    }
    public void insertGiftCardCode(String code){
        page.fill(giftCardField,code);
    }
    public void removeGiftCard(){
        page.click(removeButtonGiftCardPath);
    }
    public boolean giftCardCodeRemoved(){
        return page.isHidden(giftCardMsgPath);
    }
    public void clickOnCheckBoxTermsOfService(){
        page.click(checkBoxTermsOfServicePath);
    }
    public void clickOnCheckoutBtn(){
        page.click(checkoutBtnPath);
    }
    public String termsOfServiceWarningMsg(){
        return page.innerText(termsOfServiceWarningMsgPath);
    }
    public void clickOnReadLinkOfTerms(){
        page.click(termsOfServiceReadLinkPath);
    }
    public String termsOfServiceConditions(){
       return page.innerText(termsOfServiceMsgPath);
    }
    public void closeTermsOfServiceMsgBox(){
        page.click(closeBtnTermsOfServiceMsgPath);
    }
}