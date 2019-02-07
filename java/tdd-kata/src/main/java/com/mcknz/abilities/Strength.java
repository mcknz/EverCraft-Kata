package com.mcknz.abilities;

import com.mcknz.constants.ValueType;
import com.mcknz.player.PlayerOptions;
import com.mcknz.player.constants.ClassType;

public class Strength extends Ability {

    public Strength(PlayerOptions playerOptions) {
        super(playerOptions);
        switch (playerOptions.getRaceType()) {
            case ORC: set(14); break;
            case HALFLING: set(9); break;
        }
    }

    @Override
    public int add(ValueType type, int value) {
        switch(type) {
            case ROLL:
                if(getPlayerOptions().getClassType() != ClassType.ROGUE) {
                    return this.getModifier();
                }
            case DAMAGE:
                return this.getModifier();
        }
        return super.add(type, value);
    }
}
