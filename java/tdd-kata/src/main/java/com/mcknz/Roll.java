package com.mcknz;

import com.mcknz.abilities.constants.ValueType;
import com.mcknz.abilities.exceptions.AbilityException;

public class Roll {

    private Abilities abilities;

    public Roll(Abilities abilities) {
        this.abilities = abilities;
    }

    public int get(int roll, int level, int modulus) throws AbilityException {
        int newRoll = roll;
        if(level % modulus == 0) {
            newRoll += (level / modulus);
        }
        return abilities.modify(ValueType.ROLL, newRoll);
    }
}
