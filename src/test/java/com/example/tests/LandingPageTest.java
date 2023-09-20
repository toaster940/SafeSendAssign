package com.example.tests;

import com.example.pageObjects.LandingPage;
import com.example.utilities.CommonUtils;
import com.example.utilities.FileReaderManger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class LandingPageTest {

    private WebDriver driver;
    private LandingPage landingPage;
    private CommonUtils commonUtils;

    @BeforeClass
    public void getInstances() {
        landingPage = BaseTest.getLandingPage();
        driver = BaseTest.getDriver();
        commonUtils = new CommonUtils(driver);
    }

    @Test(description = "Print the Company Name and expand side toggle", priority = 1)
    public void getCompanyNameAndExpandToggle() {
        String companyName = landingPage.getCompanyNameHeader().getText();
        System.out.println(companyName);
        landingPage.getSideMenuToggle().click();
    }

    @Test(description = "Navigate to “Delivered Returns” page & apply filter", priority = 2)
    public void applyFilterOnDeliveredReturns() {
        landingPage.getSideMenuToggle().click();
        landingPage.getDeliveredReturnButton().click();
        landingPage.getFilterDropdown().click();
        landingPage.getClearFilterButton().click();
        landingPage.getFilterDropdown().click();
        commonUtils.mouseHoverOnElement(landingPage.geteSignedFilter());
        landingPage.getApplyFilterButton().click();
    }

    @Test(description = "Print the first three Client IDs in the resultant table with status “E-Signed”", priority = 3)
    public void getFirstThreeClients() {
        int counter = 0;
        List<WebElement> Ids = landingPage.getClientIds();
        if (Ids.size() > 0)
            for (WebElement Id : Ids) {
                System.out.println(Id.getText());
                counter++;
                if (counter == 3)
                    break;
            }
    }
}
