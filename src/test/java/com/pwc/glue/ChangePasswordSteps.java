package com.pwc.glue;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import com.pages.ChangePasswordPage;
import com.pages.LoginPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ChangePasswordSteps {

    Page page = DriverFactory.getPage();

    //getting base url from config file
    final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    ChangePasswordPage changePasswordPage = new ChangePasswordPage(page);
    LoginPage loginPage = new LoginPage(page);

    Xls_Reader reader = new Xls_Reader("src/test/resources/config/Testdata/Testdata.xlsx");
    Xls_Reader reader1 = new Xls_Reader("src/test/resources/config/Testdata/forgotPasswordData.xlsx");
    String sheetName1 = "Login";
    String sheetName2 = "ChangePass";

    Faker faker = new Faker();

    @Given("User perform login and go to my account change password page")
    public void userPerformLoginAndGoToMyAccountChangePasswordPage() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader.getCellData(sheetName1, "Email", 9));
        loginPage.enterPassword(reader.getCellData(sheetName1, "Password", 9));
        loginPage.clickOnLoginButton();
        changePasswordPage.goToChangePasswordPage();
    }

    @When("User enter valid info without filling old password field")
    public void userEnterValidInfoWithoutFillingOldPasswordField() {
        changePasswordPage.enterOldPassword(reader1.getCellData(sheetName2, "Empty", 2));
        changePasswordPage.enterNewPassword(reader1.getCellData(sheetName2, "New", 2));
        changePasswordPage.enterConfirmPassword(reader1.getCellData(sheetName2, "Confirm", 2));
    }

    @When("User enter valid info without filling new password field")
    public void userEnterValidInfoWithoutFillingNewPasswordField() {
        changePasswordPage.enterOldPassword(reader1.getCellData(sheetName2, "Old", 2));
        changePasswordPage.enterNewPassword(reader1.getCellData(sheetName2, "Empty", 2));
    }

    @When("User enter valid info without filling confirm password field")
    public void userEnterValidInfoWithoutFillingConfirmPasswordField() {
        changePasswordPage.enterOldPassword(reader1.getCellData(sheetName2, "Old", 2));
        changePasswordPage.enterNewPassword(reader1.getCellData(sheetName2, "New", 2));
        changePasswordPage.enterConfirmPassword(reader1.getCellData(sheetName2, "Empty", 2));
    }

    @When("User enter valid info and wrong password in old password field")
    public void userEnterValidInfoAndWrongPasswordInOldPasswordField() {
        changePasswordPage.enterOldPassword(reader1.getCellData(sheetName2, "Wrong", 2));
        changePasswordPage.enterNewPassword(reader1.getCellData(sheetName2, "New", 2));
        changePasswordPage.enterConfirmPassword(reader1.getCellData(sheetName2, "Confirm", 2));
    }

    @When("User enter valid info and invalid length password for new password field")
    public void userEnterValidInfoAndInvalidLengthPasswordForNewPasswordField() {
        changePasswordPage.enterOldPassword(reader1.getCellData(sheetName2, "Old", 2));
        changePasswordPage.enterNewPassword(reader1.getCellData(sheetName2, "Wrong", 2));
        changePasswordPage.enterConfirmPassword(reader1.getCellData(sheetName2, "Confirm", 2));
    }

    @When("User enter valid info and mismatching password in new password and confirm password field")
    public void userEnterValidInfoAndMismatchingPasswordInNewPasswordAndConfirmPasswordField() {
        changePasswordPage.enterOldPassword(reader1.getCellData(sheetName2, "Old", 2));
        changePasswordPage.enterNewPassword(reader1.getCellData(sheetName2, "New", 2));
        changePasswordPage.enterConfirmPassword(reader1.getCellData(sheetName2, "Mismatch", 2));
    }

    @When("User enter valid info in all fields")
    public void userEnterValidInfoInAllFields() {
        changePasswordPage.enterOldPassword(reader1.getCellData(sheetName2, "Old", 2));
        changePasswordPage.enterNewPassword(reader1.getCellData(sheetName2, "New", 2));
        changePasswordPage.enterConfirmPassword(reader1.getCellData(sheetName2, "Confirm", 2));
    }

    @And("User click on change password button")
    public void userClickOnChangePasswordButton() {
        changePasswordPage.clickOnChangePasswordButton();
        changePasswordPage.pageLoading();
    }


    @Then("User should see error message {string} in old password field")
    public void userShouldSeeErrorMessageInOldPasswordField(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, changePasswordPage.oldPasswordErrorMessage());
    }

    @Then("User should see error message {string} in new password field")
    public void userShouldSeeErrorMessageInNewPasswordField(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, changePasswordPage.newPasswordErrorMessage());
    }

    @Then("User should see error message {string} in confirm password field")
    public void userShouldSeeErrorMessageInConfirmPasswordField(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, changePasswordPage.confirmPasswordErrorMessage());
    }

    @Then("User should see error message {string}")
    public void userShouldSeeErrorMessage(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, changePasswordPage.wrongOldPasswordErrorMessage());
    }

    @Then("User should see error message {string} in new password field for invalid length")
    public void userShouldSeeErrorMessageInNewPasswordFieldForInvalidLength(String expectedErrorMessage) {
        Assertions.assertTrue(changePasswordPage.newPasswordErrorMessage().contains(expectedErrorMessage));
    }

    @Then("User should see success message {string}")
    public void userShouldSeeSuccessMessage(String expectedSuccessMessage) {
        Assertions.assertEquals(expectedSuccessMessage, changePasswordPage.changePasswordSuccessMessage());
        reader.setCellData(sheetName1, "Password", 9, reader1.getCellData(sheetName2, "New", 2));
        reader1.setCellData(sheetName2, "Old", 2, reader1.getCellData(sheetName2, "New", 2));
        reader1.setCellData(sheetName2, "New", 2, faker.internet().password());
        reader1.setCellData(sheetName2, "Confirm", 2, reader1.getCellData(sheetName2, "New", 2));
    }
}
