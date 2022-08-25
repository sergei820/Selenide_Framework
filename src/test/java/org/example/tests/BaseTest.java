package org.example.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void setUp() {
        //WebDriverManager driverManager = new ChromeDriverManager();
        //WebDriverRunner.setWebDriver(driverManager);
    }
}
