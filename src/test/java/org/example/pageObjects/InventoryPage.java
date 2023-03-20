package org.example.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.enums.ItemsEnum;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class InventoryPage extends BasePage {

    public static final String ITEM_PRICE_BY_NAME_XPATH = "//div[text()='REPLACE']/parent::a/parent::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']/div[@class='inventory_item_price']";
    public static final String ITEM_DESCRIPTION_BY_NAME_XPATH = "//div[text()='REPLACE']/parent::a/following-sibling::div[@class='inventory_item_desc']";

    private SelenideElement inventoryPageHeader = $(By.xpath("//div[@class='header_secondary_container']/span[text()='Products']"));
    private SelenideElement inventoryPageGrid = $(".inventory_list");

    public String getItemPrice(ItemsEnum itemName) {
        SelenideElement backpackDescriptionElement = $(By.xpath(compileLocator(ITEM_PRICE_BY_NAME_XPATH, itemName.getName())));
        return backpackDescriptionElement.getText();
    }

    public String getItemDescription(ItemsEnum itemName) {
        SelenideElement backpackDescriptionElement = $(By.xpath(compileLocator(ITEM_DESCRIPTION_BY_NAME_XPATH, itemName.getName())));
        backpackDescriptionElement.shouldBe(Condition.visible);
        return backpackDescriptionElement.getText();
    }
}
