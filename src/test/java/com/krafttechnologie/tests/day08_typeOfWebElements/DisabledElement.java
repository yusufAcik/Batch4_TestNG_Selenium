package com.krafttechnologie.tests.day08_typeOfWebElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElement {


    /**
    what is disabled element
    we can not interact with this element
    we can not click
    we can not write something
     */

    @Test
    public void disabledElementTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement disabledElement = driver.findElement(By.cssSelector("#input-example>input"));
        Assert.assertFalse(disabledElement.isEnabled(),"Verify that element is not enabled or element is disable");
        Thread.sleep(2000);
        WebElement enableBttn = driver.findElement(By.cssSelector("#input-example>button"));
        enableBttn.click();
        Thread.sleep(4000);

        Assert.assertTrue(disabledElement.isEnabled());
        driver.quit();
    }
}
