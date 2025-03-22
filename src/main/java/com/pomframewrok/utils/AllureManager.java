package com.pomframewrok.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public class AllureManager {

    public static void setAllureEnvironmentInformation(){
        Map<String, String> environmentInfo = new HashMap<>();
        environmentInfo.put("Browser", ConfigReader.getProperty("browser"));
        environmentInfo.put("Browser.Version", "Latest");
        environmentInfo.put("URL", ConfigReader.getProperty("baseUrl"));
        environmentInfo.put("Environment", ConfigReader.getProperty("environment", "TEST"));

        addEnvironmentProperties(environmentInfo);
    }

    private static void addEnvironmentProperties(Map<String, String> environmentInfo){
        environmentInfo.forEach((k, v) -> {
            Allure.addAttachment(k, "text/plain", v);
        });
    }

    public static void takeScreenshot(WebDriver driver){
        if(driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(screenshot);
            attachScreenshotToAllure(screenshot);
        }
    }

    private static byte[] saveScreenshot(byte[] screenshot){
        return screenshot;
    }

    private static void attachScreenshotToAllure(byte[] screenshot){
        Allure.addAttachment("Screenshot", "image/png", new ByteArrayInputStream(screenshot), "png");
    }

}
