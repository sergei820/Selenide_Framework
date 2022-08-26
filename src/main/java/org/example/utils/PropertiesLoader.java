package org.example.utils;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class PropertiesLoader {

    static final String PROPERTIES_FILE = String.format("/%s.properties", System.getProperty("env"));
    //static final String PROPERTIES_FILE = "/QA.properties";

    public static String loadProperty(String propertyName) {
        return getPropertiesInstance().getProperty(propertyName);
    }

    @SneakyThrows
    static java.util.Properties getPropertiesInstance() {
        java.util.Properties instance = new java.util.Properties();
        try (
                InputStream resourceStream = PropertiesLoader.class.getResourceAsStream(PROPERTIES_FILE);
                InputStreamReader inputStream = new InputStreamReader(resourceStream, Charset.forName("UTF-8"))
        ) {
            instance.load(inputStream);
        }
        return instance;
    }
}
