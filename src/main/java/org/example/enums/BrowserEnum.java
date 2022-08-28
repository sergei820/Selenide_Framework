package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BrowserEnum {

    CHROME ("chrome"),
    FIREFOX ("firefox"),
    EDGE ("edge");

    private String name;
}
