package org.example.browserfactory.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.browserfactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeLocalDriverManager extends DriverManager {

    public static WebDriver createDriver() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }
}
