package org.example.RestassuredTCT.DB;

import java.util.Properties;

public class ConfigReader {

    protected Properties properties;
    protected static ConfigReader configReader;

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