package com.krafttechnologie.tests.day06_CSS;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_Index {
    public static void main(String[] args) {

        // cssSyntax:nth-of-type(indexNumber)
        // ilgili elementler aynı parent altında ise çalışır
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");
        WebElement email = driver.findElement(By.cssSelector(".col-12:nth-of-type(1)"));
        WebElement password = driver.findElement(By.cssSelector(".col-12:nth-of-type(2)"));
        WebElement login = driver.findElement(By.cssSelector(".col-12:nth-of-type(4)"));


    }
}
