package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.RewardPointsPage;
import com.qa.managers.FileReaderManager;
import io.cucumber.java.en.Given;
import com.pages.LoginPage;
import com.qa.managers.DriverFactory;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;


public class RewardPointsSteps {

    Page page = DriverFactory.getPage();

    //getting base url from config file
    final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    LoginPage loginPage= new LoginPage(page);
    RewardPointsPage rewardPointsPage = new RewardPointsPage(page);
    Xls_Reader reader = new Xls_Reader("src/test/resources/config/Testdata/Testdata.xlsx");
    String sheetName = "Login";

    @Given("User perform login and go to my account reward points page")
    public void userPerformLoginAndGoToMyAccountRewardPointsPage() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 7));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 7));
        loginPage.clickOnLoginButton();
        rewardPointsPage.goToMyAccountRewardPointsPage();
        rewardPointsPage.pageLoading();
    }

    @Then("User should see the reward points")
    public void userShouldSeeTheRewardPoints() {
        rewardPointsPage.pageLoading();
        Assertions.assertTrue(rewardPointsPage.isRewardPointsPageTitleDisplayed());
    }
}
