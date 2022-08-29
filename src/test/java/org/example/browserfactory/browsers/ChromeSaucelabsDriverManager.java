package org.example.browserfactory.browsers;

import org.example.browserfactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeSaucelabsDriverManager extends DriverManager {

    public static WebDriver createDriver() {
        ChromeOptions chromeBrowserOptions = new ChromeOptions();
        chromeBrowserOptions.setPlatformName("Windows 10");
        chromeBrowserOptions.setBrowserVersion("latest");
        driver = new RemoteWebDriver(getSaucelabsUrl(), chromeBrowserOptions);
        return driver;
    }
}
