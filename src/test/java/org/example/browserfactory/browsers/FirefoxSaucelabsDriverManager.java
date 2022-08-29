package org.example.browserfactory.browsers;

import org.example.browserfactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.example.utils.UrlProvider.getSaucelabsUrl;

public class FirefoxSaucelabsDriverManager implements DriverManager {

    public WebDriver createDriver() {
        FirefoxOptions firefixBrowserOptions = new FirefoxOptions();
        firefixBrowserOptions.setPlatformName("Windows 10");
        firefixBrowserOptions.setBrowserVersion("latest");
        return new RemoteWebDriver(getSaucelabsUrl(), firefixBrowserOptions);
    }
}
