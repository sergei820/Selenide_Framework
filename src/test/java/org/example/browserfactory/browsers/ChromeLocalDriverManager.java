package org.example.browserfactory.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.browserfactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLocalDriverManager extends DriverManager {

    public static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
}
