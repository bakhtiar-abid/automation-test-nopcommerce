package com.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.qa.managers.FileReaderManager;

public class ProductSearchPage {

    private final Page page;
    public ProductSearchPage(Page page){
        this.page = page;
    }

    String url = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    String baseURL = FileReaderManager.getInstance().getConfigReader().getBaseUrl();

    /*Xpath for the product search page */

    String searchBoxXpath = "//input[contains(@id,'q')]";
    String advancedSearchCheckBoxXpath = "//input[contains(@id,'advs')]";
    String categoryDropDownXpath = "//select[contains(@id,'cid')]";
    String manufacturerDropDownXpath = "//select[contains(@id,'mid')]";
    String subCategoryCheckBoxXpath = "//input[contains(@id,'isc')]";
    String productDescriptionCheckBoxXpath = "//input[contains(@id,'sid')]";
    String searchButtonXpath = "//button[contains(@class,'search-button')]";
    String searchResultProductListXpath = "(//div[contains(@class,'details')]/h2[contains(@class,'product-title')]/a)";
    String displayPerPageXpath = "//select[contains(@id,'products-pagesize')]";
    String searchingWarningMsgXpath = "//div[contains(@class,'warning')]";

    /*Methods for the search page*/
    public void gotoHomePage(){
        page.navigate(url);
    }
    public void clickSearch(){
        page.click("//a[text()='Search']");
    }

    public void fillSearchField(String data){
        page.fill(searchBoxXpath,data);
    }

    public void selectCategory(String cate){
        page.selectOption(categoryDropDownXpath, cate);
    }

    public void selectManufacture(String cate){
        page.selectOption(manufacturerDropDownXpath, cate);
    }

    public void selectVendor(String cate){
/* No-body */
    }

    public void selectDisplayPerPage(String displayPerPage){
        page.selectOption(displayPerPageXpath, displayPerPage);
    }

    public void checkAdvanceSearch(){
        page.click(advancedSearchCheckBoxXpath);
    }

    public void checkAutomaticallySearchSubCategories(){
        page.click(subCategoryCheckBoxXpath);
    }

    public void checkSearchInProductDescriptions(){
        page.click(productDescriptionCheckBoxXpath);
    }

    public void clickSearchBtn(){
        page.click(searchButtonXpath);
    }

    public String getWarningMsg(){
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        String msg = page.innerText(searchingWarningMsgXpath);
        System.out.println(msg);
        return msg;
    }

    public String getSearchProductTitle(){
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        String tempXpath = searchResultProductListXpath + "[" + 1 + "]";
        String msg = page.innerText(tempXpath);
        System.out.println(msg);
        return msg;
    }

    public int countSearchResultProduct(){
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            String tempXpath = searchResultProductListXpath + "[" + i + "]";
            if (page.isVisible(tempXpath)){
                count++;
            }else {
                break;
            }
        }
        return count;
    }

    public boolean isAdvanceSearchEnable(){
        boolean a = false;
        if (page.isVisible(categoryDropDownXpath) && page.isVisible(manufacturerDropDownXpath) && page.isVisible(manufacturerDropDownXpath)){
            a = true;
        }
        return a;
    }

    public void clickFirstProduct(){
        page.click(searchResultProductListXpath);
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

}
