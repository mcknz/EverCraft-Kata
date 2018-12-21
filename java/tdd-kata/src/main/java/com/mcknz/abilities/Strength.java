package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;
import com.mcknz.player.constants.PlayerClass;

public class Strength extends Ability {
    @Override
    public int add(PlayerClass playerClass, ValueType type, int value) {
        switch(type) {
            case ROLL:
                if(playerClass != PlayerClass.ROGUE) {
                    return this.getModifier();
                }
            case DAMAGE:
                return this.getModifier();
        }
        return super.add(playerClass, type, value);
    }
}
