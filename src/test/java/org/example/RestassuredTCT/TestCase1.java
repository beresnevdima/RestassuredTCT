package org.example.RestassuredTCT;

import org.example.RestassuredTCT.DB.WorksWithDBDragon;
import org.testng.annotations.Test;

public class TestCase1 {

    @Test
    public void case1() {

        WorksWithDBDragon dragonDB = new WorksWithDBDragon();
        dragonDB.selectProcessState();

        }
}
