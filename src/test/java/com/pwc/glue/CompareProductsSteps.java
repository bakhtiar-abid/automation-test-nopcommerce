package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.CompareProductPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CompareProductsSteps {

    //getting base url from config file
    private final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();
    Page page = DriverFactory.getPage();

    CompareProductPage compareProductPage = new CompareProductPage(page);

    String firstProductName;
    String fourthProductName;
    @Given("User have two products on compare product page and on compare product page")
    public void userHaveTwoProductsOnCompareProductPageAndOnCompareProductPage() {
        compareProductPage.goToHomePage(baseUrl);
        compareProductPage.clickOnFirstProductAddToCompareButton();
        compareProductPage.goToHomePage(baseUrl);
        compareProductPage.clickOnSecondProductAddToCompareButton();
        compareProductPage.clickOnCompareProductPageLink();

    }

    @When("User click on remove button")
    public void userClickOnRemoveButton() {
        firstProductName = compareProductPage.getCompareListFirstProduct();
        compareProductPage.clickOnCompareListFirstProductRemoveButton();
        compareProductPage.pageLoading();
    }

    @Then("User should see product removed from compare product page")
    public void userShouldSeeProductRemovedFromCompareProductPage() {
        Assertions.assertNotEquals(firstProductName, compareProductPage.getCompareListFirstProduct());
    }

    @When("User click on clear list button")
    public void userClickOnClearListButton() {

        compareProductPage.clickOnClearListButton();
        compareProductPage.pageLoading();
    }

    @Then("User should see all products removed from compare product page")
    public void userShouldSeeAllProductsRemovedFromCompareProductPage() {
        Assertions.assertFalse(compareProductPage.isCompareListTableDisplayed());
    }

    @When("User add more than four products in compare product page")
    public void userAddMoreThanFourProductsInCompareProductPage() {
        compareProductPage.goToHomePage(baseUrl);
        compareProductPage.addTwoMoreProductsToCompareList();
        compareProductPage.pageLoading();
        compareProductPage.clickOnCompareProductPageLink();
        fourthProductName = compareProductPage.getCompareListFourthProduct();
        compareProductPage.goToHomePage(baseUrl);
        compareProductPage.addOneMoreProductToCompareList();
        compareProductPage.pageLoading();
        compareProductPage.clickOnCompareProductPageLink();

    }

    @Then("User should see previous products removed from compare product page")
    public void userShouldSeePreviousProductsRemovedFromCompareProductPage() {
        Assertions.assertNotEquals(fourthProductName, compareProductPage.getCompareListFourthProduct());
    }
}
