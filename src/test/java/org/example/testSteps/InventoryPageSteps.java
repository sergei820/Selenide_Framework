package org.example.testSteps;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import org.example.enums.ItemsEnum;
import org.example.pageObjects.InventoryPage;

public class InventoryPageSteps {

    static InventoryPage inventoryPage;

    @Step("Check if inventory page is opened")
    public InventoryPageSteps checkIfInventoryPageIsOpened() {
        inventoryPage = new InventoryPage();
        inventoryPage.getInventoryPageGrid().shouldBe(visible);
        return this;
    }

    @Step("Check description on UI")
    public void checkDescriptionOnUI(ItemsEnum itemName, String material) {
        String actualItemDesc = getItemDescriptionFromUI(itemName);
        Boolean isMadeFromCotton = itemName.getIsMadeFromCotton();
        assertThat(actualItemDesc.contains(material)).as("Description: " + actualItemDesc + " doesn't contains material: " + material).isEqualTo(isMadeFromCotton);
    }

    @Step("Get item description from UI")
    public String getItemDescriptionFromUI(ItemsEnum itemName) {
        String itemDescriptionActual = inventoryPage.getItemDescription(itemName);
        return itemDescriptionActual.toLowerCase();
    }

    @Step("Check prices on UI")
    public void checkPricesOnUI(ItemsEnum itemName) {
        String itemPriceActual = inventoryPage.getItemPrice(itemName);
        String itemPriceExpected = itemName.getPrice();
        assertThat(itemPriceActual).isEqualTo(itemPriceExpected);
    }
}
