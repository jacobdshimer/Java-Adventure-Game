package com.jacob.adventuregame.itemclass;

public class BaseScroll extends BaseItem{
    private int spellEffectID;

    public BaseScroll(String itemName, String itemDescription, int itemID, ItemTypes itemTypes, int spellEffectID) {
        super(itemName, itemDescription, itemID, itemTypes);
        this.spellEffectID = spellEffectID;
    }

    public int getSpellEffectID() {
        return spellEffectID;
    }
}
