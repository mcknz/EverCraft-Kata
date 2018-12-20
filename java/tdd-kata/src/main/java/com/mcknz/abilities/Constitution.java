package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;
import com.mcknz.player.constants.PlayerClass;

public class Constitution extends Ability {
    @Override
    AbilityType getType() {
        return AbilityType.CONSTITUTION;
    }

    @Override
    public int add(PlayerClass playerClass, ValueType type, int value) {
        switch(type) {
            case HIT_POINTS:
                return this.getModifier();
        }
        return super.add(playerClass, type, value);
    }
}
