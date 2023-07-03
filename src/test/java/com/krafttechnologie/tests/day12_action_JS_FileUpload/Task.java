package com.krafttechnologie.tests.day12_action_JS_FileUpload;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task {
    /**  Hover class Task
     *      go to https://the-internet.herokuapp.com/hovers url
     *      and get "view profile" elements' text (all of them)
     *      and verify element is displayed (one by one)
     *
     *      hind: Use list and for loop
     */

    WebDriver driver;
    Actions actions;



    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void hoverTaskTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement image2 = driver.findElement(By.xpath("(//img)[2]"));
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        action.moveToElement(image2).perform();

        WebElement viewProfile = driver.findElement(By.linkText("View profile"));
        System.out.println("viewProfile.getText() = " + viewProfile.getText());
        Assert.assertTrue(viewProfile.isDisplayed(),"verify that element is displayed");


    }

    @Test
    public void test1() throws InterruptedException {
        for (int i = 2; i < 5; i++) {
            driver.get("https://the-internet.herokuapp.com/hovers");
            WebElement image = driver.findElement(By.xpath("(//img)["+i+"]"));
            Actions action = new Actions(driver);
            Thread.sleep(2000);
            action.moveToElement(image).perform();

            WebElement viewProfile = driver.findElement(By.linkText("View profile"));
            System.out.println("viewProfile.getText() = " + viewProfile.getText());
            Assert.assertTrue(viewProfile.isDisplayed(),"verify that element is displayed");

        }
    }



}
