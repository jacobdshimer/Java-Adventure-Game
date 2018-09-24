package com.jacob.adventuregame.itemclass;

public class BaseItem {
    private String itemName;
    private String itemDescription;
    private int itemID;
    public enum ItemTypes {
        EQUIPMENT,
        WEAPON,
        SCROLL,
        POTION,
        CHEST
    }

    private ItemTypes itemTypes;

    public BaseItem(String itemName, String itemDescription, int itemID, ItemTypes itemTypes) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemID = itemID;
        this.itemTypes = itemTypes;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public int getItemID() {
        return itemID;
    }

    public ItemTypes getItemTypes() {
        return itemTypes;
    }
}
