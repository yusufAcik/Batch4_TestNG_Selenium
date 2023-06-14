package com.krafttechnologie.tests.day06_CSS;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_Attribute_Value {

    public static void main(String[] args) throws InterruptedException {

        //go to https://www.krafttechexlab.com/login
        //locate the email box with attribute-value by using css syntax
        //locate the password box with attribute-value by using css syntax


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);

        WebElement emailBox = driver.findElement(By.cssSelector("input[name='email']"));
        emailBox.sendKeys("test@test.com");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.cssSelector("[type='password']"));
        password.sendKeys("1234566");
        Thread.sleep(2000);
        driver.quit();




    }
}
