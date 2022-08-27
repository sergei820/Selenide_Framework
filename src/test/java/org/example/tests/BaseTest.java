package org.example.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.example.browserfactory.BrowserFactory;
import org.example.enums.BrowserEnum;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.example.browserfactory.SaucelabsDriverFactory.getSaucelabsDriver;


public class BaseTest {

    @BeforeSuite
    public void setUp() {
        String browser = System.getProperty("browser");

        //LOCAL DRIVER
        //WebDriverRunner.setWebDriver(BrowserFactory.getLocalInstance(BrowserEnum.valueOf(browser)).getDriver());

        //SAUCELABS DRIVER
        WebDriverRunner.setWebDriver(getSaucelabsDriver(BrowserEnum.valueOf(browser)));
    }

    @AfterSuite
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }


    //WebDriverRunner.setWebDriver(getBrowser(BrowserEnum.valueOf(browser)));
    //WebDriverRunner.setWebDriver(getBrowser(BrowserEnum.CHROME));
}