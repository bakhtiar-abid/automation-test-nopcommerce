package com.pwc.glue;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import com.pages.CustomerInfoPage;
import com.pages.LoginPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CustomerInfoSteps {

    Page page = DriverFactory.getPage();

    //getting base url from config file
    final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();
    CustomerInfoPage customerInfoPage = new CustomerInfoPage(page);
    LoginPage loginPage = new LoginPage(page);
    Xls_Reader reader = new Xls_Reader("src/test/resources/config/Testdata/Testdata.xlsx");
    Xls_Reader reader1 = new Xls_Reader("src/test/resources/config/Testdata/customerInfoData.xlsx");
    String sheetName = "CustomerInfo";
    String sheetName2 = "Login";

    Faker faker = new Faker();
    @And("User is in customer info page")
    public void userIsInCustomerInfoPage() {
        loginPage.goToHomePage(baseUrl);
        customerInfoPage.goToMyAccountCustomerInfoPage();
    }

    @When("User clears First name field in customer info page")
    public void userClearsFirstNameFieldInCustomerInfoPage() {
        customerInfoPage.clearFirstNameTextBox();
    }

    @And("User clicks on Save button in customer info page")
    public void userClicksOnSaveButtonInCustomerInfoPage() {
        customerInfoPage.clickOnSaveButton();
        customerInfoPage.pageLoading();
    }

    @Then("User should see error message {string} in First name field of customer info page")
    public void userShouldSeeErrorMessageInFirstNameFieldOfCustomerInfoPage(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, customerInfoPage.firstNameFieldErrorMessage());
    }

    @When("User clears Last Name field in customer info page")
    public void userClearsLastNameFieldInCustomerInfoPage() {
        customerInfoPage.clearLastNameTextBox();
    }

    @Then("User should see error message {string} in Last name field of customer info page")
    public void userShouldSeeErrorMessageInLastNameFieldOfCustomerInfoPage(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, customerInfoPage.lastNameFieldErrorMessage());
    }

    @When("User clears Email field in customer info page")
    public void userClearsEmailFieldInCustomerInfoPage() {
        customerInfoPage.clearEmailTextBox();
    }

    @Then("User should see error message {string} in Email field of customer info page")
    public void userShouldSeeErrorMessageInEmailFieldOfCustomerInfoPage(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, customerInfoPage.emailFieldErrorMessage());
    }

    @When("User enters wrong email in Email field in customer info page")
    public void userEntersWrongEmailInEmailFieldInCustomerInfoPage() {
        customerInfoPage.enterEmail(reader1.getCellData(sheetName, "Wrong", 2));
    }

    @When("User enters valid first name in the First Name field of customer info page")
    public void userEntersValidFirstNameInTheFirstNameFieldOfCustomerInfoPage() {
        customerInfoPage.enterFirstName(reader1.getCellData(sheetName, "FirstName", 2));
    }

    @And("User enters valid last name in the Last Name field of customer info page")
    public void userEntersValidLastNameInTheLastNameFieldOfCustomerInfoPage() {
        customerInfoPage.enterLastName(reader1.getCellData(sheetName, "LastName", 2));
    }

    @And("User enters valid email in the Email field of customer info page")
    public void userEntersValidEmailInTheEmailFieldOfCustomerInfoPage() {
        customerInfoPage.enterEmail(reader1.getCellData(sheetName, "Email", 2));
    }

    @Then("User should see edited information in customer info page")
    public void userShouldSeeEditedInformationInCustomerInfoPage() {
        String actualFirstName = customerInfoPage.getFirstName();
        String actualLastName = customerInfoPage.getLastName();
        String actualEmail = customerInfoPage.getEmail();
        Assertions.assertEquals(reader1.getCellData(sheetName, "FirstName", 2), actualFirstName);
        Assertions.assertEquals(reader1.getCellData(sheetName, "LastName", 2), actualLastName);
        Assertions.assertEquals(reader1.getCellData(sheetName, "Email", 2), actualEmail);
        reader.setCellData(sheetName2, "Email", 8, reader1.getCellData(sheetName, "Email", 2));
        reader1.setCellData(sheetName, "FirstName", 2, faker.name().firstName());
        reader1.setCellData(sheetName, "LastName", 2, faker.name().lastName());
        reader1.setCellData(sheetName, "Email", 2, faker.internet().emailAddress());

    }

    @When("User enters all valid info in customer info page")
    public void userEntersAllValidInfoInCustomerInfoPage() {
        customerInfoPage.enterFirstName(reader1.getCellData(sheetName, "FirstName", 2));
        customerInfoPage.enterLastName(reader1.getCellData(sheetName, "LastName", 2));
        customerInfoPage.enterEmail(reader1.getCellData(sheetName, "Email", 2));
    }

    @Given("User is logged in from a non admin account for customer info edit")
    public void userIsLoggedInFromANonAdminAccountForCustomerInfoEdit() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader.getCellData(sheetName2, "Email", 8));
        loginPage.enterPassword(reader.getCellData(sheetName2, "Password", 8));
        loginPage.clickOnLoginButton();
    }
}
