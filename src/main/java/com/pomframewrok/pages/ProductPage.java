package com.pomframewrok.pages;

import com.pomframewrok.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(className = "app_logo")
    WebElement logo;



    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @Step("Checking if logo is displayed")
    public boolean checkLogoDisplayed() {
        return isDisplayed(logo);
    }

}
