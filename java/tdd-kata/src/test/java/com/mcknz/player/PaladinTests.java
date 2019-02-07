package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.constants.ValueType;
import com.mcknz.player.constants.Alignment;
import com.mcknz.player.constants.ClassType;
import com.mcknz.player.exceptions.AlignmentException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PaladinTests extends AbstractTests {

    Player getPaladin() {
        return getPlayer(getPlayerOptions(ClassType.PALADIN, Alignment.GOOD));
    }

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters
    */
    @Test
    public void GivenAPaladin_WhenCreated_ThenHasPlayerClassPaladin() {
        Player paladin = getPaladin();
        assertThat(paladin.getClassType(), is(ClassType.PALADIN));
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

        Player paladin = getPaladin();

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
    */
    @Test
    public void GivenAPaladin_WhenAttackingEvilPlayer_ThenDoesPlusTwoDamageAndAttack() {

        Player paladin = getPaladin();

        Player opponent = getPlayer(
            getPlayerOptions(Alignment.EVIL, 10,10)
        );

        attack(paladin, opponent, 8);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(7));
    }

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters

        As a player I want to play a Paladin
        so that I can smite evil, write wrongs, and be a self-righteous jerk
            - +2 to attack and damage when attacking Evil characters
    */
    @Test
    public void GivenAPaladin_WhenAttackingNeutralPlayer_ThenDoesNormalDamageAndAttack() {

        Player paladin = getPaladin();

        Player opponent = getPlayer(
            getPlayerOptions(Alignment.NEUTRAL, 10,10)
        );

        attack(paladin, opponent, 10);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(9));
    }

    /*
    Feature: Characters Have Classes
    As a player I want a character to have a class that customizes its capabilities
    so that I can play more interesting characters

    As a player I want to play a Paladin
    so that I can smite evil, write wrongs, and be a self-righteous jerk
        - does triple damage when critting on an Evil character
            (i.e. add the +2 bonus for a regular attack, and then triple that)
    */
    @Test
    public void GivenAPaladin_WhenMakesCriticalHit_ThenDoesThreeTimesDamage() {

        Player paladin = getPaladin();

        Player opponent = getPlayer(
            getPlayerOptions(Alignment.EVIL, 10,10)
        );

        attack(paladin, opponent, 20);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(1));
    }

    /*
    Feature: Characters Have Classes
    As a player I want a character to have a class that customizes its capabilities
    so that I can play more interesting characters

    As a player I want to play a Paladin
    so that I can smite evil, write wrongs, and be a self-righteous jerk
        - attacks roll is increased by 1 for every level instead of every other level
    */
    @Test
    public void GivenAPaladin_WhenAttacking_ThenRollIsIncreasedByOneForEveryLevel() {

        Player paladin = getPaladin();

        setPlayerLevel(paladin, 3);

        Player opponent = getPlayer(
            getPlayerOptions(10,10)
        );

        assertThat(attack(paladin, opponent, 7), is(true));
    }

    /*
    Feature: Characters Have Classes
    As a player I want a character to have a class that customizes its capabilities
    so that I can play more interesting characters

    As a player I want to play a Paladin
    so that I can smite evil, write wrongs, and be a self-righteous jerk
        - can only have Good alignment
    */
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void GivenAPaladin_WhenCreated_ThenCanOnlyHaveGoodAlignment() throws AlignmentException {
        exceptionRule.expect(AlignmentException.class);
        exceptionRule.expectMessage("A Paladin must have good alignment.");
        getPlayer(
            new PlayerOptions(
                ClassType.PALADIN,
                Alignment.NEUTRAL)
        );
    }
}

