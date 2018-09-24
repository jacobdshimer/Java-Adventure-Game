package com.jacob.adventuregame.itemclass;

import java.util.Random;

public class CreateNewPotion {
    private BasePotion newPotion;
    String[] itemNames = {"Common", "Great", "Amazing", "Insane"};
    String[] itemDes = {"A new cool item", "An awesome item", "A not-so-great item"};
    Random rand = new Random();

    public void CreatePotion() {
        //item type
        String itemType = "POTION";

        //assign name to the potion
        String itemName = itemNames[rand.nextInt(3)] + " Potion";
        //create a weapon description
        //potion id
        int itemID = rand.nextInt(100) + 1;
        //stats
        int strength = rand.nextInt(10) + 1;
        int dexterity = rand.nextInt(10) + 1;
        int constitution = rand.nextInt(10) + 1;
        int intelligence = rand.nextInt(10) + 1;
        int wisdom = rand.nextInt(10) + 1;
        int charisma = rand.nextInt(10) + 1;
        //item type
        BasePotion.PotionTypes potionType = ChoosePotionType();
        //spell effect id
        int spellEffectID = rand.nextInt(100) + 1;
        newPotion = new BasePotion(itemName, itemDes[rand.nextInt(2)], itemID, BaseItem.ItemTypes.valueOf(itemType), strength, dexterity, constitution, intelligence, wisdom, charisma, potionType, spellEffectID);
    }


    private BasePotion.PotionTypes ChoosePotionType() {
        int randomPotionType = rand.nextInt(8) + 1;
        if (randomPotionType == 1) {
            return BasePotion.PotionTypes.HEALTH;
        } else if (randomPotionType == 2) {
            return BasePotion.PotionTypes.STAMINA;
        } else if (randomPotionType == 3) {
            return BasePotion.PotionTypes.STRENGTH;
        } else if (randomPotionType == 4) {
            return BasePotion.PotionTypes.DEXTERITY;
        } else if (randomPotionType == 5) {
            return BasePotion.PotionTypes.CONSTITUTION;
        } else if (randomPotionType == 6) {
            return BasePotion.PotionTypes.INTELLIGENCE;
        } else if (randomPotionType == 7) {
            return BasePotion.PotionTypes.WISDOM;
        } else if (randomPotionType == 8) {
            return BasePotion.PotionTypes.CHARISMA;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        CreateNewPotion potion = new CreateNewPotion();
        potion.CreatePotion();
        System.out.println(potion.newPotion.getItemName());
        System.out.println(potion.newPotion.getItemDescription());
        System.out.println(potion.newPotion.getItemID());
        System.out.println(potion.newPotion.getStrength());
        System.out.println(potion.newPotion.getDexterity());
        System.out.println(potion.newPotion.getConstitution());
        System.out.println(potion.newPotion.getIntelligence());
        System.out.println(potion.newPotion.getWisdom());
        System.out.println(potion.newPotion.getCharisma());
        System.out.println(potion.newPotion.getPotionTypes());
        System.out.println(potion.newPotion.getSpellEffectID());
    }
}
