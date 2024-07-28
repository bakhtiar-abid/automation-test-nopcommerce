package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.DownloadablePage;
import com.pages.LoginPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DownloadSteps {

    Page page = DriverFactory.getPage();

    //getting base url from config file
    final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    DownloadablePage downloadablePage = new DownloadablePage(page);
    LoginPage loginPage = new LoginPage(page);

    Xls_Reader reader = new Xls_Reader("src/test/resources/config/testdata/Testdata.xlsx");
    String sheetName = "Login";

    @Given("User perform login and go to my account download page")
    public void userPerformLoginAndGoToMyAccountDownloadPage() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 7));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 7));
        loginPage.clickOnLoginButton();
        downloadablePage.goToDownloadableProductPage();

    }

    @When("User click on the order number of a downloadable product")
    public void userClickOnTheOrderNumberOfADownloadableProduct() {
        downloadablePage.clickOnFirstProductOrderDetailsLink();
        downloadablePage.pageLoading();
    }

    @Then("User should be able to view the details of the order")
    public void userShouldBeAbleToViewTheDetailsOfTheOrder() {
        Assertions.assertTrue(downloadablePage.isOrderDetailsPageDisplayed());
    }

    @When("User click on the download link of the downloadable product")
    public void userClickOnTheDownloadLinkOfTheDownloadableProduct() {
        downloadablePage.downloadProduct();
    }

    @Then("User should be able to download the file of the downloadable product")
    public void userShouldBeAbleToDownloadTheFileOfTheDownloadableProduct() {
        Assertions.assertTrue(downloadablePage.isDownloaded());
    }
}
