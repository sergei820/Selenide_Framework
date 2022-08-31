package org.example.utils;

import java.net.MalformedURLException;
import java.net.URL;

import static com.sun.activation.registries.LogSupport.log;

public class UrlProvider {

    public static URL getSaucelabsUrl() {
        URL saucelabsUrl = null;
        try {
            saucelabsUrl = new URL("https://" +
                    PropertiesLoader.loadProperty("saucelabsUsername") +
                    ":" +
                    PropertiesLoader.loadProperty("saucelabsAccessKey") +
                    PropertiesLoader.loadProperty("saucelabsUrl"));
        } catch (MalformedURLException e) {
            log(e.getMessage());
        }
        return saucelabsUrl;
    }
}
