package com.krafttechnologie.tests.day09_findElements_dropDowns;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownWithSelectTag {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test_getOptions(){
        // Old Style Select Menu
        // go to https://demoqa.com/select-menu
        // get all options(web elements) as a list
        // verify that the number of webElements is 11
        WebElement dropDownMenu = driver.findElement(By.cssSelector("#oldSelectMenu"));
        Select select = new Select(dropDownMenu);

        List<WebElement> options = select.getOptions();

        System.out.println("options.size() = " + options.size());

        // verify the size of the list
        Assert.assertTrue(options.size()==11);
    }

    @Test
    public void test_selectByVisibleText(){
        // Old Style Select Menu
        // get the blue thru visible text option and make verification

        WebElement dropDownMenu = driver.findElement(By.cssSelector("#oldSelectMenu"));
        Select select = new Select(dropDownMenu);

        // select the blue option with visible text
        select.selectByVisibleText("Blue");

        // verify the visible text is "Blue"
        WebElement selectedElement = select.getFirstSelectedOption();
        String actual = selectedElement.getText();
        String expected ="Blue";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test_selectByIndexNumber(){
        // Old Style Select Menu
        // get the green option thru visible index number and make verification
        WebElement dropDownMenu = driver.findElement(By.cssSelector("#oldSelectMenu"));
        Select select = new Select(dropDownMenu);

        select.selectByIndex(2);
        WebElement selectedElement = select.getFirstSelectedOption();
        // verify that the text is Green
        String actual = selectedElement.getText();
        String expected = "Green";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void test_selectByValueAttribute(){
        // Old Style Select Menu
        // get the voilet thru value option and make verification
        WebElement dropDownMenu = driver.findElement(By.cssSelector("#oldSelectMenu"));
        Select select = new Select(dropDownMenu);

        select.selectByValue("7");
        WebElement selectedElement = select.getFirstSelectedOption();

        // verification
        String actual = selectedElement.getText();
        String expected = "Voilet";
        Assert.assertEquals(actual,expected);
    }
}
