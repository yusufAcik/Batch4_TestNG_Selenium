package com.krafttechnologie.tests.day10_alerts_multiplewindows_iframe;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HTMLPopUps {

    @Test
    public void htmlPopUpTest() throws InterruptedException {
        // go to http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437
        // tap on conffirm button
        // tap on yes
        // make verification

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");
        WebElement confirmButton = driver.findElement(By.xpath("(//span[text()='Confirm'])[1]"));
        confirmButton.click();
        Thread.sleep(2000);

        WebElement yesButton = driver.findElement(By.xpath("//span[.='Yes']"));
        yesButton.click();
        Thread.sleep(500);
       String actual = driver.findElement(By.xpath("//p[.='You have accepted']")).getText();
       String expected = "You have accepted";
        Assert.assertEquals(actual,expected);
        driver.quit();


    }

}
