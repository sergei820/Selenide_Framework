package org.example.tests;

import org.example.models.User;
import org.example.testSteps.LoginPageSteps;
import org.example.utils.PropertiesLoader;
import org.testng.annotations.Test;

import static org.example.enums.ItemsEnum.SAUCE_LABS_BOLT_T_SHIRT;

public class CheckMaterialsTest extends BaseTest {

    @Test
    public void checkPrices() {
        User user = new User(PropertiesLoader.loadProperty("validUserLogin"), PropertiesLoader.loadProperty("validUserPassword"));
        //each step returns Step instance to call methods as a chain
        new LoginPageSteps()
                .openLoginPage()
                .logIn(user)
                .checkIfInventoryPageIsOpened()
                .checkDescriptionOnUI(SAUCE_LABS_BOLT_T_SHIRT, "cotton");
    }
}
