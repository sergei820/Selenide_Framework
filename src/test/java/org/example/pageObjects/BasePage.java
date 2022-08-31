package org.example.pageObjects;

public class BasePage {

    public String compileLocator(String locator, String replacement) {
        return locator.replace("REPLACE", replacement);
    }
}
