package org.example.browserfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.example.enums.BrowserEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static BrowserFactory instance = null;

    private static WebDriver driver;

    private BrowserFactory(BrowserEnum browserName) {
        switch (browserName) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
    }

    public static BrowserFactory getInstance(BrowserEnum browserName) {
        if(instance == null) {
            instance = new BrowserFactory(browserName);
        }
        return instance;
    }

    public WebDriver getDriver() {

        return driver;
    }
}
