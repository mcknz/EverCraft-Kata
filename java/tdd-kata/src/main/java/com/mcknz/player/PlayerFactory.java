package com.mcknz.player;

import com.mcknz.Abilities;
import com.mcknz.Roll;
import com.mcknz.abilities.exceptions.AbilityException;

public class PlayerFactory {

    public Player getPlayer(PlayerOptions options) throws AbilityException {
        Abilities abilities = new Abilities();
        Roll roll = new Roll(options.getPlayerClass(), abilities);
        switch(options.getPlayerClass()) {
            case FIGHTER: return new Fighter(options, abilities, roll);
            case MONK: return new Monk(options, abilities, roll);
            case ROGUE: return new Rogue(options, abilities, roll);
        }
        return new Player(options, abilities, roll);
    }
}
