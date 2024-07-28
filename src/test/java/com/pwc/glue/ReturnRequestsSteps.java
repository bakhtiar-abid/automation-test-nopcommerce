package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.LoginPage;
import com.pages.MyReturnRequestsPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class ReturnRequestsSteps {

    Page page = DriverFactory.getPage();

    //getting base url from config file
    final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    MyReturnRequestsPage myReturnRequestsPage = new MyReturnRequestsPage(DriverFactory.getPage());
    LoginPage loginPage = new LoginPage(DriverFactory.getPage());
    Xls_Reader reader = new Xls_Reader("src/test/resources/config/Testdata/Testdata.xlsx");
    String sheetName = "Login";

    @Given("User perform login and go to my account return requests page")
    public void userPerformLoginAndGoToMyAccountReturnRequestsPage() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 7));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 7));
        loginPage.clickOnLoginButton();
        myReturnRequestsPage.goToMyAccountReturnRequestsPage();
        myReturnRequestsPage.pageLoading();
    }

    @Then("User should see the list of the return requested orders")
    public void userShouldSeeTheListOfTheReturnRequestedOrders() {
        myReturnRequestsPage.pageLoading();
        Assertions.assertTrue(myReturnRequestsPage.isReturnRequestsItemDisplayed());
    }
}
