package com.pomframewrok.base;

import com.pomframewrok.utils.ConfigReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        ConfigReader.initialize();


        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        PageFactory.initElements(driver, this);
    }

    @Step("Getting page title")
    public String getPageTitle(){
        return driver.getTitle();
    }

    @Step("Waiting for element to be clickable: {element}")
    protected WebElement waitForElementClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @Step("Waiting for element to be visible: {element}")
    protected WebElement waitForElementVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    @Step("Waiting for element to be present: {locator}")
    protected WebElement waitForElementPresent(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Step("Clicking on element: {element}")
    protected void click(WebElement element){
        waitForElementClickable(element).click();
    }

    @Step("Typing '{text}' into element: {element}")
    protected void sendKeys(WebElement element, String text){
        waitForElementVisible(element).clear();
        element.sendKeys(text);
    }

    @Step("Getting text from element: {element}")
    protected String getText(WebElement element){
        return waitForElementVisible(element).getText();
    }

    @Step("Checking if element is displayed: {element}")
    protected boolean isDisplayed(WebElement element){
        try{
            return element.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    @Step("Scrolling to element: {element}")
    protected void scrollToElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Step("Waiting for page to load completely")
    protected void waitForPageToLoad(){
        wait.until(driver -> ((JavascriptExecutor)driver)
                .executeScript("return document.readyState").equals("complete"));
    }
}
