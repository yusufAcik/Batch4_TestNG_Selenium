package com.krafttechnologie.tests.day09_findElements_dropDowns;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownWithoutSelectTag {

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
    public void test_getOneOptionsWithFindElement(){
        // locate the "Select Title" web element
        // click on it
        // click on 'Mrs.'

        WebElement dropDownMenu = driver.findElement(By.xpath("//div[text()='Select Title']"));
        dropDownMenu.click();
        WebElement optionInDropDown = driver.findElement(By.cssSelector("#react-select-3-option-0-2"));
        optionInDropDown.click();

        // locate new Mrs. webElement
        WebElement targetElement = driver.findElement(By.xpath("(//div[@class=\" css-1hwfws3\"])[2]"));
        // verification
        String actual = targetElement.getText();
        String expected = "Mrs.";
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void test_getAllOptionsWithFindElements() throws InterruptedException {
        // locate the "Select Title" web element
        // click on it
        // get all options with findElements()
        WebElement dropDownMenu = driver.findElement(By.xpath("//div[text()='Select Title']"));
        dropDownMenu.click();
        //add elements in list
        List<WebElement> elements = driver.findElements(By.cssSelector("div[id*='option']"));

        System.out.println("elements.size() = " + elements.size());

        // verification
        Assert.assertTrue(elements.size()==6);
        Thread.sleep(3000);
        // click on other
        elements.get(5).click();
    }

}
