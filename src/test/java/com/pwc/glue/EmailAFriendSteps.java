package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.EmailAFriendPage;
import com.pages.LoginPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class EmailAFriendSteps {
    Page page = DriverFactory.getPage();
    /* Define page classes object */
    LoginPage loginPage = new LoginPage(page);
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage(page);

    /* Read data from emailAFrientData.xlsx file */
    Xls_Reader xlsReader = new Xls_Reader("src/test/resources/config/Testdata/emailAFrienData.xlsx");
    String sheetName = "emailFriendData";
    String friendEmail = xlsReader.getCellData(sheetName, "friendEmail", 2);
    String yourEmail = xlsReader.getCellData(sheetName, "yourEmail", 2);
    String nonRegisteredYourEmail = xlsReader.getCellData(sheetName, "nonRegisteredYourEmail", 2);
    String message = xlsReader.getCellData(sheetName, "message", 2);

    /*Get base URl*/
    String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();
    @Given("Go to the login page and perform login")
    public void goToTheLoginPageAndPerformLogin() {

    }
    @Given("Go to the email a friend page and fill all the field and click on the send button")
    public void goToTheEmailAFriendPageAndFillAllTheFieldAndClickOnTheSendButton() {
        emailAFriendPage.clickEmailAFriendBtn();
        emailAFriendPage.fillFriendEmailField(friendEmail);
        emailAFriendPage.fillYourEmailField(yourEmail);
        emailAFriendPage.fillMsgField(message);
        emailAFriendPage.clickSendEmailBtn();
    }

    @And("Verify that {string} success message is showing on this page")
    public void verifyThatSuccessMessageIsShowingOnThisPage(String expectedResult) {
        String actualResult = emailAFriendPage.getSendEmailSuccessMsg();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Then("Go to the email a friend page and fill all the field without Friend's email field and click on the send button")
    public void goToTheEmailAFriendPageAndFillAllTheFieldWithoutFriendSEmailFieldAndClickOnTheSendButton() {
        emailAFriendPage.clickEmailAFriendBtn();
        emailAFriendPage.fillMsgField(message);
        emailAFriendPage.clickSendEmailBtn();
    }

    @Then("Verify this {string} error message show bellow the Friend's email field")
    public void verifyThisShowBellowTheFriendSEmailField(String expectedResult) {
        String actualResult = emailAFriendPage.getFriendEmailAlertMsg();
        System.out.println("actualResult:-- " + actualResult);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Then("Go to the email a friend page and fill only required field and click on the send button")
    public void goToTheEmailAFriendPageAndFillOnlyRequiredFieldAndClickOnTheSendButton() {
        emailAFriendPage.clickEmailAFriendBtn();
        emailAFriendPage.fillFriendEmailField(friendEmail);
        emailAFriendPage.fillYourEmailField(yourEmail);
        emailAFriendPage.clickSendEmailBtn();
    }

    @Given("Go to the email a friend page and fill all the field with an unregistered email on the your email address field and click on the send button")
    public void goToTheEmailAFriendPageAndFillAllTheFieldWithAnUnregisteredEmailOnTheYourEmailAddressFieldAndClickOnTheSendButton() {
        emailAFriendPage.clickEmailAFriendBtn();
        emailAFriendPage.fillFriendEmailField(friendEmail);
        emailAFriendPage.fillYourEmailField(nonRegisteredYourEmail);
        emailAFriendPage.fillMsgField(message);
        emailAFriendPage.clickSendEmailBtn();
    }

    @And("{string} alert message showing on the top")
    public void alertMessageShowingOnTheTop(String expectedResult) {
        String actualResult = emailAFriendPage.getNonRegisterUsersAlertMsg();
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
