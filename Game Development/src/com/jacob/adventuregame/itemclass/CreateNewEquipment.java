package com.jacob.adventuregame.itemclass;

import java.util.Random;

public class CreateNewEquipment {
    private BaseEquipment newEquipment;
    String[] itemNames = {"Common", "Great", "Amazing", "Insane"};
    String[] itemDes = {"A new cool item", "An awesome item", "A not-so-great item"};
    Random rand = new Random();

    public void CreateEquipment() {
        //item type
        String itemType = "EQUIPMENT";
        //item name
        String itemName = itemNames[rand.nextInt(3)] + " Item";
        //equipment id
        int itemID = rand.nextInt(100) + 1;
        //stats
        int strength = rand.nextInt(10) + 1;
        int dexterity = rand.nextInt(10) + 1;
        int constitution = rand.nextInt(10) + 1;
        int intelligence = rand.nextInt(10) + 1;
        int wisdom = rand.nextInt(10) + 1;
        int charisma = rand.nextInt(10) + 1;
        //equipment type
        BaseEquipment.EquipmentTypes equipmentType = ChooseEquipmentType();
        //spell effect id
        int spellEffectID = rand.nextInt(100) + 1;
        newEquipment = new BaseEquipment(itemName, itemDes[rand.nextInt(2)], itemID, BaseItem.ItemTypes.valueOf(itemType), strength, dexterity, constitution, intelligence, wisdom, charisma, equipmentType, spellEffectID);
    }


    private BaseEquipment.EquipmentTypes ChooseEquipmentType() {
        int randomEquipmentType = rand.nextInt(8) + 1;
        if (randomEquipmentType == 1) {
            return BaseEquipment.EquipmentTypes.HEAD;
        } else if (randomEquipmentType == 2) {
            return BaseEquipment.EquipmentTypes.CHEST;
        } else if (randomEquipmentType == 3) {
            return BaseEquipment.EquipmentTypes.SHOULDERS;
        } else if (randomEquipmentType == 4) {
            return BaseEquipment.EquipmentTypes.HANDS;
        } else if (randomEquipmentType == 5) {
            return BaseEquipment.EquipmentTypes.LEGS;
        } else if (randomEquipmentType == 6) {
            return BaseEquipment.EquipmentTypes.FEET;
        } else if (randomEquipmentType == 7) {
            return BaseEquipment.EquipmentTypes.NECKLACE;
        } else if (randomEquipmentType == 8) {
            return BaseEquipment.EquipmentTypes.RING;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        CreateNewEquipment equipment = new CreateNewEquipment();
        equipment.CreateEquipment();
        System.out.println(equipment.newEquipment.getItemName());
        System.out.println(equipment.newEquipment.getItemDescription());
        System.out.println(equipment.newEquipment.getItemID());
        System.out.println(equipment.newEquipment.getStrength());
        System.out.println(equipment.newEquipment.getDexterity());
        System.out.println(equipment.newEquipment.getConstitution());
        System.out.println(equipment.newEquipment.getIntelligence());
        System.out.println(equipment.newEquipment.getWisdom());
        System.out.println(equipment.newEquipment.getCharisma());
        System.out.println(equipment.newEquipment.getEquipmentTypes());
        System.out.println(equipment.newEquipment.getSpellEffectID());
    }
}
