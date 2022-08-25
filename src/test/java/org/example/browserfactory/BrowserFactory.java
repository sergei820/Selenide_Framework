package org.example.browserfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    public static WebDriver getBrowser(String browserName) {
        WebDriver driver = null;

        switch (browserName) {
            case "chrome":
                driver = WebDriverManager.chromiumdriver().getWebDriver();
            case "firefox":
                driver = WebDriverManager.firefoxdriver().getWebDriver();
            default:
                driver = WebDriverManager.edgedriver().getWebDriver();
        }

        return driver;
    }
}
