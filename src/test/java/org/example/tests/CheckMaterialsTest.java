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

import static org.example.enums.ItemsEnum.SAUCE_LABS_BOLT_T_SHIRT;

public class CheckMaterialsTest extends BaseTest {

    @Test
    @Description("Opening login page")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Epic 001")
    @Feature("Items materials functionality")
    public void checkMaterials() {
        User user = new User(PropertiesLoader.loadProperty("validUserLogin"), PropertiesLoader.loadProperty("validUserPassword"));
        //each step returns Step instance to call methods as a chain
        new LoginPageSteps()
                .openLoginPage()
                .logIn(user)
                .checkIfInventoryPageIsOpened()
                .checkDescriptionOnUI(SAUCE_LABS_BOLT_T_SHIRT, "cotton");
    }
}
