package com.mcknz;

import com.mcknz.abilities.constants.ValueType;
import com.mcknz.abilities.exceptions.AbilityException;
import com.mcknz.player.constants.PlayerClass;

public class Roll {

    private final PlayerClass playerClass;
    private final Abilities abilities;

    public Roll(PlayerClass playerClass, Abilities abilities) {
        this.abilities = abilities;
        this.playerClass = playerClass;
    }

    public int get(int roll, int level, int modulus) throws AbilityException {
        int newRoll = roll;
        if(level % modulus == 0) {
            newRoll += (level / modulus);
        }
        return abilities.modify(playerClass, ValueType.ROLL, newRoll);
    }
}
