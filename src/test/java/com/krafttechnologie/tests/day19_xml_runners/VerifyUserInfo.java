package com.krafttechnologie.tests.day19_xml_runners;

import com.krafttechnologie.pages.EditProfilePage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.pages.UserProfilePage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyUserInfo extends TestBase {
    /** Class Task

     Login as a jack
     Verify that login is successful
     Click on My profile
     Click on Edit Profile
     Verify that job is QA Automation Engineer

     */

    @Test
    public void verifyUserInfoTest(){

        LoginPage loginPage = new LoginPage();
        UserProfilePage userProfilePage = new UserProfilePage();
        EditProfilePage editProfilePage = new EditProfilePage();


        extentLogger = report.createTest("Test for practice");

        extentLogger.info("go to url");
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("login as jack");
        loginPage.login();

        extentLogger.info("verify that you are on the home page by using jack");
        String expected="jack";
       // String actual=loginPage.userAccountName.getText();
        // userAccountName aslında BasePage webElementi ancak BasePage abstract olduğu
        // için ondan nesne üretemeyiz onun yerine ona extend eden LoginPage clasından nesne üretip
        // ilgili webElementi çağırabiliriz
        String actual = loginPage.getUserAccountName();
        Assert.assertEquals(actual,expected);

        extentLogger.info("click on my profile");
        loginPage.navigateToModule("jack","My Profile");

        extentLogger.info("click on Edit Profile");
        userProfilePage.navigateToOverviewMenu("Edit Profile");

        extentLogger.info("Verify that job is QA Automation Engineer");
        String expectedJob = "QA Automation Engineer";
        String actualJob= editProfilePage.getSelectedJob();
        Assert.assertEquals(expectedJob,actualJob);


        extentLogger.pass("PASSED");






    }

}
