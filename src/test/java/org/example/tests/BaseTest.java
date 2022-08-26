package org.example.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.example.enums.BrowserEnum;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.example.browserfactory.BrowserFactory.getBrowser;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        String browser = System.getProperty("browser");
        WebDriverRunner.setWebDriver(getBrowser(BrowserEnum.valueOf(browser)));
    }

    @AfterSuite
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
        //BrowserFactory.getDriver().quit();
    }
}
