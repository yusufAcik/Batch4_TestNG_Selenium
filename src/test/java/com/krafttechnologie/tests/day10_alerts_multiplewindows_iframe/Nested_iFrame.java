package com.krafttechnologie.tests.day10_alerts_multiplewindows_iframe;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Nested_iFrame {
    WebDriver driver;

   // https://the-internet.herokuapp.com/nested_frames

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
       // driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
    @Test
    public void nestedIframe(){

        // switch to middle frame and get the MIDDLE text

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println("driver.findElement(By.cssSelector(\"#content\")).getText() = " + driver.findElement(By.cssSelector("#content")).getText());

        // right a gidelim

        driver.switchTo().parentFrame(); // üst frame e gitti
        driver.switchTo().defaultContent(); // en üst frame e gider
        driver.switchTo().frame(2);
        System.out.println("driver.findElement(By.tagName(\"//body\")).getText() = " + driver.findElement(By.tagName("//body")).getText());
        // bu frame de bir tane body var

      //  driver.switchTo().defaultContent(); // en üst frame e gider
       // driver.switchTo().frame("frame-top");
        //driver.switchTo().frame(2);

        // bottom a gidelim
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
       //or -> driver.switchTo().frame("frame-bottom");





    }

}
