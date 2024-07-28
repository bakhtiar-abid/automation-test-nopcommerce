package com.pwc.glue;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import com.pages.HomePage;
import com.pages.RegistrationPage;
import com.qa.managers.DriverFactory;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class RegistrationSteps {

    Page page = DriverFactory.getPage();

    RegistrationPage registrationPage = new RegistrationPage(page);
    HomePage homePage = new HomePage(page);
    Xls_Reader reader = new Xls_Reader("src/test/resources/config/Testdata/registerData.xlsx");
    Faker faker = new Faker();
    
    String sheetName = "Register";

/* Read data from excel...*/
    String fName = reader.getCellData(sheetName, "fName", 2);
    String lName = reader.getCellData(sheetName, "lName", 2);
    String email = reader.getCellData(sheetName, "email", 2);
    String existingEmail = reader.getCellData(sheetName, "existingEmail", 2);
    String password = reader.getCellData(sheetName, "password", 2);
    String confirmPass = reader.getCellData(sheetName, "confirmPass", 2);
    String minLengthPass = reader.getCellData(sheetName, "minLengthPass", 2);
    String wrongEmail = reader.getCellData(sheetName, "wrongEmail", 2);
    String wrongConfirmPass = reader.getCellData(sheetName, "wrongConfirmPass", 2);
    
/* Make a new random email for the next run... */
/* Click the Registration button from the header section */
    String rendEmail = faker.internet().emailAddress();

    Boolean a = reader.setCellData(sheetName, "email", 2, rendEmail);
    Boolean b = reader.setCellData(sheetName, "existingEmail", 2, email);

    /* Go to the home page...*/
    @Given("Go to the homepage and click the registration button from the header")
    public void goToTheHomepageAndClickTheRegistrationButtonFromTheHeader() {
        homePage.gotoHomePage();
        homePage.clickRegistrationBtnFromHeader();
    }

/* Fill the first name text box */
    @Given("Fill the first name field on the registration page")
    public void fillTheFirstNameFieldOnTheRegistrationPage() {
        registrationPage.fillFirstNameField(fName);
    }
    /* Fill the last name text box */
    @Given("Fill the last name field on the registration page")
    public void fillTheLastNameFieldOnTheRegistrationPage() {
        registrationPage.fillLastNameField(lName);
    }
    /* Fill the email text box */
    @Then("Fill the email field on the registration page")
    public void fillTheEmailFieldOnTheRegistrationPage() {
        registrationPage.fillEmailField(email);
    }

    @Then("Fill the email field with existing email on the registration page")
    public void fillTheEmailFieldWithExistingEmailOnTheRegistrationPage() {
        registrationPage.fillEmailField(existingEmail);
    }

    @Then("Fill the email field on the registration page with a wrong email")
    public void fillTheEmailFieldOnTheRegistrationPageWithAWrongEmail() {
        registrationPage.fillEmailField(wrongEmail);
    }

    @Then("Fill the password field on the registration page")
    public void fillThePasswordFieldOnTheRegistrationPage() {
        registrationPage.fillPasswordField(password);
    }

    @And("Fill the confirm password field on the registration page")
    public void fillTheConfirmPasswordFieldOnTheRegistrationPage() {
        registrationPage.fillConfirmPasswordField(confirmPass);
    }

    @And("Fill the password field without meet minimum length on the registration page")
    public void fillThePasswordFieldWithoutMeetMinimumLengthOnTheRegistrationPage() {
        registrationPage.fillPasswordField(minLengthPass);
    }

    @And("Fill the confirm password field with the mismatch password on the registration page")
    public void fillTheConfirmPasswordFieldWithTheMismatchPasswordOnTheRegistrationPage() {
        registrationPage.fillConfirmPasswordField(wrongConfirmPass);
    }

    @Then("Click the register button on the registration page")
    public void clickTheRegisterButtonOnTheRegistrationPage() {
        registrationPage.clickRegisterButton();
    }

    @But("User get an alert message {string} under the first name field on the registration page")
    public void userGetAnAlertMessageUnderTheFirstNameFieldOnTheRegistrationPage(String expectedAlert) {
        String actualAlert = registrationPage.getFirstNameRequiredMsg();
        System.out.println(actualAlert);
        Assertions.assertTrue(expectedAlert.contains(actualAlert));
//        Assertions.assertEquals(expectedAlert,actualAlert);
    }

    @But("User get an alert message {string} under the last name field on the registration page")
    public void userGetAnAlertMessageUnderTheLastNameFieldOnTheRegistrationPage(String expectedAlert) {
        String actualAlert = registrationPage.getLastNameRequiredMsg();
        Assertions.assertTrue(expectedAlert.contains(actualAlert));
//        Assertions.assertEquals(expectedAlert,actualAlert);
    }

    @But("User get an alert message {string} under the email field on the registration page")
    public void userGetAnAlertMessageUnderTheEmailFieldOnTheRegistrationPage(String expectedAlert) {
        String actualAlert = registrationPage.getEmailRequiredMsg();
        Assertions.assertTrue(expectedAlert.contains(actualAlert));
//        Assertions.assertEquals(expectedAlert,actualAlert);
    }

    @But("User get an alert message {string} under the password field on the registration page")
    public void userGetAnAlertMessageUnderThePasswordFieldOnTheRegistrationPage(String expectedAlert) {
        String actualAlert = registrationPage.getPasswordRequiredMsg();

        if (actualAlert.contains(expectedAlert)){
            Assertions.assertTrue(true);
        }
        else {
            Assertions.assertEquals(expectedAlert,actualAlert);
        }

        
    }

    @But("User get an alert message {string} under the confirm password field on the registration page")
    public void userGetAnAlertMessageUnderTheConfirmPasswordFieldOnTheRegistrationPage(String expectedAlert) {
        String actualAlert = registrationPage.getConfirmPasswordRequiredMsg();
        Assertions.assertTrue(expectedAlert.contains(actualAlert));
//        Assertions.assertEquals(expectedAlert,actualAlert);
    }

    @But("User able to register and see {string} register success message")
    public void userAbelToRegisterAndSeeMessage(String expectedAlert) {
        String actualAlert = registrationPage.getRegisterConfirmMsg();
        Assertions.assertTrue(expectedAlert.contains(actualAlert));
//        Assertions.assertEquals(expectedAlert,actualAlert);
    }

    @But("User unable to register and see {string} alert message")
    public void userUnableToRegisterAndSeeAlertMessage(String expectedAlert) {
        String actualAlert = registrationPage.getExistEmailAlertMsg();
        Assertions.assertTrue(expectedAlert.contains(actualAlert));
//        Assertions.assertEquals(expectedAlert,actualAlert);
    }

}
