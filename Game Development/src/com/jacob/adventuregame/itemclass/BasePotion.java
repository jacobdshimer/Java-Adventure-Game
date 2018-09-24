package com.jacob.adventuregame.itemclass;

public class BasePotion extends BaseStatItem{
    public enum PotionTypes {
        HEALTH,
        STAMINA,
        STRENGTH,
        DEXTERITY,
        CONSTITUTION,
        INTELLIGENCE,
        WISDOM,
        CHARISMA
    }

    private PotionTypes potionTypes;
    private int spellEffectID;

    public BasePotion(String itemName, String itemDescription, int itemID, ItemTypes itemTypes, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, PotionTypes potionTypes, int spellEffectID) {
        super(itemName, itemDescription, itemID, itemTypes, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.potionTypes = potionTypes;
        this.spellEffectID = spellEffectID;
    }

    public PotionTypes getPotionTypes() {
        return potionTypes;
    }

    public int getSpellEffectID() {
        return spellEffectID;
    }
}
