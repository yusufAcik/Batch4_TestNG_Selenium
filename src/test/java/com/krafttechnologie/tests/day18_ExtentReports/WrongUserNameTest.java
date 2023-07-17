package com.krafttechnologie.tests.day18_ExtentReports;

import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUserNameTest extends TestBase {

    @Test
    public void wrongUserEmailTest() {

        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Wrong User Email Test");

        extentLogger.info("Go to Krafttech login page");
         driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Enter wrong user email");
        loginPage.emailInputBox.sendKeys("jack@gmail.co");
        extentLogger.info("Enter user password");
        loginPage.passwordInputBox.sendKeys("Jack12345");
        extentLogger.info("Click login button");
        loginPage.loginButton.click();
        extentLogger.info("Verify that Not log in");
        String actualMessage = loginPage.usernameErrorMessage.getText();
        String expectedMessage = "Email address is incorrect. Please check";
        //String expectedMessage = " address is incorrect. Please check"; // for fail
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.pass("PASSED");
    }

    @Test
    public void wrongPasswordTest(){
        LoginPage loginPage = new LoginPage();
        extentLogger = report.createTest("Wrong Password Test");

        extentLogger.info("Go to Krafttech login page");
        driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Enter valid user email");
        loginPage.emailInputBox.sendKeys("jack@gmail.com");
        extentLogger.info("Enter wrong user password");
        loginPage.passwordInputBox.sendKeys("wrong password");
        extentLogger.info("Click login button");
        loginPage.loginButton.click();
        extentLogger.info("Verify that Not log in");
        String actualMessage = loginPage.passwordErrorMessage.getText();
        String expectedMessage = "Password is incorrect. Please check";
        //String expectedMessage = "Password is incor. Please check"; // for fail
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.pass("PASSED");
    }
}
