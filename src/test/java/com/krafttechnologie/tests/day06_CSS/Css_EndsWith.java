package com.krafttechnologie.tests.day06_CSS;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_EndsWith {

    public static void main(String[] args) throws InterruptedException {

        //go to https://www.krafttechexlab.com/login

        //locate the rememberMe web element with ends-with by using css syntax
        //get the text and display

        //locate the designedByAfm web element with ends-with by using css syntax
        //get the text and display

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        WebElement rememberMe = driver.findElement(By.cssSelector("label[for$='Me']"));
        System.out.println(rememberMe.getText());

        Thread.sleep(2000);

        WebElement designedByAfm = driver.findElement(By.cssSelector("[class$='s']"));
        System.out.println(designedByAfm.getText());
        Thread.sleep(2000);
        driver.quit();

    }
}
