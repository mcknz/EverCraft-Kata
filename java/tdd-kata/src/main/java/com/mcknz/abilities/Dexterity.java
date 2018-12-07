package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;

public class Dexterity extends Ability {
    @Override
    AbilityType getType() {
        return AbilityType.DEXTERITY;
    }

    @Override
    public int add(ValueType type, int value) {
        switch(type) {
            case ARMOR:
                return this.getModifier();
        }
        return super.add(type, value);
    }
}
