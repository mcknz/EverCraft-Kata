package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;
import com.mcknz.player.PlayerOptions;
import com.mcknz.player.constants.ClassType;

public class Wisdom extends Ability {

    public Wisdom(PlayerOptions playerOptions) {
        super(playerOptions);
        switch (playerOptions.getRaceType()) {
            case ORC: set(9);
        }
    }

    @Override
    public int add(ValueType type, int value) {
        switch(type) {
            case ARMOR:
                if(getPlayerOptions().getClassType() == ClassType.MONK) {
                    return this.getModifier();
                }
        }
        return super.add(type, value);
    }
}
