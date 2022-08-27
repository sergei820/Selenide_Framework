package org.example.tests;

import com.codeborne.selenide.WebDriverRunner;
import org.apache.hc.client5.http.impl.routing.BasicRouteDirector;
import org.example.browserfactory.BrowserFactory;
import org.example.enums.BrowserEnum;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    @BeforeSuite
    public void setUp() {
        String browser = System.getProperty("browser");
        WebDriverRunner.setWebDriver(BrowserFactory.getInstance(BrowserEnum.valueOf(browser)).getDriver());
        //WebDriverRunner.setWebDriver(getBrowser(BrowserEnum.valueOf(browser)));
        //WebDriverRunner.setWebDriver(getBrowser(BrowserEnum.CHROME));
    }

    @AfterSuite
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
        //BrowserFactory.getDriver().quit();
    }
}
