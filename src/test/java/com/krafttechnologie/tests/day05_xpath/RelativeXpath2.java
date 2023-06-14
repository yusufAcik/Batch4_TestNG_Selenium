package com.krafttechnologie.tests.day05_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath2 {

    public static void main(String[] args) {

        //go to https://www.krafttechexlab.com/forms/input


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/input");
        driver.manage().window().maximize();

        WebElement passWord = driver.findElement(By.xpath("//label[starts-with(@for,'inputP')]"));
        System.out.println(passWord.getText());

        WebElement passWord1 = driver.findElement(By.xpath("//label[starts-with(text(),'P')]"));
        System.out.println(passWord1.getText());

        driver.quit();


    }
}
