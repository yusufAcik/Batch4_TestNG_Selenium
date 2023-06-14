package com.krafttechnologie.tests.day04_basic_locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkText {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        WebElement example1 = driver.findElement(By.linkText("Example 1: Element on page that is hidden"));
        example1.click();

        String actualText = driver.findElement(By.tagName("h3")).getText();
        String expectedText = "Dynamically Loaded Page Elements";

        if (expectedText.equals(actualText)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }

        driver.navigate().back();

        driver.findElement(By.partialLinkText("fact")).click();
        String actualText1 = driver.findElement(By.tagName("h4")).getText();
        String expectedText1 ="Example 1: Element on page that is hidden";
        if (expectedText1.equals(actualText1)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }

    }
}
