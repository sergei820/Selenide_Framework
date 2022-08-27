package org.example.enums;

import lombok.Getter;

@Getter
public enum BrowserEnum {

    CHROME ("chrome"),
    FIREFOX ("firefox"),
    EDGE ("edge");

    private String name;

    BrowserEnum(String name) {
        this.name = name();
    }
}
