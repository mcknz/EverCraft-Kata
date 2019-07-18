package com.mcknz;

import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.abilities.exceptions.AbilityException;
import com.mcknz.items.weapon.Waraxe;
import com.mcknz.player.*;
import com.mcknz.player.constants.*;
import com.mcknz.player.exceptions.AlignmentException;
import com.mcknz.player.constants.RaceType;

import static org.junit.Assert.fail;

public abstract class AbstractTests {

    protected PlayerOptions getPlayerOptions() {
        try {
            return new PlayerOptions(ClassType.PLAYER, RaceType.HUMAN, 10, 10);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(Alignment alignment) {
        try {
            return new PlayerOptions(ClassType.PLAYER, RaceType.HUMAN, alignment, 10, 10);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(String name) {
        try {
            return new PlayerOptions(ClassType.PLAYER, RaceType.HUMAN, name, 10, 10);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(int armorClass, int hitPoints) {
        try {
            return new PlayerOptions(ClassType.PLAYER, RaceType.HUMAN, armorClass, hitPoints);
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

    protected PlayerOptions getPlayerOptions(ClassType classType, Alignment alignment) {
        try {
            return new PlayerOptions(classType, RaceType.HUMAN,  alignment, 10, 10);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(RaceType raceType, Alignment alignment) {
        try {
            return new PlayerOptions(ClassType.PLAYER, raceType, alignment, 10, 10);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(RaceType raceType, int armorClass) {
        try {
            return new PlayerOptions(ClassType.PLAYER, raceType, Alignment.NEUTRAL, armorClass, 10);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(RaceType raceType, int armorClass, int hitPoints) {
        try {
            return new PlayerOptions(ClassType.PLAYER, raceType, Alignment.NEUTRAL, armorClass, hitPoints);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected PlayerOptions getPlayerOptions(ClassType classType, int armorClass, int hitPoints) {
        try {
            return new PlayerOptions(classType, RaceType.HUMAN, Alignment.NEUTRAL, armorClass, hitPoints);
        } catch(AlignmentException ex) {
            fail(ex.getMessage());
        }
        return null;
    }

    protected Player getPlayer() {
        return getPlayer(getPlayerOptions());
    }

    protected Player getPlayer(ClassType classType) {
        return getPlayer(getPlayerOptions(classType, Alignment.NEUTRAL));
    }

    protected Player getPlayer(RaceType raceType) {
        return getPlayer(getPlayerOptions(raceType, Alignment.NEUTRAL));
    }

    protected Player getPlayer(RaceType raceType, int armorClass) {
        return getPlayer(getPlayerOptions(raceType, armorClass));
    }

    protected Player getPlayer(RaceType raceType, int armorClass, int hitPoints) {
        return getPlayer(getPlayerOptions(raceType, armorClass, hitPoints));
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

    protected void setWaraxe(Player player) {
        player.setWeapon(new Waraxe(2));
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
