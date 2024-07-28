package com.pwc.glue;

import com.microsoft.playwright.Page;
import com.pages.HomepagePage;
import com.qa.managers.DriverFactory;
import com.qa.managers.FileReaderManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class HomePageSteps {
    Page page = DriverFactory.getPage();
    HomepagePage homePage = new HomepagePage(page);

    /* base URL */
    String url = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    @Given("go to the home page")
    public void goToTheHomePage() {
        homePage.gotoHomepage(url);
    }
    @Given("click the register link from the home page header")
    public void clickTheRegisterLinkFromTheHomePageHeader() {
        homePage.clickRegisterLinkFromHeader();
    }

    @Then("verify the page title contains {string}")
    public void verifyThePageTitleContains(String expectedTitle) {
        String actualTitle = homePage.getTitle().toLowerCase();
        Assertions.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()));
    }

    @Then("click the logo and verify if is it on the home page")
    public void clickTheLogoAndVerifyIfIsItOnTheHomePage() {
        homePage.clickHomepageLogo();
        String actualTitle = homePage.getTitle();
        Assertions.assertTrue(actualTitle.contains("Home page"));
    }

    @Given("click the login link from the home page header")
    public void clickTheLoginLinkFromTheHomePageHeader() {
        homePage.clickLoginLinkFromHeader();
    }

    @Then("verify the logout link is visible")
    public void verifyTheLogoutLinkIsVisible() {
        Assertions.assertTrue(homePage.isLogoutButtonVisible());
    }

    @Then("click the logout link from the home page header and verify the login link is visible")
    public void clickTheLogoutLinkFromTheHomePageHeaderAndVerifyTheLoginLinkIsVisible() {
        homePage.clickLogoutLinkFromHeader();
        Assertions.assertTrue(homePage.isLoginButtonVisible());
    }

    @Given("click the wishlist link from the home page header")
    public void clickTheWishlistLinkFromTheHomePageHeader() {
        homePage.clickWishListFromHeader();
    }

    @Given("click the shopping cart link from the home page header")
    public void clickTheShoppingCartLinkFromTheHomePageHeader() {
        homePage.clickShoppingCartFromHeader();
    }

    @Given("click on the books category")
    public void clickOnTheBooksCategory() {
        homePage.clickBooksCategory();
    }

    @Given("hover to the electronics category and click the other sub-category")
    public void hoverToTheElectronicsCategoryAndClickTheOtherSubCategory() {
        homePage.clickElectronicOthersCategory();
    }

    @Given("go to the first product from the home page and verify the product name from the product details page")
    public void goToTheFirstProductFromTheHomePageAndVerifyTheProductNameFromTheProductDetailsPage() {
        String homepageProductName = homePage.getFirstHomepageProductTitle();
        homePage.clickFirstHomepageProduct();
        String detailsPageProductName = homePage.getDetailsPageProductName();
        Assertions.assertEquals(homepageProductName,detailsPageProductName);
    }

    @Given("click add to cart button for the third product on the home page")
    public void clickAddToCartButtonForTheThirdProductOnTheHomePage() {
        homePage.click3rdHomepageProductCartBtn();
    }

    @And("verify {string} message visible at the top")
    public void verifyMessageVisibleAtTheTop(String msg) {
        Assertions.assertTrue(homePage.getTopBarSuccessMsg().contains(msg));
    }

    @Given("click compare button for the third product on the home page")
    public void clickCompareButtonForTheThirdProductOnTheHomePage() {
        homePage.click3rdHomepageProductCompareBtn();
    }

    @Given("click wish list button for the third product on the home page")
    public void clickWishListButtonForTheThirdProductOnTheHomePage() {
        homePage.click3rdHomepageProductWishlistBtn();
    }

    @Given("click on the first news details button")
    public void clickOnTheFirstNewsDetailsButton() {
    }

    @Given("click the {string} link from the home page footer")
    public void clickTheLinkFromTheHomePageFooter(String optionName) {
        homePage.clickFooterOptions(optionName);
    }

    @Then("verify the page body title contains {string}")
    public void verifyThePageBodyTitleContains(String expectedTitle) {
        String actualTitle = homePage.getPageBodyTitle().toLowerCase();
        Assertions.assertTrue(actualTitle.contains(expectedTitle.toLowerCase()));
    }

    @Given("click on the first news title and verify the page title should be contains news title")
    public void clickOnTheFirstNewsTitleAndVerifyThePageTitleShouldBeContainsNewsTitle() {
        String newsTitle = homePage.get1stNewsTitleFromHomePage().toLowerCase();
        homePage.clickFirstNewsTitle();
        String newsDetailsBodyTitle = homePage.getPageBodyTitle().toLowerCase();
        Assertions.assertEquals(newsTitle,newsDetailsBodyTitle);
    }

    @Given("click on the first news details button and verify the page title should be contains news title")
    public void clickOnTheFirstNewsDetailsButtonAndVerifyThePageTitleShouldBeContainsNewsTitle() {
        String newsTitle = homePage.get1stNewsTitleFromHomePage().toLowerCase();
        homePage.clickFirstNewsDetailsBtn();
        String newsDetailsBodyTitle = homePage.getPageBodyTitle().toLowerCase();
        Assertions.assertEquals(newsTitle,newsDetailsBodyTitle);
    }
}
