package org.example.RestassuredTCT.DB;

import java.util.Properties;

public class ConfigReader {

    private Properties properties;
    private static ConfigReader configReader;

    public static ConfigReader getInstance() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public String getDBUserNameDRAGON() {
        String dbUsernameDragon = properties.getProperty("dragon.sandbox.username");
        if (dbUsernameDragon != null) return dbUsernameDragon;
        else throw new RuntimeException("DB_USERNAME_DRAGON not specified in the Configuration.properties file.");
    }

    public String getDBPasswordDRAGON() {
        String dbPasswordDragon = properties.getProperty("dragon.sandbox.password");
        if (dbPasswordDragon != null) return dbPasswordDragon;
        else throw new RuntimeException("DB_PASSWORD_DRAGON not specified in the Configuration.properties file.");
    }

    public String getDBURLDRAGON() {
        String dbUrlDragon = properties.getProperty("dragon.sandbox.jdbcUrl");
        if (dbUrlDragon != null) return dbUrlDragon;
        else throw new RuntimeException("DB_URL_DRAGON not specified in the Configuration.properties file.");
    }
}