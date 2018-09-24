package com.jacob.adventuregame.turnbasecombat;

public class TurnBasedCombatStateMachine {
    public enum BattleStates {
        START,
        PLAYERCHOICE,
        ENEMYCHOICE,
        LOSE,
        WIN
    }

    private BattleStates currentState;
    
}
