package com.mcknz.abilities;

import com.mcknz.player.PlayerOptions;

public class Charisma extends Ability {

    public Charisma(PlayerOptions playerOptions) {
        super(playerOptions);
        switch (playerOptions.getRaceType()) {
            case ORC:
            case DWARF:
                set(9);
        }
    }
}
