package org.example.browserfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.enums.BrowserEnum;
import org.example.utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Reporter.log;

public class BrowserFactory {

    private static WebDriver driver;

    public static WebDriver getSaucelabsDriver(BrowserEnum browserName) {
        switch (browserName) {
            case FIREFOX:
                FirefoxOptions firefixBrowserOptions = new FirefoxOptions();
                firefixBrowserOptions.setPlatformName("Windows 10");
                firefixBrowserOptions.setBrowserVersion("latest");
                driver = new RemoteWebDriver(getSaucelabsUrl(), firefixBrowserOptions);
                break;
            case CHROME:
                ChromeOptions chromeBrowserOptions = new ChromeOptions();
                chromeBrowserOptions.setPlatformName("Windows 10");
                chromeBrowserOptions.setBrowserVersion("latest");
                driver = new RemoteWebDriver(getSaucelabsUrl(), chromeBrowserOptions);
                break;
            case EDGE:
                EdgeOptions edgeBrowserOptions = new EdgeOptions();
                edgeBrowserOptions.setPlatformName("Windows 10");
                edgeBrowserOptions.setBrowserVersion("latest");
                driver = new RemoteWebDriver(getSaucelabsUrl(), edgeBrowserOptions);
                break;
        }
        return driver;
    }

    public static WebDriver getLocalBrowser(BrowserEnum browserName) {
        switch (browserName) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        return driver;
    }

    public static URL getSaucelabsUrl() {
        URL saucelabsUrl = null;
        try {
            saucelabsUrl = new URL("https://" +
                    PropertiesLoader.loadProperty("saucelabsUsername") +
                    ":" +
                    PropertiesLoader.loadProperty("saucelabsAccessKey") +
                    "@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            log(e.getMessage());
        }
        return saucelabsUrl;
    }
}
