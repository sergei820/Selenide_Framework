package org.example.browserfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.browserfactory.browsers.ChromeLocalDriverManager;
import org.example.browserfactory.browsers.ChromeSaucelabsDriverManager;
import org.example.browserfactory.browsers.EdgeLocalDriverManager;
import org.example.browserfactory.browsers.EdgeSaucelabsDriverManager;
import org.example.browserfactory.browsers.FirefoxLocalDriverManager;
import org.example.browserfactory.browsers.FirefoxSaucelabsDriverManager;
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

@Getter
@AllArgsConstructor
public class DriverManager {

    protected static WebDriver driver;

    public WebDriver getDriverInstance(BrowserEnum browserName) {
        switch (browserName) {
            case FIREFOXSAUCELABS:
                FirefoxSaucelabsDriverManager.createDriver();
                break;
            case CHROMESAUCELABS:
                ChromeSaucelabsDriverManager.createDriver();
                break;
            case EDGESAUCELABS:
                EdgeSaucelabsDriverManager.createDriver();
                break;
            case FIREFOXLOCAL:
                FirefoxLocalDriverManager.createDriver();
                break;
            case CHROMELOCAL:
                ChromeLocalDriverManager.createDriver();
                break;
            case EDGELOCAL:
                EdgeLocalDriverManager.createDriver();
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
                    PropertiesLoader.loadProperty("saucelabsUrl"));
        } catch (MalformedURLException e) {
            log(e.getMessage());
        }
        return saucelabsUrl;
    }
}
