package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;
import com.mcknz.player.PlayerOptions;

public class Constitution extends Ability {

    @Override
    public int add(PlayerOptions playerOptions, ValueType type, int value) {
        switch(type) {
            case HIT_POINTS:
                return this.getModifier();
        }
        return super.add(playerOptions, type, value);
    }
}
