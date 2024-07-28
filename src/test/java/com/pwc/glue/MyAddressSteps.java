package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.LoginPage;
import com.pages.MyAddressesPage;
import com.qa.managers.DriverFactory;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import com.qa.managers.FileReaderManager;

public class MyAddressSteps {

    //getting base url from config file
    private final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    Page page = DriverFactory.getPage();

    MyAddressesPage myAddressesPage = new MyAddressesPage(page);
    LoginPage loginPage = new LoginPage(page);

    Xls_Reader reader = new Xls_Reader("src/test/resources/config/Testdata/addressData.xlsx");

    String sheetName = "Addresses";
    String beforeAddressTitle, afterAddressTitle;

    @When("User click on Add new address button for adding new address")
    public void userClickOnAddNewAddressButtonForAddingNewAddress() {
        myAddressesPage.clickOnAddNewAddressButton();
        myAddressesPage.pageLoading();
    }

    @And("User fill up the address form with valid value without the first name field")
    public void userFillUpTheAddressFormWithValidValueWithoutTheFirstNameField() {
        myAddressesPage.enterLastName(reader.getCellData(sheetName, "LastName", 2));
        myAddressesPage.enterEmail(reader.getCellData(sheetName, "Email", 2));
        myAddressesPage.selectCountry(reader.getCellData(sheetName, "Country", 2));
        myAddressesPage.selectStateProvince(reader.getCellData(sheetName, "State", 2));
        myAddressesPage.enterCity(reader.getCellData(sheetName, "City", 2));
        myAddressesPage.enterAddress1(reader.getCellData(sheetName, "Address", 2));
        myAddressesPage.enterZipPostalCode(reader.getCellData(sheetName, "Zip", 2));
        myAddressesPage.enterPhoneNumber(reader.getCellData(sheetName, "Phone", 2));
    }

    @And("User fill up the address form with valid value without the last name field")
    public void userFillUpTheAddressFormWithValidValueWithoutTheLastNameField() {
        myAddressesPage.enterFirstName(reader.getCellData(sheetName, "FirstName", 2));
        myAddressesPage.enterEmail(reader.getCellData(sheetName, "Email", 2));
        myAddressesPage.selectCountry(reader.getCellData(sheetName, "Country", 2));
        myAddressesPage.selectStateProvince(reader.getCellData(sheetName, "State", 2));
        myAddressesPage.enterCity(reader.getCellData(sheetName, "City", 2));
        myAddressesPage.enterAddress1(reader.getCellData(sheetName, "Address", 2));
        myAddressesPage.enterZipPostalCode(reader.getCellData(sheetName, "Zip", 2));
        myAddressesPage.enterPhoneNumber(reader.getCellData(sheetName, "Phone", 2));
    }

    @And("User fill up the address form with valid value without the email field")
    public void userFillUpTheAddressFormWithValidValueWithoutTheEmailField() {
        myAddressesPage.enterFirstName(reader.getCellData(sheetName, "FirstName", 2));
        myAddressesPage.enterLastName(reader.getCellData(sheetName, "LastName", 2));
        myAddressesPage.selectCountry(reader.getCellData(sheetName, "Country", 2));
        myAddressesPage.selectStateProvince(reader.getCellData(sheetName, "State", 2));
        myAddressesPage.enterCity(reader.getCellData(sheetName, "City", 2));
        myAddressesPage.enterAddress1(reader.getCellData(sheetName, "Address", 2));
        myAddressesPage.enterZipPostalCode(reader.getCellData(sheetName, "Zip", 2));
        myAddressesPage.enterPhoneNumber(reader.getCellData(sheetName, "Phone", 2));
    }

    @And("User fill up the address form with wrong email in email field")
    public void userFillUpTheAddressFormWithWrongEmailInEmailField() {
        myAddressesPage.enterFirstName(reader.getCellData(sheetName, "FirstName", 2));
        myAddressesPage.enterLastName(reader.getCellData(sheetName, "LastName", 2));
        myAddressesPage.enterEmail(reader.getCellData(sheetName, "Wrong", 2));
        myAddressesPage.selectCountry(reader.getCellData(sheetName, "Country", 2));
        myAddressesPage.selectStateProvince(reader.getCellData(sheetName, "State", 2));
        myAddressesPage.enterCity(reader.getCellData(sheetName, "City", 2));
        myAddressesPage.enterAddress1(reader.getCellData(sheetName, "Address", 2));
        myAddressesPage.enterZipPostalCode(reader.getCellData(sheetName, "Zip", 2));
        myAddressesPage.enterPhoneNumber(reader.getCellData(sheetName, "Phone", 2));
    }

