package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.LoginPage;
import com.qa.managers.DriverFactory;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import com.qa.managers.FileReaderManager;

public class LoginSteps {
    Page page = DriverFactory.getPage();
    //getting base url from config file
    final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();
    LoginPage loginPage= new LoginPage(page);
    Xls_Reader reader = new Xls_Reader("src/test/resources/config/Testdata/Testdata.xlsx");
    String sheetName = "Login";

    @Given("User is in login page")
    public void userIsInLoginPage() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
    }

    @When("User enter valid Email and invalid password from test data")
    public void userEnterValidEmailAndInvalidPasswordFromTestData() {
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 7));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 3));
    }

    @And("User click on Login button")
    public void userClickOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("User should unable to login and get an alert message for incorrect credentials")
    public void userShouldUnableToLoginAndGetAnAlertMessageForIncorrectCredentials() {
        Assertions.assertTrue(loginPage.isLoginFailedAlertDisplayed());
    }

    @When("User enter invalid Email and invalid password from test data to the Email and Password field")
    public void userEnterInvalidEmailAndInvalidPasswordFromTestDataToTheEmailAndPasswordField() {
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 3));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 3));
    }

    @When("Blank Email field and valid password from test data to the Password field")
    public void blankEmailFieldAndValidPasswordFromTestDataToThePasswordField() {
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 4));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 7));
    }

    @When("User enter valid Email and blank Password field from test data")
    public void userEnterValidEmailAndBlankPasswordFieldFromTestData() {
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 7));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 5));
    }

    @When("User enter wrong Email and valid password from test data to the Email and Password field")
    public void userEnterWrongEmailAndValidPasswordFromTestDataToTheEmailAndPasswordField() {
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 6));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 7));
    }

    @When("User enter valid Email and valid password from test data to the Email and Password field")
    public void userEnterValidEmailAndValidPasswordFromTestDataToTheEmailAndPasswordField() {
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 7));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 7));
    }
    @Then("User should be logged in")
    public void userShouldBeLoggedIn() {
        Assertions.assertTrue(loginPage.isLogoutLinkDisplayed());
    }
    @Then("User should unable to login and get a warning message")
    public void userShouldUnableToLoginAndGetAWarningMessage() {
        Assertions.assertTrue(loginPage.getWarningMessageText());
    }

    @Given("User perform login")
    public void userPerformLogin() {
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader.getCellData(sheetName, "Email", 7));
        loginPage.enterPassword(reader.getCellData(sheetName, "Password", 7));
        loginPage.clickOnLoginButton();

    }

}