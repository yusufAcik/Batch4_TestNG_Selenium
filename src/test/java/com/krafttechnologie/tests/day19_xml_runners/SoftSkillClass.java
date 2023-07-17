package com.krafttechnologie.tests.day19_xml_runners;

import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SoftSkillClass {

    // bir sayfadaki bütün linklerin görünür textlerinin alınması

   @Test
    public void findAllLinks(){
       Driver.get().get(ConfigurationReader.get("url"));
       List<WebElement> allLinks = Driver.get().findElements(By.tagName("a"));
       for (WebElement allLink : allLinks) {
           System.out.println(allLink.getAttribute("a"));
       }
   }

}
