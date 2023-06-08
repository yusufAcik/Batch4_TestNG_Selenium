package com.krafttechnologie.tests.day03_webelement_intro;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlChanged {

    public static void main(String[] args) throws InterruptedException {

        /*
        Class Task 2
        open chrome browser
        go to https: // www.krafttechexlab.com/login page
         enter email as eddiem
         * enter password as
         * click login button
         * verify that url has changed

         */
        String email = "mike@gmail.com";
        String password = "mike1234";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        WebElement emailInputBox = driver.findElement(By.id("email"));
        emailInputBox.sendKeys(email);

        WebElement passWordInputBox = driver.findElement(By.id("yourPassword"));
        passWordInputBox.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        loginButton.click();

      //  Thread.sleep(2000); hata alırsak bunu kullanırız

        String expectedURL = "https://www.krafttechexlab.com/index";
        String actualURL = driver.getCurrentUrl();
        System.out.println("expectedURL = " + expectedURL);
        System.out.println("actualURL = " + actualURL);

        if(expectedURL.equals(actualURL)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }


        Thread.sleep(3000);
        driver.close();



    }
}
