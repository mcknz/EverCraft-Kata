package com.mcknz;

import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.abilities.exceptions.AbilityException;
import com.mcknz.player.*;
import com.mcknz.player.constants.*;
import com.mcknz.player.exceptions.AlignmentException;

import static org.junit.Assert.fail;

public abstract class AbstractTests {

    protected PlayerOptions getPlayerOptions() {
        try {
            return new PlayerOptions(PlayerClass.PLAYER, 10, 10);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(Alignment alignment) {
        try {
            return new PlayerOptions(PlayerClass.PLAYER, alignment, 10, 10);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(String name) {
        try {
            return new PlayerOptions(PlayerClass.PLAYER, name, 10, 10);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(int armorClass, int hitPoints) {
        try {
            return new PlayerOptions(PlayerClass.PLAYER, armorClass, hitPoints);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(PlayerClass playerClass, int armorClass, int hitPoints) {
        try {
            return new PlayerOptions(playerClass, armorClass, hitPoints);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected Player getPlayer() {
        return getPlayer(getPlayerOptions());
    }

    protected Player getPlayer(PlayerClass playerClass) {
        return getPlayer(getPlayerOptions(playerClass,10,10));
    }

    protected Player getPlayer(PlayerOptions options) {
        try {
            return new PlayerFactory().getPlayer(options);
        } catch(AbilityException ex) {
            fail(ex.getMessage());
        }
        return null;
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

    protected void setPlayerLevel(Player player, Player opponent, int level) {
        if(level == 1) {
            return;
        }
        for(int i = 0; i < (level - 1) * 100; i++ ) {
            attack(player, opponent, 19);
        }
    }
}
