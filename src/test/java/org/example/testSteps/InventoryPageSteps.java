package org.example.testSteps;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.enums.ItemsEnum;
import org.example.pageObjects.InventoryPage;

public class InventoryPageSteps {

    InventoryPage inventoryPage;

    public void checkDescriptionOnUI(ItemsEnum itemName, String material) {
        Boolean containsMaterial = containsMaterialInDescriptionOnUI(itemName, material);
        Boolean isMadeFromCotton = itemName.getIsMadeFromCotton();
        assertThat(containsMaterial).isEqualTo(isMadeFromCotton);
    }

    public boolean containsMaterialInDescriptionOnUI(ItemsEnum itemName, String material) {
        String itemDescriptionActual = inventoryPage.getItemDescription(itemName);
        itemDescriptionActual = itemDescriptionActual.toLowerCase();
        return itemDescriptionActual.contains(material);
    }
}
