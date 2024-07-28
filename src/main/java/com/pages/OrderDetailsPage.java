package com.pages;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class OrderDetailsPage {
    Page page;
    public OrderDetailsPage(Page page){
        this.page = page;
    }

/* Xpath */
    String orderListNumber1Xpath = "(//div[contains(@class,'order-item')]/div/strong)[1]";
    String printBtnXpath = "//a[@class='button-2 print-order-button']";
    String pdfInvoiceBtnXpath = "//a[@class='button-2 pdf-invoice-button']";
    String orderNumberInOrderDetailsPageXpath = "//div[@class='order-number']/strong";
    String reOrderBtnXpath = "//button[contains(@class,'re-order-button')]";
    String returnBtnXpath = "//button[contains(@class,'return-items-button')]";
    String orderListOrderNumberXpath = "(//strong[contains(text(),'Order Number')])[1]";
    String returnQntDropdownXpath = "//select[@class='valid']";
    String returnReasonDropdownXpath = "//select[@class='return-reasons valid']";
    String returnActionDropdownXpath = "//select[@class='return-actions valid']";
    String returnCommentDropdownXpath = "//textarea[@class='comment']";
    String submitReturnBtnXpath = "//button[contains(@class,'submit-return-request-button')]";
    boolean isDownload = false;
    public String getURL(){
        return page.url();
    }
    public String getPageTitle(){
        page.waitForLoadState(LoadState.NETWORKIDLE);
        return page.title();
    }
    public String getOrderNumberFromOrderDetailsPage(){
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        String orderNum = page.innerText(orderNumberInOrderDetailsPageXpath);
        String newOrderNum = orderNum.split("#")[orderNum.split("#").length-1];
        return newOrderNum;
    }
    public String getOrderNumberListPage(){
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return page.innerText(orderListOrderNumberXpath);
    }
    public void clickPrintBtn(){
        page.click(printBtnXpath);
    }
    public void clickPDFInvoice(){
        Download download = page.waitForDownload(()->{
            page.click(pdfInvoiceBtnXpath);
        });
        isDownload = true;
    }

    public boolean isDownload(){
        return isDownload;
    }
    public void clickReOrderBtn(){
        page.click(reOrderBtnXpath);
    }
    public void clickReturnItemBtn(){
        page.click(returnBtnXpath);
    }
    public void selectReturnQnt(String qnt){
        page.selectOption(returnQntDropdownXpath, qnt);
    }
    public void selectReturnReason(String reason){
        page.selectOption(returnReasonDropdownXpath, reason);
    }
    public void selectReturnAction(String action){
        if (page.isVisible(returnActionDropdownXpath)){
            page.selectOption(returnActionDropdownXpath, action);
        }
    }
    public void clickSubmitBtn(){
        page.click(submitReturnBtnXpath);
    }


}
