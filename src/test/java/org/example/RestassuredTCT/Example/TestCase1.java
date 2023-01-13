package org.example.RestassuredTCT.Example;

import org.example.RestassuredTCT.DB.ExampleMono.WorksWithDBDragon;
import org.testng.annotations.Test;

public class TestCase1 {

    @Test
    public void case1() {

        WorksWithDBDragon dragonDB = new WorksWithDBDragon();
        dragonDB.selectProcessState();

        }
}
