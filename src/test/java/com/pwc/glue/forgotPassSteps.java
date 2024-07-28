package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.LoginPage;
import com.pages.PasswordRecoveryPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class forgotPassSteps {

    Page page = DriverFactory.getPage();

    //getting base url from config file
    final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    LoginPage loginPage= new LoginPage(page);
    PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(page);

    Xls_Reader reader = new Xls_Reader("src/test/resources/config/Testdata/forgotPasswordData.xlsx");
    String sheetName = "forgotPass";
    @Given("User got to login page and click forgot password link")
    public void userGotToLoginPageAndClickForgotPasswordLink() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        passwordRecoveryPage.clickForgotPasswordLink();
    }

    @Given("User enter invalid email in Your email address field")
    public void userEnterInvalidEmailInYourEmailAddressField() {
        passwordRecoveryPage.enterEmail(reader.getCellData(sheetName, "Invalid", 2));
    }

    @When("User click on Retrieve password button")
    public void userClickOnRetrievePasswordButton() {
        passwordRecoveryPage.clickOnSendPasswordRecoveryEmailButton();
    }

    @Then("User should see notification {string}")
    public void userShouldSeeNotification(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, passwordRecoveryPage.notificationMessage());
    }

    @Given("User enter wrong email in Your email address field")
    public void userEnterWrongEmailInYourEmailAddressField() {
        passwordRecoveryPage.enterEmail(reader.getCellData(sheetName, "Wrong", 2));
    }

    @Then("User should see error message {string} in email field")
    public void userShouldSeeErrorMessageInEmailField(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, passwordRecoveryPage.emailError());
    }

    @Given("User enter valid email in Your email address field")
    public void userEnterValidEmailInYourEmailAddressField() {
        passwordRecoveryPage.enterEmail(reader.getCellData(sheetName, "Email", 2));
    }
}
