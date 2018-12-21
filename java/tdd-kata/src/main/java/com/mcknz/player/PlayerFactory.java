package com.mcknz.player;

import com.mcknz.Abilities;
import com.mcknz.abilities.exceptions.AbilityException;

public class PlayerFactory {

    public Player getPlayer(PlayerOptions options) throws AbilityException {
        Abilities abilities = new Abilities();
        switch(options.getClassType()) {
            case FIGHTER: return new Fighter(options, abilities);
            case MONK: return new Monk(options, abilities);
            case ROGUE: return new Rogue(options, abilities);
            case PALADIN: return new Paladin(options, abilities);
        }
        return new Player(options, abilities);
    }
}
