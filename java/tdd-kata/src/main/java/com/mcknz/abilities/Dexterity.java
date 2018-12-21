package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;
import com.mcknz.player.PlayerOptions;
import com.mcknz.player.constants.ClassType;

public class Dexterity extends Ability {

    @Override
    public int add(PlayerOptions playerOptions, ValueType type, int value) {
        switch(type) {
            case ARMOR:
                return this.getModifier();
            case ROLL:
                if(playerOptions.getClassType() == ClassType.ROGUE) {
                    return this.getModifier();
                }
        }
        return super.add(playerOptions, type, value);
    }
}
