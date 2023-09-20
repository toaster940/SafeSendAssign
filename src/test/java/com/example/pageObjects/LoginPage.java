package com.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    @FindBy(css = "#txtUsername")
    private WebElement usernameTextField;
    @FindBy(css = "#txtPassword")
    private WebElement passwordTextField;
    @FindBy(css = "#btnLogin")
    private WebElement loginButton;

    public WebElement getLoginButton() {
        loginButton.isDisplayed();
        loginButton.isEnabled();
        return loginButton;
    }

    public WebElement getPasswordTextField() {
        passwordTextField.isDisplayed();
        passwordTextField.isEnabled();
        return passwordTextField;
    }

    public WebElement getUsernameTextField() {
        usernameTextField.isDisplayed();
        usernameTextField.isEnabled();
        return usernameTextField;
    }

}
