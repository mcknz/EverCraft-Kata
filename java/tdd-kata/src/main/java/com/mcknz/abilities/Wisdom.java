package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;
import com.mcknz.player.PlayerOptions;
import com.mcknz.player.constants.ClassType;

public class Wisdom extends Ability {

    @Override
    public int add(PlayerOptions playerOptions, ValueType type, int value) {
        switch(type) {
            case ARMOR:
                if(playerOptions.getClassType() == ClassType.MONK) {
                    return this.getModifier();
                }
        }
        return super.add(playerOptions, type, value);
    }
}
