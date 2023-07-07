package com.krafttechnologie.tests.day15_pom1;

import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){

        /**
         go to kraft login page
         provide right username
         provide wrong password
         tap on login button
         validate that "Password is incorrect. Please check" message appears
         */

        driver.get(ConfigurationReader.get("url"));

        // create a loginpage object to reach out the webelement that are located
        LoginPage loginPage = new LoginPage();

        loginPage.emailInputBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordInputBox.sendKeys("wrong password");
        loginPage.loginButton.click();

        // verification
        String expected = "Password is incorrect. Please check";
        String actual = loginPage.passwordErrorMessage.getText();

        Assert.assertEquals(actual,expected);
    }

    /**

     go to kraft login page
     provide wrong username
     provide right password
     tap on login button
     validate that "Email address is incorrect. Please check" message appears
     */
    @Test
    public void wrongUserNameTest(){

        driver.get(ConfigurationReader.get("url"));

        LoginPage loginPage = new LoginPage();

        loginPage.emailInputBox.sendKeys("wrong username");
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.get("userPassword"));
        loginPage.loginButton.click();

        String expected = "Email address is incorrect. Please check";
        String actual = loginPage.usernameErrorMessage.getText();

        Assert.assertEquals(actual,expected);

    }

}
