package org.example.RestassuredTCT.DB.ExampleMono;

import org.example.RestassuredTCT.DB.ExampleMono.ConfigReader;
import org.example.RestassuredTCT.DB.ExampleMono.DbUtils;

import java.util.Map;

public class WorksWithDBDragon {

    DbUtils db;

    public WorksWithDBDragon() {
        db = new DbUtils(Map.of(
                "username", ConfigReader.getInstance().getDBUserNameDragon(),
                "password", ConfigReader.getInstance().getDBPasswordDragon(),
                "url", ConfigReader.getInstance().getDBUrlDragon(),
                "driverClassName", "org.postgresql.Driver"));
    }

    public Map<String, Object> selectProcessState(){

        Map<String, Object> state = db.readRow("SELECT state FROM un62.interest_charges_v2 WHERE acc='21100200025461' AND date_calc='2022-09-01'");
        return state;
    }
}