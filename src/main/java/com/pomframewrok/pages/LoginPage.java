package com.pomframewrok.pages;

import com.pomframewrok.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="user-name")
    private WebElement usernameInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(id="login-button")
    private WebElement loginButton;

    @FindBy(css="h3[data-test='error']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @Step("Entering username: {username}")
    public LoginPage enterUsername(String username){
        sendKeys(usernameInput, username);
        return this;
    }

    @Step("Entering password")
    public LoginPage enterPassword(String password){
        sendKeys(passwordInput, password);
        return this;
    }

    @Step("Clicking login button")
    public LoginPage clickLoginButton(){
        click(loginButton);
        return this;
    }

    @Step("Logging in with username: {username}")
    public LoginPage login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        return clickLoginButton();
    }

    @Step("Getting error message")
    public String getErrorMessage(){
        return  isDisplayed(errorMessage) ? errorMessage.getText() : null;
    }

    @Step("Checking if error message is displayed")
    public boolean isErrorMessageDisplayed(){
        return isDisplayed(errorMessage);
    }
}
