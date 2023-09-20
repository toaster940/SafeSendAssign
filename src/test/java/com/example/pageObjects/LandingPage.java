package com.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class LandingPage {

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    @FindBy(css = ".left-child p")
    private WebElement companyNameHeader;
    @FindBy(css = ".side-menu-toggle")
    private WebElement sideMenuToggle;
    @FindBy(xpath = "//*[text()='Delivered Returns']")
    private WebElement deliveredReturnButton;
    @FindBy(css = ".filters .btn-group:nth-child(4) .btn-filter:nth-child(2)")
    private WebElement filterDropdown;
    @FindBy(xpath = "//*[text()='Clear Filter']")
    private WebElement clearFilterButton;

    @FindBy(xpath = "//*[text()='E-Signed']")
    private WebElement eSignedFilter;
    @FindBy(xpath = "//*[text()='Apply']")
    private WebElement applyFilterButton;


    @FindBy(css = "table tbody tr td:nth-child(3)")
    private List<WebElement> clientIds;

    public WebElement getCompanyNameHeader() {
        companyNameHeader.isDisplayed();
        return companyNameHeader;
    }

    public WebElement getSideMenuToggle() {
        sideMenuToggle.isDisplayed();
        return sideMenuToggle;
    }

    public WebElement getDeliveredReturnButton() {
        deliveredReturnButton.isEnabled();
        return deliveredReturnButton;
    }

    public WebElement getFilterDropdown() {
        filterDropdown.isEnabled();
        return filterDropdown;
    }

    public WebElement getClearFilterButton() {
        clearFilterButton.isEnabled();
        return clearFilterButton;
    }

    public WebElement geteSignedFilter() {
        eSignedFilter.isEnabled();
        return eSignedFilter;
    }

    public WebElement getApplyFilterButton() {
        applyFilterButton.isEnabled();
        return applyFilterButton;
    }

    public List<WebElement> getClientIds() {
        return clientIds;
    }

}
