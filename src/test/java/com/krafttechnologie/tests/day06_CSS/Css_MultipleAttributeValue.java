package com.krafttechnologie.tests.day06_CSS;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css_MultipleAttributeValue {

    public static void main(String[] args) throws InterruptedException {

        // There is OR logic with xpath
        // there is only and logic with css

        //go to https://www.krafttechexlab.com/forms/input

        //locate the Read Only/Disabled web element with multiple attribute-value by using css syntax
        //get the text and display

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/input");
        Thread.sleep(2000);

        //[att1='value1'][att2='val2']

        WebElement readonly = driver.findElement(By.cssSelector("input[type='text'][value='Read only / Disabled']"));
        // System.out.println(readonly.getText()); getText() çalışmış ama bize boş string döndürdü
        System.out.println(readonly.getAttribute("value"));

        WebElement readonly1 = driver.findElement(By.cssSelector("[type='text'][value='Read only / Disabled']"));
        System.out.println(readonly1.getAttribute("value"));

        driver.quit();


    }
}
