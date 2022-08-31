package org.example.browserfactory.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.browserfactory.DriverFactory;
import org.example.browserfactory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeLocalDriverManager implements DriverManager {

    public WebDriver createDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
