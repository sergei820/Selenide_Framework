package org.example.browserfactory;

import org.example.enums.BrowserEnum;
import org.openqa.selenium.WebDriver;

public interface DriverFactory {

    static WebDriver getDriverInstance(BrowserEnum browserName) {
        return (new DriverManager()).getDriverInstance(browserName);
    }
}
