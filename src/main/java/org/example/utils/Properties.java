package org.example.utils;

import static org.example.utils.PropertiesLoader.getPropertiesInstance;

public class Properties {

    static final String PROPERTIES_FILE = "/QA.properties";
    static final java.util.Properties PROPERTIES = getPropertiesInstance();
}
