package com.pwc.glue;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.pages.HomePage;
import com.pages.MyOrdersPage;
import com.pages.OrderDetailsPage;
import com.qa.managers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;

public class OrderDetailsSteps {
    Page page = DriverFactory.getPage();
    BrowserContext contex = DriverFactory.getBrowserContext();
    OrderDetailsPage orderDetailsPage = new OrderDetailsPage(page);
    MyOrdersPage myOrdersPage = new MyOrdersPage(page);
    HomePage homePage = new HomePage(page);

    @Given("Go to the homepage and click the login button")
    public void goToTheHomepageAndClickTheLoginButton() {
        homePage.gotoHomePage();
        homePage.clickLoginBtn();
    }
    @Given("Click on the PDF invoice button to download the order details and Verify the order details is on downloaded")
    public void clickOnThePDFInvoiceButtonToDownloadTheOrderDetailsAndVerifyTheOrderDetailsIsOnDownloaded() {
        orderDetailsPage.clickPDFInvoice();
        Assertions.assertTrue(orderDetailsPage.isDownload());
    }

    @Given("Go to the order details page from the my account on the header section and verify the order details by order number")
    public void goToTheOrderDetailsPageFromTheMyAccountOnTheHeaderSectionAndVerifyTheOrderDetailsByOrderNumber() {
        homePage.clickMyAccountBtnFromHeader();
        homePage.clickOrdersInMyAccountPage();
        String listOrderNumber = orderDetailsPage.getOrderNumberListPage();
        myOrdersPage.clickOnFirstOrderDetailsLink();
        String orderNumber = orderDetailsPage.getOrderNumberFromOrderDetailsPage();
        Assertions.assertTrue(listOrderNumber.contains(orderNumber));
    }

    @Given("Go to the order details page from the footer section and verify the order details by order number")
    public void goToTheOrderDetailsPageFromTheFooterSectionAndVerifyTheOrderDetailsByOrderNumber() {
        homePage.clickOrderFromFooter();
        String listOrderNumber = orderDetailsPage.getOrderNumberListPage();
        myOrdersPage.clickOnFirstOrderDetailsLink();
        String orderNumber = orderDetailsPage.getOrderNumberFromOrderDetailsPage();
        Assertions.assertTrue(listOrderNumber.contains(orderNumber));
    }

    @Given("Click on the print button to print the order details and Verify the order details is on printing")
    public void clickOnThePrintButtonToPrintTheOrderDetailsAndVerifyTheOrderDetailsIsOnPrinting() {
        orderDetailsPage.clickPrintBtn();
        Page newPage = contex.waitForPage(()->{
            orderDetailsPage.clickPrintBtn();
        });
        String url = newPage.url();
        Assertions.assertTrue(url.contains("print"));
    }

    @Given("Click on the re-order button to re-order the product from the product details page")
    public void clickOnTheReOrderButtonToReOrderTheProductFromTheProductDetailsPage() {
        orderDetailsPage.clickReOrderBtn();
    }

    @And("Verify that the user will navigate to the cart page")
    public void verifyThatTheUserWillNavigateToTheCartPage() {
        Assertions.assertTrue(orderDetailsPage.getPageTitle().contains("Cart"));
    }

    @Given("Click the return item and verify the navigated page title contains {string}")
    public void clickTheReturnItemAndVerifyTheNavigatedPageTitleContains(String expectedTitle) {
        orderDetailsPage.clickReturnItemBtn();
        String actualTile = orderDetailsPage.getPageTitle();
        Assertions.assertTrue(actualTile.contains(expectedTitle));
    }
}
