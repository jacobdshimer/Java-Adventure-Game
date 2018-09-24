package com.jacob.adventuregame.itemclass;

import java.util.Random;

public class CreateNewWeapon {
    private BaseWeapon newWeapon;
    Random rand = new Random();

    public void CreateWeapon() {
        //item type
        String itemType = "WEAPON";
        //assign name to the weapon
        String itemName = "W" + String.valueOf(rand.nextInt(100) + 1);
        //create a weapon description
        String itemDescription = "This is a new Weapon.";
        //weapon id
        int itemID = rand.nextInt(100) + 1;
        //stats
        int strength = rand.nextInt(10) + 1;
        int dexterity = rand.nextInt(10) + 1;
        int constitution = rand.nextInt(10) + 1;
        int intelligence = rand.nextInt(10) + 1;
        int wisdom = rand.nextInt(10) + 1;
        int charisma = rand.nextInt(10) + 1;
        //weapon type
        BaseWeapon.WeaponTypes weaponType = ChooseWeaponType();
        //spell effect id
        int spellEffectID = rand.nextInt(100) + 1;
        newWeapon = new BaseWeapon(itemName, itemDescription, itemID, BaseItem.ItemTypes.valueOf(itemType), strength, dexterity, constitution, intelligence, wisdom, charisma, weaponType, spellEffectID);
    }


    private BaseWeapon.WeaponTypes ChooseWeaponType() {
        int randomWeaponType = rand.nextInt(6) + 1;
        if (randomWeaponType == 1) {
            return BaseWeapon.WeaponTypes.SWORD;
        } else if (randomWeaponType == 2) {
            return BaseWeapon.WeaponTypes.AXE;
        } else if (randomWeaponType == 3) {
            return BaseWeapon.WeaponTypes.BOW;
        } else if (randomWeaponType == 4) {
            return BaseWeapon.WeaponTypes.STAFF;
        } else if (randomWeaponType == 5) {
            return BaseWeapon.WeaponTypes.POLEARM;
        } else if (randomWeaponType == 6) {
            return BaseWeapon.WeaponTypes.DAGGER;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        CreateNewWeapon weapon = new CreateNewWeapon();
        weapon.CreateWeapon();
        String weaponName = weapon.newWeapon.getItemName();
        System.out.println(weaponName);
        System.out.println(weapon.newWeapon.getItemDescription());
        System.out.println(weapon.newWeapon.getItemID());
        System.out.println(weapon.newWeapon.getStrength());
        System.out.println(weapon.newWeapon.getDexterity());
        System.out.println(weapon.newWeapon.getConstitution());
        System.out.println(weapon.newWeapon.getIntelligence());
        System.out.println(weapon.newWeapon.getWisdom());
        System.out.println(weapon.newWeapon.getCharisma());
        System.out.println(weapon.newWeapon.getWeaponTypes());
        System.out.println(weapon.newWeapon.getSpellEffectID());
    }
}
