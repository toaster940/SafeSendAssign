package com.example.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonUtils {

    private WebDriver driver;
    public CommonUtils(WebDriver driver){
        this.driver = driver;
    }

    public void mouseHoverOnElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void leftMouseClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.click(element).build().perform();
    }
}
