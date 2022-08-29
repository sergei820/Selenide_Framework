package org.example.pageObjects;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.Getter;
import org.example.utils.PropertiesLoader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class LoginPage extends BasePage {

    SelenideElement userNameField = $(By.id("user-name"));
    SelenideElement passwordField = $(By.id("password"));
    SelenideElement logInButton = $(By.id("login-button"));

    public void openPage() {
        WebDriverRunner.getWebDriver().get(PropertiesLoader.loadProperty("url"));
        //open("https://www.saucedemo.com/");
    }
}
