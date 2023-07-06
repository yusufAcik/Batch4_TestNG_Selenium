package com.krafttechnologie.tests.day14_properties_singleton;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {


    @Test
    public void test1(){
        WebDriver driver1= WebDriverFactory.getDriver("chrome");
        driver1.get("https://www.amazon.com/");
        WebDriver driver2 = WebDriverFactory.getDriver("chrome");
      //  driver2.findElement(By.cssSelector("#twotabsearchtextbox"));
    }
    @Test
    public void test2(){

       // Singleton singleton = new Singleton();
        // burada obje oluşmaz constructor private

        String s1= Singleton.getInstance();
        String s2= Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);


    }
}
