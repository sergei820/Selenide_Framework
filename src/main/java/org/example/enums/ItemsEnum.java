package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemsEnum {
    SAUCE_LABS_BACKPACK("SAUCE_LABS_BACKPACK", "Sauce Labs Backpack", "$29.99", false),
    SAUCE_LABS_BIKE_LIGHT("SAUCE_LABS_BIKE_LIGHT", "Sauce Labs Bike Light", "$9.99", false),
    SAUCE_LABS_BOLT_T_SHIRT("SAUCE_LABS_BOLT_T_SHIRT", "Sauce Labs Bolt T-Shirt", "$15.99", true),
    TEST_ALLTHETHINGS_T_SHIRT_RED("TEST_ALLTHETHINGS_T_SHIRT_RED", "Test.allTheThings() T-Shirt (Red)", "$15.99", true),
    SAUCE_LABS_FLEECE_JACKET("SAUCE_LABS_FLEECE_JACKET", "Sauce Labs Fleece Jacket", "$49.99", false),
    SAUCE_LABS_ONESIE("SAUCE_LABS_ONESIE", "Sauce Labs Onesie", "$7.99", false);

    private String code;
    private String name;
    private String price;
    private Boolean isMadeFromCotton;
}
