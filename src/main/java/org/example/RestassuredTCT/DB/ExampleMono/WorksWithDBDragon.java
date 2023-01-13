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

        Map<String, Object> state = db.readRow("select * from un62.process_state");
        return state;
    }
}