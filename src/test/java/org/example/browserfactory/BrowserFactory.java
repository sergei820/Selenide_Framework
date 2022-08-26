package org.example.browserfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.example.enums.BrowserEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    @Getter
    private static WebDriver driver;

    public static WebDriver getBrowser(BrowserEnum browserName) {
        if(driver == null) {
            switch (browserName) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
            }
            System.out.println(browserName);
        }
        return driver;
    }
}
