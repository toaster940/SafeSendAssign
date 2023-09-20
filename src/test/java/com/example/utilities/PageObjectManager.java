package com.example.utilities;

import com.example.pageObjects.LandingPage;
import com.example.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private final WebDriver driver;
    private LandingPage landingPage;
    private LoginPage loginPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }
    public LandingPage getLandingPage() {
        return (landingPage == null) ? landingPage = new LandingPage(driver) : landingPage;
    }
    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }
}
