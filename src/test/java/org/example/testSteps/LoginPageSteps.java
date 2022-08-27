package org.example.testSteps;

import io.qameta.allure.Step;
import org.example.models.User;
import org.example.pageObjects.LoginPage;

import static com.codeborne.selenide.Condition.appear;

public class LoginPageSteps extends BasePageSteps {

    static LoginPage loginPage;

    @Step("Opening login page")
    public LoginPageSteps openLoginPage() {
        loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.getUserNameField().should(appear);
        return this;
    }

    @Step("Logging in")
    public InventoryPageSteps logIn(User user) {
        loginPage.getUserNameField().setValue(user.getUserLogin());
        loginPage.getPasswordField().setValue(user.getUserPassword());
        loginPage.getLogInButton().click();
        return new InventoryPageSteps();
    }
}
