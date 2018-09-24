package com.jacob.adventuregame.itemclass;

public class BaseEquipment extends BaseStatItem {
    public enum EquipmentTypes {
        HEAD,
        CHEST,
        SHOULDERS,
        HANDS,
        LEGS,
        FEET,
        NECKLACE,
        RING
    }

    private EquipmentTypes equipmentTypes;
    private int spellEffectID;

    public BaseEquipment(String itemName, String itemDescription, int itemID, ItemTypes itemTypes, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, EquipmentTypes equipmentTypes, int spellEffectID) {
        super(itemName, itemDescription, itemID, itemTypes, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.equipmentTypes = equipmentTypes;
        this.spellEffectID = spellEffectID;
    }

    public EquipmentTypes getEquipmentTypes() {
        return equipmentTypes;
    }

    public int getSpellEffectID() {
        return spellEffectID;
    }
}