    @And("User fill up the address form without selecting country field")
    public void userFillUpTheAddressFormWithoutSelectingCountryField() {
        myAddressesPage.enterFirstName(reader.getCellData(sheetName, "FirstName", 2));
        myAddressesPage.enterLastName(reader.getCellData(sheetName, "LastName", 2));
        myAddressesPage.enterEmail(reader.getCellData(sheetName, "Email", 2));
        myAddressesPage.enterCity(reader.getCellData(sheetName, "City", 2));
        myAddressesPage.enterAddress1(reader.getCellData(sheetName, "Address", 2));
        myAddressesPage.enterZipPostalCode(reader.getCellData(sheetName, "Zip", 2));
        myAddressesPage.enterPhoneNumber(reader.getCellData(sheetName, "Phone", 2));
    }

    @And("User fill up the address form without selecting state field")
    public void userFillUpTheAddressFormWithoutSelectingStateField() {
        myAddressesPage.enterFirstName(reader.getCellData(sheetName, "FirstName", 2));
        myAddressesPage.enterLastName(reader.getCellData(sheetName, "LastName", 2));
        myAddressesPage.enterEmail(reader.getCellData(sheetName, "Email", 2));
        myAddressesPage.selectCountry(reader.getCellData(sheetName, "Country", 2));
        myAddressesPage.enterCity(reader.getCellData(sheetName, "City", 2));
        myAddressesPage.enterAddress1(reader.getCellData(sheetName, "Address", 2));
        myAddressesPage.enterZipPostalCode(reader.getCellData(sheetName, "Zip", 2));
        myAddressesPage.enterPhoneNumber(reader.getCellData(sheetName, "Phone", 2));
    }

    @And("User fill up the address form with valid value without the city field")
    public void userFillUpTheAddressFormWithValidValueWithoutTheCityField() {
        myAddressesPage.enterFirstName(reader.getCellData(sheetName, "FirstName", 2));
        myAddressesPage.enterLastName(reader.getCellData(sheetName, "LastName", 2));
        myAddressesPage.enterEmail(reader.getCellData(sheetName, "Email", 2));
        myAddressesPage.selectCountry(reader.getCellData(sheetName, "Country", 2));
        myAddressesPage.selectStateProvince(reader.getCellData(sheetName, "State", 2));
        myAddressesPage.enterAddress1(reader.getCellData(sheetName, "Address", 2));
        myAddressesPage.enterZipPostalCode(reader.getCellData(sheetName, "Zip", 2));
        myAddressesPage.enterPhoneNumber(reader.getCellData(sheetName, "Phone", 2));
    }

    @And("User fill up the address form with valid value without the address field")
    public void userFillUpTheAddressFormWithValidValueWithoutTheAddressField() {
        myAddressesPage.enterFirstName(reader.getCellData(sheetName, "FirstName", 2));
        myAddressesPage.enterLastName(reader.getCellData(sheetName, "LastName", 2));
        myAddressesPage.enterEmail(reader.getCellData(sheetName, "Email", 2));
        myAddressesPage.selectCountry(reader.getCellData(sheetName, "Country", 2));
        myAddressesPage.selectStateProvince(reader.getCellData(sheetName, "State", 2));
        myAddressesPage.enterCity(reader.getCellData(sheetName, "City", 2));
        myAddressesPage.enterZipPostalCode(reader.getCellData(sheetName, "Zip", 2));
        myAddressesPage.enterPhoneNumber(reader.getCellData(sheetName, "Phone", 2));
    }

    @And("User fill up the address form with valid value without the zip code field")
    public void userFillUpTheAddressFormWithValidValueWithoutTheZipCodeField() {
        myAddressesPage.enterFirstName(reader.getCellData(sheetName, "FirstName", 2));
        myAddressesPage.enterLastName(reader.getCellData(sheetName, "LastName", 2));
        myAddressesPage.enterEmail(reader.getCellData(sheetName, "Email", 2));
        myAddressesPage.selectCountry(reader.getCellData(sheetName, "Country", 2));
        myAddressesPage.selectStateProvince(reader.getCellData(sheetName, "State", 2));
        myAddressesPage.enterCity(reader.getCellData(sheetName, "City", 2));
        myAddressesPage.enterAddress1(reader.getCellData(sheetName, "Address", 2));
        myAddressesPage.enterPhoneNumber(reader.getCellData(sheetName, "Phone", 2));
    }

