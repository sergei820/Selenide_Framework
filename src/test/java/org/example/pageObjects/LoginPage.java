package org.example.pageObjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Getter
public class LoginPage extends BasePage {

    private static final String loginPageUrl = "https://www.saucedemo.com/";

    SelenideElement userNameField = $(By.id("user-name"));
    SelenideElement passwordField = $(By.id("password"));
    SelenideElement logInButton = $(By.id("login-button"));

    public void openPage() {
        open("https://www.saucedemo.com/");
    }
}
