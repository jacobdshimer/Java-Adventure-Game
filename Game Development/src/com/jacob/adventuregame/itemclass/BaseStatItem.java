package com.jacob.adventuregame.itemclass;

public class BaseStatItem extends BaseItem{

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public BaseStatItem(String itemName, String itemDescription, int itemID, ItemTypes itemTypes, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        super(itemName, itemDescription, itemID, itemTypes);
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }
}
