package com.krafttechnologie.pages;

import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css ="#email")
    public WebElement emailInputBox;

    @FindBy(css="#yourPassword")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'incorrect')]")
    public WebElement passwordErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Email')]")
    public WebElement usernameErrorMessage;
}
