package com.krafttechnologie.tests.day04_basic_locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homework3 {
    public static void main(String[] args) throws InterruptedException {

        /*
         * HW TASK 3
         * open chrome browser
         * go to https://demoqa.com/login
         * enter "test" into the username box
         * enter "Test.!123" into the password box
         * tap on login button
         * VERIFY that url is changed as "https://demoqa.com/profile"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://demoqa.com/login");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("Test.!123");
        Thread.sleep(2000);
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/profile";

        if(expectedUrl.equals(currentUrl)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }

        driver.quit();
    }
}
