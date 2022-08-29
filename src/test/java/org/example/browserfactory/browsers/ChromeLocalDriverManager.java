package org.example.browserfactory.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.browserfactory.DriverFactory;
import org.example.browserfactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLocalDriverManager implements DriverManager {

    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
