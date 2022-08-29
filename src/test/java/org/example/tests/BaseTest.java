package org.example.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.example.enums.BrowserEnum;
import org.example.listeners.AllureListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static org.example.browserfactory.DriverFactory.getDriverInstance;
import static org.example.utils.PropertiesLoader.initializePropertiesInstance;
import static org.example.utils.PropertiesLoader.setPropertiesInstance;

@Listeners({AllureListener.class})
public class BaseTest {

    @BeforeSuite
    public void setUp() {
        setPropertiesInstance(initializePropertiesInstance());
        String browser = System.getProperty("browser");

        WebDriverRunner.setWebDriver(getDriverInstance(BrowserEnum.valueOf(browser)));
    }

    @AfterSuite
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
        setPropertiesInstance(null);
    }
}