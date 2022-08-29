package org.example.browserfactory.browsers;

import org.example.browserfactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirefoxSaucelabsDriverManager extends DriverManager {

    public static WebDriver createDriver() {
        FirefoxOptions firefixBrowserOptions = new FirefoxOptions();
        firefixBrowserOptions.setPlatformName("Windows 10");
        firefixBrowserOptions.setBrowserVersion("latest");
        driver = new RemoteWebDriver(getSaucelabsUrl(), firefixBrowserOptions);
        return driver;
    }
}
