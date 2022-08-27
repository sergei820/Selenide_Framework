package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.models.User;
import org.example.testSteps.LoginPageSteps;
import org.example.utils.PropertiesLoader;
import org.testng.annotations.Test;

import static org.example.enums.ItemsEnum.SAUCE_LABS_BACKPACK;

public class CheckPricesTest extends BaseTest {

    @Test
    @Description("Opening login page")
    @Epic("Epic 001")
    @Feature("Items prices functionality")
    @Severity(SeverityLevel.CRITICAL)
    public void checkPrices() {
        User user = new User(PropertiesLoader.loadProperty("validUserLogin"), PropertiesLoader.loadProperty("validUserPassword"));
        new LoginPageSteps()
                .openLoginPage()
                .logIn(user)
                .checkIfInventoryPageIsOpened()
                .checkPricesOnUI(SAUCE_LABS_BACKPACK);
    }
}
