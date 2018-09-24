package com.jacob.adventuregame.characterclass;

public class CharacterClass {
    private String characterClassName;
    private String characterClassDescription;
    private String characterSpecies;
    private String characterSpeciesDescription;

    //Stats
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public CharacterClass(String characterClassName, String characterClassDescription, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.characterClassName = characterClassName;
        this.characterClassDescription = characterClassDescription;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public String getCharacterClassName() {
        return characterClassName;
    }

    public String getCharacterClassDescription() {
        return characterClassDescription;
    }

    public String getCharacterSpecies() {
        return characterSpecies;
    }

    public String getCharacterSpeciesDescription() {
        return characterSpeciesDescription;
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
