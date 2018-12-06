package com.mcknz;

import com.mcknz.abilities.AbilityException;

import static org.junit.Assert.fail;

abstract class Tests {

    Player getStandardPlayer() {
        return getStandardPlayer(new PlayerOptions(10,10));
    }

    Player getStandardPlayer(PlayerOptions options) {
        Player p = null;
        try {
            p = new Player(options);
        } catch(AbilityException ex) {
            fail(ex.getMessage());
        }
        return p;
    }

}
