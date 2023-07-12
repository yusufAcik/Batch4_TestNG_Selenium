package com.krafttechnologie.tests.day17_pom3;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.EditProfilePage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.pages.UserProfilePage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditProfileTest extends TestBase {

    /** Class Task
     * THIS TASK WILL BE IMPLEMENTED USING POM
     * which means we will have one test class for the test
     * and one corresponding page having all locators and actions for the page
     * go to https://www.krafttechexlab.com/login
     * enter valid credentials
     *      --> jack@gmail.com
     *      --> Jack12345
     * go to Jack --> myProfile
     * create a method that navigate you to specific module based on the given parameter
     * go to Edit Profile page using the method just mentioned above
     * fill out the fields
     *      -->about --> SDET programme , graduated from KraftTech
     *      -->Company --> Google
     *      -->Job  --> QA Automation Engineer
     *      -->Website --> www.google.com
     *      -->Location --> Istanbul
     *      -->Skills --> Java,Selenium, TestNG
     *      click save changes button
     *      verify that "profile updated" appears
     */

    @Test
    public void editProfileTest(){

        LoginPage loginPage=new LoginPage();
        DashboardPage dashboardPage=new DashboardPage();
        UserProfilePage userProfilePage=new UserProfilePage();
        EditProfilePage editProfilePage = new EditProfilePage();

        driver.get(ConfigurationReader.get("url"));
        loginPage.login("jack@gmail.com","Jack12345");
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibility(dashboardPage.userAccountName,5);

        dashboardPage.navigateToModule("jack","My Profile");
        userProfilePage.navigateToOverviewMenu("Edit Profile");
        BrowserUtils.waitFor(1);

        editProfilePage.aboutInputBox.clear();
        editProfilePage.aboutInputBox.sendKeys("SDET programme , graduated from KraftTech");
        BrowserUtils.waitFor(1);

        editProfilePage.companyInputBox.clear();
        editProfilePage.companyInputBox.sendKeys("Google");
        BrowserUtils.waitFor(1);

      /** Select select = new Select(editProfilePage.jobInputBox);
        select.selectByVisibleText("QA Automation Engineer");
    */
        editProfilePage.selectJob("QA Automation Engineer");
        BrowserUtils.waitFor(1);

        editProfilePage.websiteInputBox.clear();
        editProfilePage.websiteInputBox.sendKeys("www.google.com");
        BrowserUtils.waitFor(1);

        editProfilePage.locationInputBox.clear();
        editProfilePage.locationInputBox.sendKeys("Istanbul");
        BrowserUtils.waitFor(1);

        editProfilePage.skillsInputBox.clear();
        editProfilePage.skillsInputBox.sendKeys("Java,Selenium, TestNG");
        BrowserUtils.waitFor(1);
        WebElement saveChangeButton = editProfilePage.saveChangeButton;
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);"
                + "arguments[0].click()",saveChangeButton);

        BrowserUtils.waitFor(1);



        String expectedMessage="Profile Updated";
       // String  actualMessage = userProfilePage.updateMessage.getText();
        String actualMessage = userProfilePage.updateMessageGetText();

        Assert.assertEquals(actualMessage,expectedMessage);

        /**
         * add education
         * add experience homeWork
         */
    }

}
