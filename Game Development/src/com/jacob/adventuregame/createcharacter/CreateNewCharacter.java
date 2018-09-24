package com.jacob.adventuregame.createcharacter;

import com.jacob.adventuregame.characterclass.BaseMageClass;
import com.jacob.adventuregame.characterclass.BaseThiefClass;
import com.jacob.adventuregame.characterclass.BaseWarriorClass;

public class CreateNewCharacter {

    private String characterName;
    private String characterClass;
    private int playerLevel = 1;

    public CreateNewCharacter(String characterName, String characterClass){
        this.characterName = characterName;
        this.characterClass = characterClass;
    }



    public String chooseCharacterClass(String characterClass) {
        if(characterClass == "Warrior"){
            BaseWarriorClass warrior = new BaseWarriorClass();
            int strength = warrior.getStrength();
            int dexterity = warrior.getDexterity();
            int constitution = warrior.getConstitution();
            int intelligence = warrior.getIntelligence();
            int wisdom = warrior.getWisdom();
            int charisma = warrior.getCharisma();
            return String.valueOf(strength + "," + dexterity + "," + constitution + "," + intelligence + "," + wisdom + "," + charisma);
        } else if(characterClass == "Mage"){
            BaseMageClass mage = new BaseMageClass();
            int strength = mage.getStrength();
            int dexterity = mage.getDexterity();
            int constitution = mage.getConstitution();
            int intelligence = mage.getIntelligence();
            int wisdom = mage.getWisdom();
            int charisma = mage.getCharisma();
            return String.valueOf(strength + "," + dexterity + "," + constitution + "," + intelligence + "," + wisdom + "," + charisma);
        } else if(characterClass == "Thief") {
            BaseThiefClass thief = new BaseThiefClass();
            int strength = thief.getStrength();
            int dexterity = thief.getDexterity();
            int constitution = thief.getConstitution();
            int intelligence = thief.getIntelligence();
            int wisdom = thief.getWisdom();
            int charisma = thief.getCharisma();
            return String.valueOf(strength + "," + dexterity + "," + constitution + "," + intelligence + "," + wisdom + "," + charisma);
        }

        return null;
    }
}
