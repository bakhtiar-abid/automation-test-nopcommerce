package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.GroupProductDetailsPage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class GroupProductDetailsSteps {

    Page page = DriverFactory.getPage();
    GroupProductDetailsPage groupProductDetailsPage = new GroupProductDetailsPage(page);

    final String baseUrl = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    Xls_Reader reader = new Xls_Reader("src/test/resources/config/Testdata/groupProductData.xlsx");
    String sheetName = "groupProduct";

    @Given("user is on the group product's product details page")
    public void userIsOnTheGroupProductSProductDetailsPage() {
        groupProductDetailsPage.goToHomePage(baseUrl);
        groupProductDetailsPage.searchGroupProduct(reader.getCellData(sheetName, "productName", 2));
        groupProductDetailsPage.clickOnProductTitle();
    }

    @Then("user should see the details of the variant product")
    public void userShouldSeeTheDetailsOfTheVariantProduct() {
        String actualProductName = groupProductDetailsPage.getProductDetailsPageProductName();
        String expectedProductName = reader.getCellData(sheetName, "productName", 2);
        String actualFirstVariantProductName = groupProductDetailsPage.getProductDetailsPageFirstVariantName();
        String expectedFirstVariantProductName = reader.getCellData(sheetName, "variantName", 2);
        String actualSecondVariantProductName = groupProductDetailsPage.getProductDetailsPageSecondVariantName();
        String expectedSecondVariantProductName = reader.getCellData(sheetName, "variantName", 3);
        Assertions.assertEquals(expectedProductName, actualProductName);
        Assertions.assertEquals(expectedFirstVariantProductName, actualFirstVariantProductName);
        Assertions.assertEquals(expectedSecondVariantProductName, actualSecondVariantProductName);
    }
}
