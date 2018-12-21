package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.abilities.constants.ValueType;
import com.mcknz.player.constants.Alignment;
import com.mcknz.player.constants.PlayerClass;
import com.mcknz.player.exceptions.AlignmentException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MonkTests extends AbstractTests {

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters
    */
    @Test
    public void GivenAMonk_WhenCreated_ThenHasPlayerClassMonk() {
        Player monk = getPlayer(PlayerClass.MONK);
        assertThat(monk.getPlayerClass(), is(PlayerClass.MONK));
    }

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters

        As a player I want to play a Monk
        so that I can enjoy being an Asian martial-arts archetype in a Medieval European setting
            - has 6 hit point per level instead of 5
    */
    @Test
    public void GivenAMonk_WhenLevel2_ThenHasSixAdditionalHitPoints() {

        Player monk = getPlayer(PlayerClass.MONK);

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        setPlayerLevel(monk, opponent, 2);

        assertThat(monk.getValue(ValueType.HIT_POINTS), is(16));
    }

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters

        As a player I want to play a Monk
        so that I can enjoy being an Asian martial-arts archetype in a Medieval European setting
            - does 3 points of damage instead of 1 when successfully attacking
    */
    @Test
    public void GivenAMonk_WhenHitsOpponent_ThenDoes3PointsOfDamage() {

        Player monk = getPlayer(PlayerClass.MONK);

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        attack(monk, opponent, 19);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(7));
    }

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters

        As a player I want to play a Monk
        so that I can enjoy being an Asian martial-arts archetype in a Medieval European setting
            - adds Wisdom modifier (if positive) to Armor Class in addition to Dexterity
    */
    @Test
    public void GivenAMonk_WhenHasPositiveWisdom_ThenModifierAddedToArmorClass() {

        Player monk = getPlayer(PlayerClass.MONK);

        setPlayerAbility(monk, AbilityType.WISDOM, 15);

        assertThat(monk.getValue(ValueType.ARMOR), is(12));
    }

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters

        As a player I want to play a Monk
        so that I can enjoy being an Asian martial-arts archetype in a Medieval European setting
            - attack roll is increased by 1 every 2nd and 3rd level
    */
    @Test
    public void GivenAMonk_WhenLevel6_ThenAttackRollIsIncreasedBy5() {

        Player monk = getPlayer(PlayerClass.MONK);

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        setPlayerLevel(monk, opponent, 6);

        assertThat(attack(monk, opponent, 5), is(true));
    }
}
