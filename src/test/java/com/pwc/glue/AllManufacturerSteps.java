package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.AllManufacturerPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AllManufacturerSteps {

    Page page = DriverFactory.getPage();

    //getting base url from config file
    final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    AllManufacturerPage allManufacturerPage = new AllManufacturerPage(page);

    @When("User click on a category on the home page")
    public void userClickOnACategoryOnTheHomePage() {
        allManufacturerPage.goToHomePage(baseUrl);
        allManufacturerPage.pageLoading();
        allManufacturerPage.clickOnBookCategory();
        allManufacturerPage.pageLoading();
    }

    @And("User click on view all in the manufacturer section")
    public void userClickOnViewAllInTheManufacturerSection() {
        allManufacturerPage.clickOnViewAll();
        allManufacturerPage.pageLoading();
    }

    @Then("User should be able to see all manufacturer on {string} page")
    public void userShouldBeAbleToSeeAllManufacturerOnPage(String pageTitle) {
        Assertions.assertEquals(pageTitle, allManufacturerPage.getPageTitle());
    }
}
