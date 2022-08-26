package org.example.tests;

import org.example.models.User;
import org.example.testSteps.LoginPageSteps;
import org.example.utils.PropertiesLoader;
import org.testng.annotations.Test;

import static org.example.enums.ItemsEnum.SAUCE_LABS_BACKPACK;

public class CheckPricesTest extends BaseTest {

    @Test
    public void checkPrices() {
        User user = new User(PropertiesLoader.loadProperty("validUserLogin"), PropertiesLoader.loadProperty("validUserPassword"));
        new LoginPageSteps()
                .openLoginPage()
                .logIn(user)
                .checkIfInventoryPageIsOpened()
                .checkPricesOnUI(SAUCE_LABS_BACKPACK);
    }
}
