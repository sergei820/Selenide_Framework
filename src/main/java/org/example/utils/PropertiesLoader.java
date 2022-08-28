package org.example.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesLoader {

    static final String PROPERTIES_FILE = String.format("/%s.properties", System.getProperty("env"));
    @Getter
    @Setter
    private static java.util.Properties propertiesInstance;

    public static String loadProperty(String propertyName) {
        return propertiesInstance.getProperty(propertyName);
    }

    @SneakyThrows
    public static java.util.Properties initializePropertiesInstance() {
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
