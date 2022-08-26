package org.example.enums;

import lombok.Getter;

@Getter
public enum BrowserEnum {

    CHROME ("chrome"),
    FIREFOX ("firefox");

    private String name;

    BrowserEnum(String name) {
        this.name = name();
    }
}
