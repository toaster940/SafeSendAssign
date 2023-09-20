package com.example.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.example.tests.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        clearFolder(new File(System.getProperty("user.dir") + File.separator + "reports"));
        if (extentReports == null) {
            String reportPath = System.getProperty("user.dir") + File.separator + "reports"
                    + File.separator + getCurrentDateTime() + "index.html";
            File existingReportFile = new File(reportPath);
            if (existingReportFile.exists()) {
                existingReportFile.delete();
            }
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test Case Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test Case Failed");
        extentTest.addScreenCaptureFromPath(BaseTest.captureScreenshot(BaseTest.getDriver(), result.getName()), result.getName());
        extentTest.log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, "Test Case Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    private static String getCurrentDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
        return dateTimeFormatter.format(LocalDateTime.now());
    }
    private static void clearFolder(File folder) {
        if (folder.exists()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // Recursively clear subdirectories
                        clearFolder(file);
                    } else {
                        // Delete files
                        file.delete();
                    }
                }
            }
        }
    }
}
