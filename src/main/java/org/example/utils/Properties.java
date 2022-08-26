package org.example.utils;

import static org.example.utils.PropertiesLoader.getPropertiesInstance;

public class Properties {

    static final String PROPERTIES_FILE = String.format("/%s.properties", System.getProperty("env"));
    static final java.util.Properties PROPERTIES = getPropertiesInstance();
}
