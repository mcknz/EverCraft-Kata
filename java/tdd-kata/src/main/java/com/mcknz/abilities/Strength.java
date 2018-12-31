package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;
import com.mcknz.player.PlayerOptions;
import com.mcknz.player.constants.ClassType;
import com.mcknz.player.constants.RaceType;

public class Strength extends Ability {

    public Strength(PlayerOptions playerOptions) {
        super(playerOptions);
        switch (playerOptions.getRaceType()) {
            case ORC: set(14);
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
