package com.jacob.adventuregame.itemclass;

import java.util.Random;

public class CreateNewScroll {
    private BaseScroll newScroll;
    String[] itemNames = {"Common", "Great", "Amazing", "Insane"};
    String[] itemDes = {"A new cool item", "An awesome item", "A not-so-great item"};
    Random rand = new Random();

    private void CreateScroll(){
        //item type
        String itemType = "SCROLL";

        //assign name to the potion
        String itemName = itemNames[rand.nextInt(3)] + " Scroll";
        //create a weapon description
        String itemDescription = "This is a new Equipment.";
        //weapon id
        int itemID = rand.nextInt(100) + 1;
        //spell effect id
        int spellEffectID = rand.nextInt(100) + 1;
        newScroll = new BaseScroll(itemName, itemDes[rand.nextInt(2)], itemID, BaseItem.ItemTypes.valueOf(itemType), spellEffectID);
    }

    public static void main(String[] args) {
        CreateNewScroll scroll = new CreateNewScroll();
        scroll.CreateScroll();
        System.out.println(scroll.newScroll.getItemName());
        System.out.println(scroll.newScroll.getItemDescription());
        System.out.println(scroll.newScroll.getItemID());
        System.out.println(scroll.newScroll.getItemTypes());
        System.out.println(scroll.newScroll.getSpellEffectID());
    }
}