    @And("User fill up the address form with valid value without the phone field")
    public void userFillUpTheAddressFormWithValidValueWithoutThePhoneField() {
        myAddressesPage.enterFirstName(reader.getCellData(sheetName, "FirstName", 2));
        myAddressesPage.enterLastName(reader.getCellData(sheetName, "LastName", 2));
        myAddressesPage.enterEmail(reader.getCellData(sheetName, "Email", 2));
        myAddressesPage.selectCountry(reader.getCellData(sheetName, "Country", 2));
        myAddressesPage.selectStateProvince(reader.getCellData(sheetName, "State", 2));
        myAddressesPage.enterCity(reader.getCellData(sheetName, "City", 2));
        myAddressesPage.enterAddress1(reader.getCellData(sheetName, "Address", 2));
        myAddressesPage.enterZipPostalCode(reader.getCellData(sheetName, "Zip", 2));
    }

    @And("User fill up the address form with valid value in add new address page")
    public void userFillUpTheAddressFormWithValidValueInAddNewAddressPage() {
        myAddressesPage.enterFirstName(reader.getCellData(sheetName, "FirstName", 2));
        myAddressesPage.enterLastName(reader.getCellData(sheetName, "LastName", 2));
        myAddressesPage.enterEmail(reader.getCellData(sheetName, "Email", 2));
        myAddressesPage.selectCountry(reader.getCellData(sheetName, "Country", 2));
        myAddressesPage.selectStateProvince(reader.getCellData(sheetName, "State", 2));
        myAddressesPage.enterCity(reader.getCellData(sheetName, "City", 2));
        myAddressesPage.enterAddress1(reader.getCellData(sheetName, "Address", 2));
        myAddressesPage.enterZipPostalCode(reader.getCellData(sheetName, "Zip", 2));
        myAddressesPage.enterPhoneNumber(reader.getCellData(sheetName, "Phone", 2));
    }

    @And("User click on Save button")
    public void userClickOnSaveButton() {
        myAddressesPage.clickOnAddNewAddressSaveButton();
        myAddressesPage.pageLoading();
    }

