package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.SimpleProductDetailsPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SimpleProductDetailsSteps {
    Page page = DriverFactory.getPage();

    //getting base url from config file
    final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();
    SimpleProductDetailsPage simpleProductDetailsPage = new SimpleProductDetailsPage(page);


    Xls_Reader reader = new Xls_Reader("src/test/resources/config/testdata/simpleProductData.xlsx");
    String sheetName = "simpleProduct";

    @Given("user is on the product details page for a simple product")
    public void userIsOnTheProductDetailsPageForASimpleProduct() {
        simpleProductDetailsPage.goToHomePage(baseUrl);
        simpleProductDetailsPage.searchSimpleProduct(reader.getCellData(sheetName, "productName", 2));
        simpleProductDetailsPage.clickOnSimpleProduct();
    }

    @Then("the user should see the products name")
    public void theUserShouldSeeTheProductsName() {
        String productName = simpleProductDetailsPage.getProductName();
        Assertions.assertEquals(reader.getCellData(sheetName, "productName", 2), productName);
    }

    @When("user try to estimate shipping cost without selecting county")
    public void userTryToEstimateShippingCostWithoutSelectingCounty() {
        simpleProductDetailsPage.clickOnEstimateShippingCostLink();
        simpleProductDetailsPage.setZipCode(reader.getCellData(sheetName, "estimateShippingZip", 2));
        simpleProductDetailsPage.clickOnApplyButton();
    }

    @Then("the user should see the error message {string}")
    public void theUserShouldSeeTheErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = simpleProductDetailsPage.getEstimateShippingCostErrorMessage();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @When("user try to estimate shipping cost without filling zip code")
    public void userTryToEstimateShippingCostWithoutFillingZipCode() {
        simpleProductDetailsPage.clickOnEstimateShippingCostLink();
        simpleProductDetailsPage.selectCountry(reader.getCellData(sheetName, "estimateShippingCountry", 2));
        simpleProductDetailsPage.clickOnApplyButton();

    }

    @When("user estimate shipping cost with valid data")
    public void userEstimateShippingCostWithValidData() {
        simpleProductDetailsPage.clickOnEstimateShippingCostLink();
        simpleProductDetailsPage.selectCountry(reader.getCellData(sheetName, "estimateShippingCountry", 2));
        simpleProductDetailsPage.setZipCode(reader.getCellData(sheetName, "estimateShippingZip", 2));
        simpleProductDetailsPage.clickOnApplyButton();
    }

    @Then("the user should see the shipping costs")
    public void theUserShouldSeeTheShippingCosts() {
        Assertions.assertTrue(simpleProductDetailsPage.isEstimateShippingCostResultsDisplayed());
    }

    @Given("user is on the product details page for a downloadable simple product")
    public void userIsOnTheProductDetailsPageForADownloadableSimpleProduct() {
        simpleProductDetailsPage.goToHomePage(baseUrl);
        simpleProductDetailsPage.searchSimpleProduct(reader.getCellData(sheetName, "productName", 3));
        simpleProductDetailsPage.clickOnSimpleProduct();
    }

    @Then("user download the product's sample file")
    public void userDownloadTheProductSSampleFile() {
        simpleProductDetailsPage.clickOnSampleDownloadLink();
        Assertions.assertTrue(simpleProductDetailsPage.isDownloaded());

    }

    @Given("user is on the product details page for a simple product with specification attribute")
    public void userIsOnTheProductDetailsPageForASimpleProductWithSpecificationAttribute() {
        simpleProductDetailsPage.goToHomePage(baseUrl);
        simpleProductDetailsPage.searchSimpleProduct(reader.getCellData(sheetName, "productName", 4));
        simpleProductDetailsPage.clickOnSimpleProduct();
    }

    @Then("user see the specification attribute in product details page")
    public void userSeeTheSpecificationAttributeInProductDetailsPage() {
        Assertions.assertTrue(simpleProductDetailsPage.isSpecificationAttributeDisplayed());
    }
}
