package org.example.RestassuredTCT.DB;

import org.testng.annotations.Test;

import java.util.Map;

public class WorksWithDBDragon {

    DbUtils db;

    public WorksWithDBDragon() {
        db = new DbUtils(Map.of(
                "username", ConfigReader.getInstance().getDBUserNameDRAGON(),
                "password", ConfigReader.getInstance().getDBPasswordDRAGON(),
                "url", ConfigReader.getInstance().getDBURLDRAGON(),
                "driverClassName", "org.postgresql.Driver"));
    }
@Test
    public Map<String, Object> getStateInterest(String acc, String date){

        Map<String, Object> state = db.readRow("select * from un62.process_state");
        return state;
    }
}