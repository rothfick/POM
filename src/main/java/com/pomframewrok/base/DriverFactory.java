package com.pomframewrok.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    public static WebDriver getDriver(String browserType) {
        WebDriver driver;

        if(browserType == null || browserType.isEmpty()){
            browserType = "chrome";
        }
        
        switch(browserType.toLowerCase()) {
            case "chrome":
                logger.info("Initializing Chrome Driver");
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                configureCommonOptions(options);
                driver = new ChromeDriver(options);
                break; 
            case "firefox":
                logger.info("Initializing Firefox Driver");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                logger.info("Initializing Edge Driver");
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                configureCommonOptions(edgeOptions);
                driver = new EdgeDriver(edgeOptions);
                break;
                default: System.out.println("Unknown browser type: " + browserType);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

        }
        return driver;
    }

    private static void configureCommonOptions(Object options) {
        if (options instanceof ChromeOptions) {
            ChromeOptions chromeOptions = (ChromeOptions) options;
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--start-maximized");
        } else if (options instanceof  EdgeOptions ) {
            EdgeOptions edgeOptions = (EdgeOptions) options;
            edgeOptions.addArguments("--disable-notifications");
            edgeOptions.addArguments("--start-maximized");
        }
    }
}
