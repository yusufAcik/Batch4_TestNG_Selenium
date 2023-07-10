package com.krafttechnologie.pages;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//li[@class='breadcrumb-item'][2]")
    public WebElement dashboardElement;

}
