package org.example.browserfactory;

import org.example.enums.BrowserEnum;
import org.example.utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Reporter.log;

public class SaucelabsDriverFactory {

    private static WebDriver driver;

    public static WebDriver getSaucelabsDriver(BrowserEnum browserName) {
        try {
            switch (browserName) {
                case CHROME:
                    ChromeOptions chromeBrowserOptions = new ChromeOptions();
                    chromeBrowserOptions.setPlatformName("Windows 10");
                    chromeBrowserOptions.setBrowserVersion("latest");
                    driver = new RemoteWebDriver(getSaucelabsUrl(), chromeBrowserOptions);
                case FIREFOX:
                    FirefoxOptions firefixBrowserOptions = new FirefoxOptions();
                    firefixBrowserOptions.setPlatformName("Windows 10");
                    firefixBrowserOptions.setBrowserVersion("latest");
                    driver = new RemoteWebDriver(getSaucelabsUrl(), firefixBrowserOptions);
            }
        } catch (MalformedURLException e) {
            log(e.getMessage());
        }

        return driver;
    }

    public static URL getSaucelabsUrl() throws MalformedURLException {
        return new URL("https://" +
                PropertiesLoader.loadProperty("saucelabsUsername") +
                ":" +
                PropertiesLoader.loadProperty("saucelabsAccessKey") +
                "@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
    }
}
