package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;

public class Strength extends Ability {

    @Override
    AbilityType getType() {
        return AbilityType.STRENGTH;
    }

    @Override
    public int add(ValueType type, int value) {
        switch(type) {
            case ROLL:
            case DAMAGE:
                return this.getModifier();
        }
        return super.add(type, value);
    }
}
