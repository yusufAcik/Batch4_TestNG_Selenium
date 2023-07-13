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

      //  extentLogger.info("Go to Krafttech login page");
      //  driver.get(ConfigurationReader.get("url"));
        extentLogger.info("Enter wrong user email");
        loginPage.emailInputBox.sendKeys("jack@gmail.co");
        extentLogger.info("Enter user password");
        loginPage.passwordInputBox.sendKeys("Jack12345");
        extentLogger.info("Click login button");
        loginPage.loginButton.click();
        extentLogger.info("Verify that Not log in");
        String actualMessage = loginPage.usernameErrorMessage.getText();
        String expectedMessage = "Email address is incorrect. Please check";
        Assert.assertEquals(actualMessage, expectedMessage);
        extentLogger.pass("PASSED");
    }
}
