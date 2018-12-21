package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;
import com.mcknz.player.constants.PlayerClass;

public class Wisdom extends Ability {

    @Override
    public int add(PlayerClass playerClass, ValueType type, int value) {
        switch(type) {
            case ARMOR:
                if(playerClass == PlayerClass.MONK) {
                    return this.getModifier();
                }
        }
        return super.add(playerClass, type, value);
    }
}
