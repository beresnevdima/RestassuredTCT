package org.example.RestassuredTCT.DB.ExampleMono;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;
    private static ConfigReader configReader;

    private ConfigReader() {
        BufferedReader reader;
        String propertyFilePath = "configs//application.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("application.properties not found at " + propertyFilePath);
        }
    }

    public static ConfigReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public String getDBUserNameDragon() {
        String dbUsernameDragon = properties.getProperty("dragon.sandbox.username");
        if (dbUsernameDragon != null) return dbUsernameDragon;
        else throw new RuntimeException("DB_USERNAME_DRAGON not specified in the Configuration.properties file.");
    }

    public String getDBPasswordDragon() {
        String dbPasswordDragon = properties.getProperty("dragon.sandbox.password");
        if (dbPasswordDragon != null) return dbPasswordDragon;
        else throw new RuntimeException("DB_PASSWORD_DRAGON not specified in the Configuration.properties file.");
    }

    public String getDBUrlDragon() {
        String dbUrlDragon = properties.getProperty("dragon.sandbox.jdbcUrl");
        if (dbUrlDragon != null) return dbUrlDragon;
        else throw new RuntimeException("DB_URL_DRAGON not specified in the Configuration.properties file.");
    }
}