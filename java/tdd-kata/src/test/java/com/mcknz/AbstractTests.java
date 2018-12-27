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
            return new PlayerOptions(ClassType.PLAYER, 10, 10);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(Alignment alignment) {
        try {
            return new PlayerOptions(ClassType.PLAYER, alignment, 10, 10);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(String name) {
        try {
            return new PlayerOptions(ClassType.PLAYER, name, 10, 10);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(int armorClass, int hitPoints) {
        try {
            return new PlayerOptions(ClassType.PLAYER, armorClass, hitPoints);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(Alignment alignment, int armorClass, int hitPoints) {
        try {
            return new PlayerOptions(alignment, armorClass, hitPoints);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(ClassType classType, int armorClass, int hitPoints) {
        try {
            return new PlayerOptions(classType, armorClass, hitPoints);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected Player getPlayer() {
        return getPlayer(getPlayerOptions());
    }

    protected Player getPlayer(ClassType classType) {
        return getPlayer(getPlayerOptions(classType,10,10));
    }

    protected Player getPlayer(PlayerOptions options) {
        try {
            return new PlayerFactory().getPlayer(options);
        } catch(AbilityException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected boolean attack(Player player, Player opponent, int rollValue) {
        try {
            return new Battle(player, opponent).engage(rollValue);
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

    protected void setPlayerLevel(Player player, int level) {
        Player opponent = getPlayer(
            getPlayerOptions(10,10)
        );
        setPlayerLevel(player, opponent, level);
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
