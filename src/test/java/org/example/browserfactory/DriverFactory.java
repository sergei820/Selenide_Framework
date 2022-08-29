package org.example.browserfactory;

import lombok.Getter;
import org.example.browserfactory.browsers.ChromeLocalDriverManager;
import org.example.browserfactory.browsers.ChromeSaucelabsDriverManager;
import org.example.browserfactory.browsers.EdgeLocalDriverManager;
import org.example.browserfactory.browsers.EdgeSaucelabsDriverManager;
import org.example.browserfactory.browsers.FirefoxLocalDriverManager;
import org.example.browserfactory.browsers.FirefoxSaucelabsDriverManager;
import org.example.enums.BrowserEnum;

@Getter
public class DriverFactory {

    private DriverManager driverManager;

    public DriverManager getDriverManager(BrowserEnum browserName) {
        if(driverManager == null) {
            switch (browserName) {
                case FIREFOXSAUCELABS:
                    driverManager = new FirefoxSaucelabsDriverManager();
                    break;
                case CHROMESAUCELABS:
                    driverManager = new ChromeSaucelabsDriverManager();
                    break;
                case EDGESAUCELABS:
                    driverManager = new EdgeSaucelabsDriverManager();
                    break;
                case FIREFOXLOCAL:
                    driverManager = new FirefoxLocalDriverManager();
                    break;
                case CHROMELOCAL:
                    driverManager = new ChromeLocalDriverManager();
                    break;
                case EDGELOCAL:
                    driverManager = new EdgeLocalDriverManager();
                    break;
            }
        }
        return driverManager;
    }
}
