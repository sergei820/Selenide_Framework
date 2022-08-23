package org.example.testSteps;

import org.example.models.User;
import org.example.pageObjects.InventoryPage;
import org.example.pageObjects.LoginPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageSteps extends BasePageSteps {

    static LoginPage loginPage;
    static InventoryPage inventoryPage;

    public LoginPageSteps openLoginPage() {
        loginPage = new LoginPage();
        loginPage.openPage();
        loginPage.getUserNameField().should(appear);
        return this;
    }

    public InventoryPageSteps logIn(User user) {
        loginPage.getUserNameField().setValue(user.getUserLogin());
        loginPage.getPasswordField().setValue(user.getUserPassword());
        loginPage.getLogInButton().click();
        inventoryPage = new InventoryPage();
        inventoryPage.getInventoryPageGrid().shouldBe(visible);
        return new InventoryPageSteps();
    }
}