    @Then("User should be able to see error message {string} in first name field")
    public void userShouldBeAbleToSeeErrorMessage(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, myAddressesPage.firstNameErrorMessage());
    }

    @Then("User should be able to see error message {string} in last name field")
    public void userShouldBeAbleToSeeErrorMessageInLastNameField(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, myAddressesPage.LastNameErrorMessage());
    }

    @Given("User perform login and go to my account address page")
    public void userPerformLoginAndGoToMyAccountAddressPage() {
        loginPage.goToHomePage(baseUrl);
        loginPage.goToLoginPage();
        loginPage.enterEmail(reader.getCellData("Login", "Email", 7));
        loginPage.enterPassword(reader.getCellData("Login", "Password", 7));
        loginPage.clickOnLoginButton();
        myAddressesPage.goToMyAccountPage();
        myAddressesPage.goToMyAccountAddressesPage();
    }

    @Then("User should be able to see error message {string} in email field")
    public void userShouldBeAbleToSeeErrorMessageInEmailField(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, myAddressesPage.EmailErrorMessage());
    }

    @Then("User should be able to see error message {string} in country field")
    public void userShouldBeAbleToSeeErrorMessageInCountryField(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, myAddressesPage.ValidationErrorMessage());
    }

    @Then("User should be able to see error message {string} in state field")
    public void userShouldBeAbleToSeeErrorMessageInStateField(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, myAddressesPage.ValidationErrorMessage());
    }

    @Then("User should be able to see error message {string} in city field")
    public void userShouldBeAbleToSeeErrorMessageInCityField(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, myAddressesPage.CityErrorMessage());
    }

    @Then("User should be able to see error message {string} in address field")
    public void userShouldBeAbleToSeeErrorMessageInAddressField(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, myAddressesPage.Address1ErrorMessage());
    }

    @Then("User should be able to see error message {string} in zip code field")
    public void userShouldBeAbleToSeeErrorMessageInZipCodeField(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, myAddressesPage.ZipPostalCodeErrorMessage());
    }

    @Then("User should be able to see error message {string} in phone field")
    public void userShouldBeAbleToSeeErrorMessageInPhoneField(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, myAddressesPage.PhoneNumberErrorMessage());
    }

    @Then("User should be able to see the added address in address page")
    public void userShouldBeAbleToSeeTheAddedAddressInAddressPage() {
        Assertions.assertTrue(myAddressesPage.addressBodyHasAddress().contains(reader.getCellData(sheetName, "FirstName", 2) + " " + reader.getCellData(sheetName, "LastName", 2)));
    }

    @When("User click on Edit button of the first address in address page")
    public void userClickOnEditButtonOfTheFirstAddressInAddressPage() {
        myAddressesPage.clickOnEditAddressButton();
        myAddressesPage.pageLoading();
    }

    @And("User clear First name field in edit address page")
    public void userClearFirstNameFieldInEditAddressPage() {
        myAddressesPage.clearFirstNameTextBox();
    }

    @And("User clear Last name field in edit address page")
    public void userClearLastNameFieldInEditAddressPage() {
        myAddressesPage.clearLastNameTextBox();
    }

    @And("User clear Email field in edit address page")
    public void userClearEmailFieldInEditAddressPage() {
        myAddressesPage.clearEmailTextBox();
    }

    @And("User clear Country field in edit address page")
    public void userClearCountryFieldInEditAddressPage() {
        myAddressesPage.clearCountryDropDown();
    }

    @And("User clear State field in edit address page")
    public void userClearStateFieldInEditAddressPage() {
        myAddressesPage.clearStateProvinceDropDown();
    }

    @And("User clear City field in edit address page")
    public void userClearCityFieldInEditAddressPage() {
        myAddressesPage.clearCityTextBox();
    }

    @And("User clear Address field in edit address page")
    public void userClearAddressFieldInEditAddressPage() {
        myAddressesPage.clearAddress1TextBox();
    }

    @And("User clear Zip code field in edit address page")
    public void userClearZipCodeFieldInEditAddressPage() {
        myAddressesPage.clearZipPostalCodeTextBox();
    }

    @And("User clear Phone field in edit address page")
    public void userClearPhoneFieldInEditAddressPage() {
        myAddressesPage.clearPhoneNumberTextBox();
    }

    @And("User fill in Email field with wrong Email format in edit address page")
    public void userFillInEmailFieldWithWrongEmailFormatInEditAddressPage() {
        myAddressesPage.enterEmail(reader.getCellData(sheetName, "Wrong", 3));
    }

    @When("User click on Delete button of the first address in address page")
    public void userClickOnDeleteButtonOfTheFirstAddressInAddressPage() {
        beforeAddressTitle = myAddressesPage.getFirstAddressTitle();
        myAddressesPage.clickDeleteAddressButton();
        myAddressesPage.pageLoading();
        afterAddressTitle = myAddressesPage.getFirstAddressTitle();
    }

    @And("User fill up the address form with valid value for edit address page")
    public void userFillUpTheAddressFormWithValidValueForEditAddressPage() {
        myAddressesPage.enterFirstName(reader.getCellData(sheetName, "FirstName", 3));
        myAddressesPage.enterLastName(reader.getCellData(sheetName, "LastName", 3));
        myAddressesPage.enterEmail(reader.getCellData(sheetName, "Email", 3));
        myAddressesPage.selectCountry(reader.getCellData(sheetName, "Country", 3));
        myAddressesPage.selectStateProvince(reader.getCellData(sheetName, "State", 3));
        myAddressesPage.enterCity(reader.getCellData(sheetName, "City", 3));
        myAddressesPage.enterAddress1(reader.getCellData(sheetName, "Address", 3));
        myAddressesPage.enterZipPostalCode(reader.getCellData(sheetName, "Zip", 3));
        myAddressesPage.enterPhoneNumber(reader.getCellData(sheetName, "Phone", 3));
    }

    @Then("User should be able to see the deleted address is not displayed in address page")
    public void userShouldBeAbleToSeeTheDeletedAddressIsNotDisplayedInAddressPage() {
        Assertions.assertNotEquals(beforeAddressTitle, afterAddressTitle);
    }

    @Then("User should be able to see the edited address in address page")
    public void userShouldBeAbleToSeeTheEditedAddressInAddressPage() {
Assertions.assertTrue(myAddressesPage.addressBodyHasAddress().contains(reader.getCellData(sheetName, "FirstName", 3) + " " + reader.getCellData(sheetName, "LastName", 3)));

    }
}
