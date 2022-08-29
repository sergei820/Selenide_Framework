package org.example.browserfactory.browsers;

import org.example.browserfactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeSaucelabsDriverManager extends DriverManager {

    public static WebDriver createDriver() {
        EdgeOptions edgeBrowserOptions = new EdgeOptions();
        edgeBrowserOptions.setPlatformName("Windows 10");
        edgeBrowserOptions.setBrowserVersion("latest");
        driver = new RemoteWebDriver(getSaucelabsUrl(), edgeBrowserOptions);
        return driver;
    }
}
