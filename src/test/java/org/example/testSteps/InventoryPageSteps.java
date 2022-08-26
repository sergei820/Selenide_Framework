package org.example.testSteps;

import static com.codeborne.selenide.Condition.visible;
import static org.assertj.core.api.Assertions.assertThat;

import org.example.enums.ItemsEnum;
import org.example.pageObjects.InventoryPage;

public class InventoryPageSteps {

    static InventoryPage inventoryPage;

    public InventoryPageSteps checkIfInventoryPageIsOpened() {
        inventoryPage = new InventoryPage();
        inventoryPage.getInventoryPageGrid().shouldBe(visible);
        return this;
    }

    public void checkDescriptionOnUI(ItemsEnum itemName, String material) {
        String actualItemDesc = getItemDescriptionFromUI(itemName);
        Boolean isMadeFromCotton = itemName.getIsMadeFromCotton();
        assertThat(actualItemDesc.contains(material)).as("Description: " + actualItemDesc + " doesn't contains material: " + material).isEqualTo(isMadeFromCotton);
    }

    public String getItemDescriptionFromUI(ItemsEnum itemName) {
        String itemDescriptionActual = inventoryPage.getItemDescription(itemName);
        return itemDescriptionActual.toLowerCase();
    }

    public void checkPricesOnUI(ItemsEnum itemName) {
        String itemPriceActual = inventoryPage.getItemPrice(itemName);
        String itemPriceExpected = itemName.getPrice();
        assertThat(itemPriceActual).isEqualTo(itemPriceExpected);
    }
}
