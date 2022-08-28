package org.example.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.example.enums.BrowserEnum;
import org.example.listeners.AllureListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import static org.example.browserfactory.BrowserFactory.getLocalBrowser;
import static org.example.browserfactory.BrowserFactory.getSaucelabsDriver;
import static org.example.utils.PropertiesLoader.initializePropertiesInstance;
import static org.example.utils.PropertiesLoader.setPropertiesInstance;

@Listeners({AllureListener.class})
public class BaseTest {

    @BeforeSuite
    public void setUp() {
        setPropertiesInstance(initializePropertiesInstance());
        String browser = System.getProperty("browser");
        //LOCAL DRIVER
        WebDriverRunner.setWebDriver(getLocalBrowser(BrowserEnum.valueOf(browser)));
        //SAUCELABS DRIVER
        //WebDriverRunner.setWebDriver(getSaucelabsDriver(BrowserEnum.valueOf(browser)));
    }

    @AfterSuite
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
        setPropertiesInstance(null);
    }
}