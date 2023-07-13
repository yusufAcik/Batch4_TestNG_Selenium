package com.krafttechnologie.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    // starting and building reports
    protected ExtentReports report;
    // create html report
    protected ExtentHtmlReporter htmlReporter;
    // information about test
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        // initialize class
        report=new ExtentReports();

        //create report path
        String projectPath = System.getProperty("user.dir");
        // to take dynamic report
       // String date = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
       // String path = projectPath+"/test-output/report"+date+".html";
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
    @AfterTest
    public void tearDownTest(){

            report.flush(); // report actually created
        }



    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions = new Actions(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
        driver.get(ConfigurationReader.get("url")); //report için kullanılabilir
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }
}
