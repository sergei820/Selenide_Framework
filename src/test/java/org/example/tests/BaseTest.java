package org.example.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.example.browserfactory.DriverFactory;
import org.example.enums.BrowserEnum;
import org.example.listeners.AllureListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static org.example.utils.PropertiesLoader.initializePropertiesInstance;

@Listeners({AllureListener.class})
public class BaseTest {

    @BeforeSuite
    public void setUp() {
        initializePropertiesInstance();
        String browser = System.getProperty("browser");

        WebDriverRunner.setWebDriver(new DriverFactory().getDriverManager(BrowserEnum.valueOf(browser)).createDriver());
    }

    @AfterSuite
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }
}