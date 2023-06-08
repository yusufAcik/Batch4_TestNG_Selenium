package com.krafttechnologie.tests.day03_webelement_intro;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUserNameIsCorrect {

    public static void main(String[] args) throws InterruptedException {

        /** Class Task 2
         * open chrome browser
         * go to https://www.krafttechexlab.com/login  page
         * enter email as
         * enter password as
         * click login button
         * verify that username is "mike"
         * verify that home page is "Dashboard"
         */

        String email = "mike@gmail.com";
        String password = "mike1234";
        String expectedProfilUserName="mike";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        // enter mail --> lazy way
        driver.findElement(By.id("email")).sendKeys(email);
        // enter password
        driver.findElement(By.id("yourPassword")).sendKeys(password);
        // click login button
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        // 2 ways to get text from web element
        // 1. getText() -> it will work %99 and it will return string
        // 2.getAttribute("") -> second way of getting text especially

        WebElement profilUserName = driver.findElement(By.cssSelector("[class=\"d-none d-md-block dropdown-toggle ps-2\"]"));

        String actualProfilUserName = profilUserName.getText();
        System.out.println("actualProfilUserName = " + actualProfilUserName);


        if(expectedProfilUserName.equals(actualProfilUserName)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
