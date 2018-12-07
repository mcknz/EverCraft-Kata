package com.mcknz;

import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.abilities.exceptions.AbilityException;
import com.mcknz.player.Fighter;
import com.mcknz.player.Player;
import com.mcknz.player.constants.PlayerClass;
import com.mcknz.player.constants.PlayerOptions;

import static org.junit.Assert.fail;

public abstract class AbstractTests {

    protected Player getStandardPlayer() {
        return getStandardPlayer(new PlayerOptions(10,10), PlayerClass.PLAYER);
    }

    protected Player getStandardPlayer(PlayerOptions options) {
        return getStandardPlayer(options, PlayerClass.PLAYER);
    }

    protected Player getStandardPlayer(PlayerClass type) {
        return getStandardPlayer(new PlayerOptions(10,10), type);
    }

    protected Player getStandardPlayer(PlayerOptions options, PlayerClass type) {
        Player p = null;
        try {
            Abilities abilities = new Abilities();
            Roll roll = new Roll(abilities);
            switch(type) {
                case FIGHTER: p = new Fighter(options, abilities, roll);
                case PLAYER: p = new Player(options, abilities, roll);
            }
        } catch(AbilityException ex) {
            fail(ex.getMessage());
        }
        return p;
    }

    protected boolean attack(Player player, Player opponent, int roll) {
        try {
            return player.attack(opponent, roll);
        } catch (AbilityException ex) {
            fail(ex.getMessage());
            return false;
        }
    }

    protected void setPlayerAbility(Player player, AbilityType type, int score) {
        try {
            player.setAbility(type, score);
        } catch (AbilityException ex) {
            fail(ex.getMessage());
        }
    }
}
