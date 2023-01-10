package org.example.RestassuredTCT;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.RestassuredTCT.DB.WorksWithDBDragon;
import org.testng.annotations.Test;

public class TestCase1 {

    @Test(description = "Онлайнизация вне льготного периода, начисление процентов")
    @Description("Онлайнизация - не досчитывать проценты за сегодня, если предыдущий день D, погашение вчера")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Детали кредита с онлайнизацией")
    public void case1() {

        WorksWithDBDragon dragonDB = new WorksWithDBDragon();
        dragonDB.selectProcessState();

        }
}
