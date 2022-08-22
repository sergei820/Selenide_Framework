package org.example.tests;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CheckPricesTest {

    @Test
    public void checkPrices() {
        open("https://www.saucedemo.com/");
        $(By.id("user-name")).should(appear);
        $(By.id("user-name")).setValue("standard_user");
        $(By.id("password")).setValue("secret_sauce");
        $(By.id("login-button")).click();
        $(By.cssSelector(".login_wrapper-inner")).shouldBe(visible);
    }
}
