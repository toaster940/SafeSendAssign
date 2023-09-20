package com.example.tests;

import com.example.pageObjects.LoginPage;
import com.example.utilities.FileReaderManger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private FileReaderManger fileReaderManger;


    @BeforeClass
    public void  getInstances(){
        fileReaderManger = new FileReaderManger();
        loginPage = BaseTest.getLoginPage();
        driver = BaseTest.getDriver();
    }
    @Test(description = "User navigates to SafeSend", priority = 1)
    public void navigateToLoginPage() throws InterruptedException {
        driver.get(fileReaderManger.getUrl());
        Assert.assertEquals(driver.getTitle(),fileReaderManger.getLoginPageTitle());
    }

    @Test(description = "User logs in using username and password", priority = 2)
    public void loginToSafeSendSuiteAccount(){
    loginPage.getUsernameTextField().sendKeys(fileReaderManger.getUsername());
    loginPage.getPasswordTextField().sendKeys(fileReaderManger.getPassword());
    loginPage.getLoginButton().click();

    }

}
