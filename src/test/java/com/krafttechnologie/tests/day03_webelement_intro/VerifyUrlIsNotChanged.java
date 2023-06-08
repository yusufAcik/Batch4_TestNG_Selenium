package com.krafttechnologie.tests.day03_webelement_intro;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyUrlIsNotChanged {

    public static void main(String[] args) throws InterruptedException {

        /**
         * Class Task
         * open chrome browser
         * go to page
         * click on login button
         * verify that url is not changed
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        String expectedURL = driver.getCurrentUrl();
        System.out.println("expectedURL = " + expectedURL);

        WebElement loginBtn =driver.findElement(By.cssSelector("[type=\"submit\"]"));
        loginBtn.click();

        String actualURL = driver.getCurrentUrl();
        System.out.println("actualURL = " + actualURL);

        if(expectedURL.equals(actualURL)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }


        Thread.sleep(5000);
        driver.close();
    }
}
