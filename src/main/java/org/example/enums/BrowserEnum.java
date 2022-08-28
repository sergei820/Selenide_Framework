package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BrowserEnum {

    CHROME ("chrome"),
    FIREFOX ("firefox"),
    EDGE ("edge"),

    CHROMELOCAL ("chromelocal"),
    FIREFOXLOCAL ("firefoxlocal"),
    EDGELOCAL ("edgelocal"),
    CHROMESAUCELABS ("chromesaucelabs"),
    FIREFOXSAUCELABS ("firefoxsaucelabs"),
    EDGESAUCELABS ("edgesaucelabs");

    private String name;
}
