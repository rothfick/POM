package com.pomframewrok.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";
    private static Properties properties;

    private ConfigReader() {}

    public static void initialize() {
        if( properties == null ) {
            properties = new Properties();
            try(FileInputStream fis = new FileInputStream(CONFIG_FILE_PATH)) {
                properties.load(fis);
            }catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException("Failed to load config.properties file" + e.getMessage());
            }
        }
    }

    public static String getProperty(String key) {
        if( properties == null ) {
            initialize();
        }

        String value = properties.getProperty(key);
        if ( value == null ) {
            throw new RuntimeException(key + " not found in config.properties");
        }

        return value;
    }

    public static String getProperty(String key, String defaultValue) {
        if( properties == null ) {
            initialize();
        }

        return properties.getProperty(key, defaultValue);
    }
}
