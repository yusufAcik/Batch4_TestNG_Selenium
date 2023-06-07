package com.krafttechnologie.tests.day01_automationintro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    public static void main(String[] args) {
        // make selenium ready to talk with Chrome
        WebDriverManager.chromedriver().setup();

        // create a driver object
        // driver --> represent an empty browser
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.krafttechnologie.com");

        // maximize window
        driver.manage().window().maximize();

        // how to get title
        System.out.println(driver.getTitle());

        String actualTitle = driver.getTitle();
        String expectedTitle = "Kraft Technologie | Yazılım ve Bilişim Eğitimleri – Uzaktan Canlı Eğitim";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        //

    }
}
