package com.mcknz.abilities;

import com.mcknz.constants.ValueType;
import com.mcknz.player.PlayerOptions;

public class Constitution extends Ability {

    public Constitution(PlayerOptions playerOptions) {
        super(playerOptions);
        switch (playerOptions.getRaceType()) {
            case DWARF: set(12); break;
            case ELF: set(9); break;
        }
    }

    @Override
    public int add(ValueType type, int value) {
        switch(type) {
            case HIT_POINTS:
                return this.getModifier();
        }
        return super.add(type, value);
    }
}
