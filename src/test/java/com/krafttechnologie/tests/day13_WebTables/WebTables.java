package com.krafttechnologie.tests.day13_WebTables;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void printTable(){
        // print all table
        WebElement table = driver.findElement(By.xpath("//table[@id='t01']"));
        System.out.println("table.getText() = " + table.getText());

    }

    @Test
    public void getAllHeaders(){
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='t01']//th"));
        // number of columns
        System.out.println("elements.size() = " + elements.size());
        // print all elements
        for (WebElement element : elements) {
            System.out.println("element.getText() = " + element.getText());
        }
    }

    @Test
    public void printTableSize(){
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='t01']//tr"));
        System.out.println("allRowsWithHeader.size() = " + allRowsWithHeader.size());

        //number of rows without header
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
        System.out.println("allRowsWithoutHeader.size() = " + allRowsWithoutHeader.size());

        }
        @Test
    public void getRow(){
        //print second row
            WebElement row2 = driver.findElement(By.xpath("(//table[@id='t01']//td/..)[2]"));
            //WebElement row2 = driver.findElement(By.xpath("(//table[@id='t01']//tr)[3]"));
            System.out.println("row2.getText() = " + row2.getText());

            // get all row dynamically and print them one by onw (without header)
            List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='t01']//td/.."));
            for (WebElement webElement : allRowsWithoutHeader) {
                System.out.println("webElement.getText() = " + webElement.getText());
            }

            System.out.println("---");
            // get all row dynamically and print them one by onw (without header) with for index
            for (int i = 1; i <= allRowsWithoutHeader.size() ; i++) {
                WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td/..)["+i+"]"));
                System.out.println("element.getText() = " + element.getText());

            }
        }

        @Test
        public void getAllCellOfFirstRow(){
        // get all cell of first row
            List<WebElement> allCellsInOneRow = driver.findElements(By.xpath("(//table[@id='t01']//td/..)[1]/td"));
            for (WebElement element : allCellsInOneRow) {
                System.out.println("element.getText() = " + element.getText());
            }
        }
        @Test
    public void getSingleCellInOneRow(){
        // get the third cell of first row
            WebElement element = driver.findElement(By.xpath("(//table[@id='t01']//td)[3]"));
            System.out.println("element.getText() = " + element.getText());
        }
}
