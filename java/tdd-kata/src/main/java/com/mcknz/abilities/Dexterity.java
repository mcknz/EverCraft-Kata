package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;
import com.mcknz.player.PlayerOptions;
import com.mcknz.player.constants.ClassType;

public class Dexterity extends Ability {

    public Dexterity(PlayerOptions playerOptions) {
        super(playerOptions);
    }

    @Override
    public int add(ValueType type, int value) {
        switch(type) {
            case ARMOR:
                return this.getModifier();
            case ROLL:
                if(getPlayerOptions().getClassType() == ClassType.ROGUE) {
                    return this.getModifier();
                }
        }
        return super.add(type, value);
    }
}
