package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.LoginPage;
import com.pages.MyOrdersPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class MyOrdersSteps {

    //getting base url from config file
    private final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    Page page = DriverFactory.getPage();

    MyOrdersPage myOrdersPage = new MyOrdersPage(page);
    LoginPage loginPage = new LoginPage(page);

    Xls_Reader reader = new Xls_Reader("src/test/resources/config/testdata/Testdata.xlsx");
    String sheetName = "Login";

    @Given("User perform login and go to my account orders page")
    public void userPerformLoginAndGoToMyAccountOrdersPage() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 7));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 7));
        loginPage.clickOnLoginButton();
        myOrdersPage.goToMyOrdersPage();
    }

    @When("User click on the first order's details")
    public void userClickOnTheFirstOrderSDetails() {
        myOrdersPage.clickOnFirstOrderDetailsLink();
        myOrdersPage.pageLoading();
    }

    @Then("User should be able to see the order details page")
    public void userShouldBeAbleToSeeTheOrderDetailsPage() {
        Assertions.assertTrue(myOrdersPage.isOrderDetailsPageDisplayed());
    }

    @When("User click on the first order's return item")
    public void userClickOnTheFirstOrderSReturnItem() {
        myOrdersPage.clickOnFirstOrderReturnItemLink();
        myOrdersPage.pageLoading();
    }

    @Then("User should be able to see the return item page")
    public void userShouldBeAbleToSeeTheReturnItemPage() {
        Assertions.assertTrue(myOrdersPage.isReturnItemPageDisplayed());
    }

    @Given("User perform login and go to my account orders page for return request")
    public void userPerformLoginAndGoToMyAccountOrdersPageForReturnRequest() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 10));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 10));
        loginPage.clickOnLoginButton();
        myOrdersPage.goToMyOrdersPage();
    }

}
