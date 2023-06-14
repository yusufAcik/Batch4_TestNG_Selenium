package com.krafttechnologie.tests.day04_basic_locators;

import com.github.javafaker.Faker;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTests {

    public static void main(String[] args) throws InterruptedException {

        Faker faker = new Faker();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        WebElement inputUserName = driver.findElement(By.id("userName"));
       // inputUserName.sendKeys("Jake Hyde");
        inputUserName.sendKeys(faker.lordOfTheRings().character());

        WebElement inputUserEmail = driver.findElement(By.id("userEmail"));
       // inputUserEmail.sendKeys("jake@hyde.com");
        inputUserEmail.sendKeys(faker.internet().emailAddress());
        Thread.sleep(2000);
        driver.close();
    }
}
