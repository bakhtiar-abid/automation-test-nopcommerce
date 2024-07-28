package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.LoginPage;
import com.pages.MyReviewsPage;
import com.qa.managers.DriverFactory;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.Given;
import com.qa.managers.FileReaderManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class MyReviewsSteps {
    Page page = DriverFactory.getPage();

    //getting base url from config file
    final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();
    LoginPage loginPage = new LoginPage(page);
    MyReviewsPage myReviewsPage = new MyReviewsPage(page);
    Xls_Reader reader = new Xls_Reader("src/test/resources/config/Testdata/Testdata.xlsx");
    String sheetName = "Login";
    @Given("User perform login and go to my account my product reviews page")
    public void userPerformLoginAndGoToMyAccountMyProductReviewsPage() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 7));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 7));
        loginPage.clickOnLoginButton();
        myReviewsPage.goToMyReviewsPage();
    }

    @Then("User view existing product reviews on my product review page")
    public void userViewExistingProductReviewsOnMyProductReviewPage() {
        Assertions.assertTrue(myReviewsPage.isProductReviewsDisplayed());
    }
}
