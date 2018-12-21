package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.abilities.constants.ValueType;
import com.mcknz.player.constants.Alignment;
import com.mcknz.player.constants.ClassType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PaladinTests extends AbstractTests {

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters
    */
    @Test
    public void GivenAPaladin_WhenCreated_ThenHasPlayerClassPaladin() {
        Player monk = getPlayer(ClassType.PALADIN);
        assertThat(monk.getClassType(), is(ClassType.PALADIN));
    }

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters

        As a player I want to play a Paladin
        so that I can smite evil, write wrongs, and be a self-righteous jerk
            - has 8 hit points per level instead of 5
    */
    @Test
    public void GivenAPaladin_WhenLevel2_ThenHasEightAdditionalHitPoints() {

        Player paladin = getPlayer(ClassType.PALADIN);

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        setPlayerLevel(paladin, opponent, 2);

        assertThat(paladin.getValue(ValueType.HIT_POINTS), is(18));
    }

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters

        As a player I want to play a Paladin
        so that I can smite evil, write wrongs, and be a self-righteous jerk
            - +2 to attack and damage when attacking Evil characters
            - does triple damage when critting on an Evil character
                (i.e. add the +2 bonus for a regular attack, and then triple that)
            - attacks roll is increased by 1 for every level instead of every other level
            - can only have Good alignment
    */
    @Test
    public void GivenAPaladin_WhenAttackingEvilPlayer_ThenDoesPlusTwoDamageAndAttack() {

        Player paladin = getPlayer(ClassType.PALADIN);

        Player opponent = getPlayer(
            getPlayerOptions(Alignment.EVIL, 10,10)
        );

        attack(paladin, opponent, 8);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(7));
    }
}
