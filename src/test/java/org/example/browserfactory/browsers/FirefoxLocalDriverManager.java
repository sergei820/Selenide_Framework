package org.example.browserfactory.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.browserfactory.DriverFactory;
import org.example.browserfactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLocalDriverManager implements DriverManager {

    public WebDriver createDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
