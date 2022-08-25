package org.example.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeTest;

import static org.example.browserfactory.BrowserFactory.getBrowser;

public class BaseTest {

    @BeforeTest
    public void setUp() {
        WebDriverRunner.setWebDriver(getBrowser("firefox"));
        //WebDriverManager driverManager = new ChromeDriverManager();
        //WebDriverRunner.setWebDriver(driverManager);
    }
}
