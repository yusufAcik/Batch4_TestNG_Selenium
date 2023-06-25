package com.krafttechnologie.tests.day10_alerts_multiplewindows_iframe;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSPopUps {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void jsPopUp_Accept() throws InterruptedException {
        WebElement clickForJsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickForJsAlert.click();

        Thread.sleep(2000);

        //create alert object
        Alert alert=driver.switchTo().alert();
        alert.accept();

        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You successfully clicked an alert";
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void JsPopUp_DisMis() throws InterruptedException {
        WebElement clickForJsConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickForJsConfirm.click();
        Thread.sleep(2000);

        // create an alert object
        Alert alert = driver.switchTo().alert();
        //tap on cancel button
        alert.dismiss();

        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You clicked: Cancel";
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void jsPopUpSendKeys() throws InterruptedException {
        WebElement clickJsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickJsPrompt.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();

        String text = "Ali";
        alert.sendKeys(text);
        Thread.sleep(2000);
        alert.accept();
        String actual = driver.findElement(By.cssSelector("#result")).getText();
        String expected = "You entered: "+text;
        Assert.assertEquals(actual,expected);




    }

}
