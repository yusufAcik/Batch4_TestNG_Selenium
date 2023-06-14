package com.krafttechnologie.tests.day04_basic_locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homework2 {
    public static void main(String[] args) {

        /** Class Task
         *  go to the amazon webpage
         *  write "selenium" to search box
         *  verify that the result of the search
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("selenium");
        driver.findElement(By.id("nav-search-submit-button")).click();

        String actualResult = driver.findElement(By.cssSelector(".a-color-state.a-text-bold")).getText();
        System.out.println(actualResult);
        String expectedResult = "\"selenium\"";

        if(actualResult.equals(expectedResult)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }

        driver.quit();
    }
}
