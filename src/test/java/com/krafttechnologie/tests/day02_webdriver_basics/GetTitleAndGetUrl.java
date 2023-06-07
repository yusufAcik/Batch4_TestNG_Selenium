package com.krafttechnologie.tests.day02_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {

    public static void main(String[] args) {

        //TASK
        //Open chrome  and navigate to https://www.krafttechexlab.com/
        //get title and display

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.krafttechexlab.com/");
        System.out.println("driver.getTitle() = " + driver.getTitle());

        // getting url
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        // getting source code of page
        System.out.println("driver.getPageSource() = " + driver.getPageSource());



    }
}
