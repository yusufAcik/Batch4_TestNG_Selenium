package com.krafttechnologie.tests.day08_typeOfWebElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    @Test
    public void checkBoxDemoTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement sports = driver.findElement(By.cssSelector("input[id='hobbies-checkbox-1']"));
        WebElement reading = driver.findElement(By.cssSelector("input[id='hobbies-checkbox-2']"));
        WebElement music = driver.findElement(By.cssSelector("input[id='hobbies-checkbox-3']"));
        Assert.assertFalse(sports.isSelected());
        Assert.assertFalse(reading.isSelected());
        Assert.assertFalse(music.isSelected());
        Thread.sleep(2000);
        WebElement sportCheckBox = driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div[1]"));
        Thread.sleep(1000);

        sportCheckBox.click();
        //sports.click();
        Thread.sleep(1000);
        Assert.assertTrue(sports.isSelected());
        driver.quit();
        // görüntü ayarlarından dolayı test kalır

    }
}
