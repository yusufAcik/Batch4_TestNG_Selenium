package com.krafttechnologie.tests.day17_pom3;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DashboardTest2 extends TestBase {


    @Test
    public void verifyList() {

        driver.get(ConfigurationReader.get("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login();

       // BrowserUtils.waitFor(2);
        // sayfa hızlı açıldığı için wait koymamımıza gerek yok

        DashboardPage dashboardPage = new DashboardPage();

        String expected = "Dashboard";
        String actual = dashboardPage.dashboardElement.getText();

        // first assertion
        Assert.assertEquals(actual, expected);

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Dashboard");
        expectedList.add("Developers");
        expectedList.add("Components");
        expectedList.add("Forms");
        expectedList.add("JavaScript");
        expectedList.add("jack");

        List<String> actualList = new ArrayList<>();

        for (WebElement menu:dashboardPage.upTitles) {
            System.out.println("menu.getText() = " + menu.getText());
            actualList.add(menu.getText());
        }

        Assert.assertEquals(actualList,expectedList);
    }
}
