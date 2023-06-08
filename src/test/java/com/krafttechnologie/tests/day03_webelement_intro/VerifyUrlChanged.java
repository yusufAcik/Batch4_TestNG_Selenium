package com.krafttechnologie.tests.day03_webelement_intro;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class VerifyUrlChanged {

    public static void main(String[] args) throws InterruptedException {

        /*
        Class Task 2
        open chrome browser
        go to https: // www.krafttechexlab.com/login page
         enter email as
         * enter password as
         * click login button
         * verify that url has changed

         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        Thread.sleep(3000);



    }
}
