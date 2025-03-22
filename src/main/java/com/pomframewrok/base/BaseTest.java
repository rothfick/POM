package com.pomframewrok.base;


import com.pomframewrok.utils.AllureManager;
import com.pomframewrok.utils.ConfigReader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl;

    @BeforeSuite
    public void beforeSuite() {
        ConfigReader.initialize();
        AllureManager.setAllureEnvironmentInformation();
    }

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser", "chrome");


        driver = DriverFactory.getDriver(browser);
        baseUrl = ConfigReader.getProperty("baseUrl");
        driver.manage().window().maximize();
        navigateToBaseUrl();

    }
    @Step("Navigating to base URL: {baseUrl}")
    public void navigateToBaseUrl(){
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        if(testResult.getStatus() == ITestResult.FAILURE){
            AllureManager.takeScreenshot(driver);
        }

        if(driver != null){
            driver.quit();
        }
    }
}
