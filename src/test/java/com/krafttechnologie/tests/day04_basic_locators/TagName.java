package com.krafttechnologie.tests.day04_basic_locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TagName {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        driver.findElement(By.name("email")).sendKeys("mike@gmail.com");
        Thread.sleep(2000);

        driver.findElement(By.name("password")).sendKeys("mike1234");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.tagName("h2")).getText());
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        driver.close();
    }
}
