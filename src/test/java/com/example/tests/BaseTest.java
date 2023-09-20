package com.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.example.pageObjects.LandingPage;
import com.example.pageObjects.LoginPage;
import com.example.utilities.FileReaderManger;
import com.example.utilities.PageObjectManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    private static WebDriver driver;

    @BeforeSuite
    public static WebDriver setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito","--window-size=1644,868", "--ignore-ssl-errors=yes",
                "--ignore-certificate-errors");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        Long time = getTimeouts();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        return driver;
    }

//    @Test
//    public void testTemp(){
//
//    }
    @AfterSuite
    public static void tearDown() {
        driver.quit();
    }

    public static LoginPage getLoginPage() {
        return new PageObjectManager(driver).getLoginPage();
    }

    public static LandingPage getLandingPage() {
        return new PageObjectManager(driver).getLandingPage();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static Long getTimeouts() {
        return new FileReaderManger().getTime();
    }

    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        String destPath =null;
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;

            File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

            try {
                 destPath = "/screenshots/" + screenshotName + ".png";

                FileUtils.copyFile(screenshotFile, new File(destPath));

                System.out.println("Screenshot captured and saved at: " + destPath);
            } catch (IOException e) {
                System.err.println("Error while saving the screenshot: " + e.getMessage());
            }
        } else {
            System.err.println("Driver does not support taking screenshots.");
        }
        return destPath;
    }

}
