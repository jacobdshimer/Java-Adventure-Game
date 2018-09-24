package com.jacob.adventuregame;

import com.jacob.adventuregame.createcharacter.CreateNewCharacter;


public class Game2 {
    public static void main(String[] args) {
        CreateNewCharacter newPlayer = new CreateNewCharacter("Test Character", "Warrior");
        System.out.println(newPlayer.chooseCharacterClass("Warrior"));


    }
}
