package org.example.tests;

import org.example.models.User;
import org.example.testSteps.LoginPageSteps;
import org.example.utils.PropertiesLoader;
import org.testng.annotations.Test;

import static org.example.enums.ItemsEnum.SAUCE_LABS_BOLT_T_SHIRT;

public class CheckPricesTest {

    @Test
    public void checkPrices() {
        User user = new User(PropertiesLoader.loadProperty("validUserLogin"), PropertiesLoader.loadProperty("validUserPassword"));
        // тест не взаимодействует с пейджой, только со степами
        // каждый степ возвращает инстанс степа, чтобы вызывать цепочкой
        new LoginPageSteps()
                .openLoginPage()
                .logIn(user)
                .checkIfInventoryPageIsOpened()
                .checkDescriptionOnUI(SAUCE_LABS_BOLT_T_SHIRT, "cotton");

    }
}
