package org.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.example.enums.BrowserEnum;
import org.example.listeners.AllureListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.Listeners;

import static org.example.browserfactory.BrowserFactory.getLocalBrowser;
import static org.example.browserfactory.BrowserFactory.getSaucelabsDriver;

@Listeners({AllureListener.class})
public class BaseTest {

    @BeforeSuite
    public void setUp() {
        String browser = System.getProperty("browser");
        //LOCAL DRIVER
        WebDriverRunner.setWebDriver(getLocalBrowser(BrowserEnum.valueOf(browser)));
        //SAUCELABS DRIVER
        //WebDriverRunner.setWebDriver(getSaucelabsDriver(BrowserEnum.valueOf(browser)));

        //SELENIDE Settings
        //Configuration.reportsFolder = "test-result/reports";
        //ScreenShooter.captureSuccessfulTests = true;
    }

    @AfterSuite
    public void tearDown() {
        WebDriverRunner.getWebDriver().quit();
    }


}