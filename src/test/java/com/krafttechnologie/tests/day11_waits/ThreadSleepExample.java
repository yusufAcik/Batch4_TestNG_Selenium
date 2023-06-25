package com.krafttechnologie.tests.day11_waits;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {

    /**  HOME TASK
     https://the-internet.herokuapp.com/dynamic_loading
     Example 2: Element rendered after the fact -->click
     click that element
     verify that hello world is not displayed
     click start button
     verify that hello element is displayed
     and verify that "Hello World!" text is present
     */
    WebDriver driver;

    // https://the-internet.herokuapp.com/nested_frames

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        driver.findElement(By.partialLinkText("Example 2:")).click();
        Thread.sleep(2000);
        String hello = "Hello World!";
        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println("body.getText() = " + body.getText());

        Assert.assertFalse(body.getText().contains(hello));
        driver.findElement(By.cssSelector("#start>button")).click();
        Thread.sleep(6000);
        System.out.println("body.getText() = " + body.getText());

        //Assert.assertTrue(body.getText().contains(hello));

        // second way
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertTrue(helloWorld.isDisplayed());

    }


}
