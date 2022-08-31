package org.example.browserfactory.browsers;

import org.example.browserfactory.DriverFactory;
import org.example.browserfactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.example.utils.UrlProvider.getSaucelabsUrl;

public class EdgeSaucelabsDriverManager implements DriverManager {

    public WebDriver createDriver() {
        EdgeOptions edgeBrowserOptions = new EdgeOptions();
        edgeBrowserOptions.setPlatformName("Windows 10");
        edgeBrowserOptions.setBrowserVersion("latest");
        return new RemoteWebDriver(getSaucelabsUrl(), edgeBrowserOptions);
    }
}
