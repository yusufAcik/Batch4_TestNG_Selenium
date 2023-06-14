package com.krafttechnologie.tests.day05_xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXpath5 {

    public static void main(String[] args) throws InterruptedException {

        //go to "https://www.krafttechexlab.com/forms/input"

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/input");
        Thread.sleep(2000);

        // get the text webelement with the following features
        // 1. parent to child --> xpath/xpath

        WebElement home = driver.findElement(By.xpath("//div[@class='row mb-3'][1]/label"));
        System.out.println(home.getText());


        // 2. child to parent

        WebElement home1 = driver.findElement(By.xpath("(//input[@type='text'])[1]/../../label"));
       System.out.println(home1.getText());

         WebElement home2 = driver.findElement(By.xpath("(//div[@class='col-sm-10'])[1]/preceding-sibling::*"));
         System.out.println(home2.getText());

         // from parent to grandson

        WebElement home4 = driver.findElement(By.xpath("(//form[@method='post']//label)[1]"));
        System.out.println(home4.getText());

        driver.quit();

    }
}
