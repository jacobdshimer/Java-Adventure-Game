package com.jacob.adventuregame.itemclass;

public class BaseWeapon extends BaseStatItem{
    public enum WeaponTypes {
        SWORD,
        AXE,
        BOW,
        STAFF,
        POLEARM,
        DAGGER
    }

    private WeaponTypes weaponType;
    private int spellEffectID;

    public BaseWeapon(String itemName, String itemDescription, int itemID, ItemTypes itemTypes, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, WeaponTypes weaponType, int spellEffectID) {
        super(itemName, itemDescription, itemID, itemTypes, strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.weaponType = weaponType;
        this.spellEffectID = spellEffectID;
    }

    public WeaponTypes getWeaponTypes() {
        return weaponType;
    }

    public void setWeaponType(WeaponTypes weaponType) {
        this.weaponType = weaponType;
    }

    public int getSpellEffectID() {
        return spellEffectID;
    }
}
