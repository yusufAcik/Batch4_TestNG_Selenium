package com.krafttechnologie.tests.day18_ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportsDemo {
// starting and building reports
    ExtentReports report;
    // create html report
    ExtentHtmlReporter htmlReporter;
    // information about test
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        // initialize class
    report=new ExtentReports();

    //create report path
    String projectPath = System.getProperty("user.dir");
    String path = projectPath+"/test-output/report.html";

    // initialize the html report with the report path
        htmlReporter=new ExtentHtmlReporter(path);

        // attach the html report to the report object
        report.attachReporter(htmlReporter);

        // title in report
        htmlReporter.config().setReportName("Krafttech smoke test");

        // set enviroment info
        report.setSystemInfo("Enviroment","Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS","os.name");
        report.setSystemInfo("Test Engineer","Yusuf");


    }

    @Test
    public void test1() {
        extentLogger=report.createTest("TC001 Login Test");
        extentLogger.info("Open the Browser");
        extentLogger.info("Go to url https://www.krafttechexlab.com/login");
        extentLogger.info("Login as jack");
        extentLogger.info("Enter jack username");
        extentLogger.info("Enter jack password");
        extentLogger.info("Click login button");
        extentLogger.info("Verify logged in");
        extentLogger.info("TC001 Login Test is Passed");
    }

    @AfterMethod
    public void tearDown(){
        report.flush(); // report actually created
    }
}
