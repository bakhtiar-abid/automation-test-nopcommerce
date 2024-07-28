package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.ProductSearchPage;
import com.qa.managers.DriverFactory;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class ProductSearchSteps {
    Page page = DriverFactory.getPage();

    /* Page objects */
    ProductSearchPage productSearchPage = new ProductSearchPage(page);

    /* Read data from the Excel sheet */
    Xls_Reader xlsReader = new Xls_Reader("src/test/resources/config/Testdata/searchData.xlsx");
    String sheetName = "ProductSearchInfo";

    String productSearchKey = xlsReader.getCellData(sheetName, "productSearchKey", 2);
    String categoryValue = xlsReader.getCellData(sheetName, "categoryValue", 2);
    String manufactureValue = xlsReader.getCellData(sheetName, "manufactureValue", 2);
    String vendorValue = xlsReader.getCellData(sheetName, "vendorValue", 2);
    String shortProductSearchKey = xlsReader.getCellData(sheetName, "shortProductSearchKey", 2);
    String displayPerPage = xlsReader.getCellData(sheetName, "displayPerPage", 2);

    @Given("Goto the home page and click the search option from the footer")
    public void gotoTheHomePageAndClickTheSearchOptionFromTheFooter() {
        productSearchPage.gotoHomePage();
        productSearchPage.clickSearch();
    }

    @Given("Click the search button on the search page")
    public void clickTheSearchButtonOnTheSearchPage() {
        productSearchPage.clickSearchBtn();
    }

    @And("User get this {string} error message")
    public void userGetThisErrorMessage(String actualMessage) {
        String expectedMessage = productSearchPage.getWarningMsg();
        Assertions.assertEquals(actualMessage, expectedMessage);
    }

    @Given("Fill the search box with the length of two characters on the search page")
    public void fillTheSearchBoxWithTheLengthOfTwoCharactersOnTheSearchPage() {
        productSearchPage.fillSearchField(shortProductSearchKey);
    }

    @Given("Fill the search box with a existing product name on the search page")
    public void fillTheSearchBoxWithAExistingProductNameOnTheSearchPage() {
        productSearchPage.fillSearchField(productSearchKey);
    }

    @And("Verify the searched product is displayed")
    public void verifyTheSearchedProductIsDisplayed() {
        String searchedResultProductTitle = productSearchPage.getSearchProductTitle();
        Assertions.assertTrue(searchedResultProductTitle.contains(productSearchKey));
    }

    @Given("Enable the advanced search option")
    public void enableTheAdvancedSearchOption() {
        productSearchPage.checkAdvanceSearch();
    }

    @And("Verify the advance search options a visible")
    public void verifyTheAdvanceSearchOptionsAVisible() {
        Assertions.assertTrue(productSearchPage.isAdvanceSearchEnable());
    }

    @Given("Fill search box with a short key for advance search on the search page")
    public void fillSearchBoxWithAShortKeyForAdvanceSearchOnTheSearchPage() {
        productSearchPage.fillSearchField(shortProductSearchKey);
    }

    @And("Select the category manufacture and vendor from the dropdown option")
    public void selectTheCategoryManufactureAndVendorFromTheDropdownOption() {
        productSearchPage.selectCategory(categoryValue);
        productSearchPage.selectManufacture(manufactureValue);
    }

    @And("Verify the advance search product is visible")
    public void verifyTheAdvanceSearchProductIsVisible() {
        String searchedResultProductTitle = productSearchPage.getSearchProductTitle();
        Assertions.assertTrue(searchedResultProductTitle.contains(productSearchKey));
    }

    @Then("Select the display per page number")
    public void selectTheDisplayPerPageNumber() {
        productSearchPage.selectDisplayPerPage(displayPerPage);
    }

    @And("Verify the shown product number less then or equal given display per page number")
    public void verifyTheShownProductNumberLessThenOrEqualGivenDisplayPerPageNumber() {
        int totalSearchedProduct = productSearchPage.countSearchResultProduct();
        int maxProductShown = Integer.parseInt(displayPerPage);
        Assertions.assertTrue(totalSearchedProduct <= maxProductShown);
    }

    @Given("User Search for product from testdata and go to product details page of the product")
    public void userSearchForProductFromTestdataAndGoToProductDetailsPageOfTheProduct() {
        productSearchPage.gotoHomePage();
        productSearchPage.clickSearch();
        productSearchPage.fillSearchField(productSearchKey);
        productSearchPage.clickSearchBtn();
        productSearchPage.clickFirstProduct();
    }
}
