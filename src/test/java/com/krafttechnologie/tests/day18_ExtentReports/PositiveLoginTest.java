package com.krafttechnologie.tests.day18_ExtentReports;

import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class PositiveLoginTest extends TestBase {

    @Test
    public void loginTest(){
        LoginPage loginPage=new LoginPage();
        extentLogger=report.createTest("Login Test");
        extentLogger.info("Go to Krafttech login page");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Login Method");
        loginPage.login();
        System.out.println("1");
    }

    @Test
    public void loginTest2(){
        LoginPage loginPage=new LoginPage();
        extentLogger=report.createTest("Login Test 2");
        extentLogger.info("Go to Krafttech login page");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Login Method 2");
        loginPage.login();
        System.out.println("2");
    }
}
