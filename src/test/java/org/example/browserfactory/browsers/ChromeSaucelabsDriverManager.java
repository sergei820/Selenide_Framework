package org.example.browserfactory.browsers;

import org.example.browserfactory.DriverFactory;
import org.example.browserfactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.example.utils.UrlProvider.getSaucelabsUrl;

public class ChromeSaucelabsDriverManager implements DriverManager {

    public WebDriver createDriver() {
        ChromeOptions chromeBrowserOptions = new ChromeOptions();
        chromeBrowserOptions.setPlatformName("Windows 10");
        chromeBrowserOptions.setBrowserVersion("latest");
        return new RemoteWebDriver(getSaucelabsUrl(), chromeBrowserOptions);
    }
}
