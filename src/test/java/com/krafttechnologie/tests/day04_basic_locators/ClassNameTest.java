package com.krafttechnologie.tests.day04_basic_locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClassNameTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/");
        System.out.println(driver.findElement(By.className("pagetitle")).getText());

        System.out.println(driver.findElement(By.className("footer")).getText());
        //System.out.println(driver.findElement(By.className("header fixed-top d-flex align-items-center")).getText());
        // aralarda boşluk olduğu için hata verir
        Thread.sleep(2000);
        driver.close();

    }
}
