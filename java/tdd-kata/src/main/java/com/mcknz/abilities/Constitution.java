package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;

public class Constitution extends Ability {
    @Override
    AbilityType getType() {
        return AbilityType.CONSTITUTION;
    }

    @Override
    public int add(ValueType type, int value) {
        switch(type) {
            case HIT_POINTS:
                return this.getModifier();
        }
        return super.add(type, value);
    }
}
