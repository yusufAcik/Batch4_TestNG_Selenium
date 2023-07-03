package com.krafttechnologie.tests.day12_action_JS_FileUpload;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest {
    WebDriver driver;
    Actions actions;



    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement image2 = driver.findElement(By.xpath("(//img)[2]"));

        // Actions --> class that contains all the user interactions
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        // moveToElement() --> move your mouse to web element (hover over)
        // perform() --> complete the action
        actions.moveToElement(image2).perform();
        WebElement view_profile1 = driver.findElement(By.linkText("View profile"));
        System.out.println("view_profile1.getText() = " + view_profile1.getText());
        Assert.assertTrue(view_profile1.isDisplayed(),"verify that element is displayed");
    }

    @Test
    public void dragAndDrop() {
        driver.get("https://demoqa.com/droppable");
        WebElement draggable = driver.findElement(By.id("draggable"));

        WebElement dropped = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        // Actions actions = new Actions(driver);

        actions.dragAndDrop(draggable,dropped).perform();

        WebElement verifyMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());

        Assert.assertTrue(verifyMessage.isDisplayed());
        Assert.assertEquals(verifyMessage.getText(),"Dropped!","Verify that element has dropped");


    }

    @Test
    public void dragAndDrop2() {
        driver.get("https://demoqa.com/droppable");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement dropped = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.moveToElement(draggable).clickAndHold().moveToElement(dropped).pause(3000).release().perform();
        WebElement verifyMessage = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        System.out.println("verifyMessage.getText() = " + verifyMessage.getText());

        Assert.assertTrue(verifyMessage.isDisplayed());
        Assert.assertEquals(verifyMessage.getText(),"Dropped!","Verify that element has dropped");



    }
}
