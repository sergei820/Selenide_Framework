package org.example.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.example.enums.BrowserEnum;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.example.browserfactory.BrowserFactory.getLocalBrowser;
import static org.example.browserfactory.BrowserFactory.getSaucelabsDriver;


public class BaseTest {

    @BeforeSuite
    public void setUp() {
        String browser = System.getProperty("browser");

        //LOCAL DRIVER
        //WebDriverRunner.setWebDriver(getLocalBrowser(BrowserEnum.valueOf(browser)));

        //SAUCELABS DRIVER
        WebDriverRunner.setWebDriver(getSaucelabsDriver(BrowserEnum.valueOf(browser)));
    }

    @AfterSuite
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }


}