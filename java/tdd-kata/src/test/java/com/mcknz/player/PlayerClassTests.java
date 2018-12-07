package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.abilities.constants.ValueType;
import com.mcknz.player.constants.Alignment;
import com.mcknz.player.constants.PlayerClass;
import com.mcknz.player.constants.PlayerOptions;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerClassTests extends AbstractTests {

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters

        As a player I want to play a Fighter so that I can kick ass and take names
            - attacks roll is increased by 1 for every level instead of every other level
            - has 10 hit points per level instead of 5

    */
    @Test
    public void GivenAFighterWithLevel4_WhenOpponentArmorClassIs10AndRollIs6_ThenOpponentIsHit() {
        Player fighter = getStandardPlayer(PlayerClass.FIGHTER);

        Player opponent = getStandardPlayer(
            new PlayerOptions(10, 10)
        );

        for(int i = 0; i < 300; i++ ) {
            attack(fighter, opponent, 19);
        }

        assertThat(attack(fighter, opponent, 6), is(true));
    }

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters

        As a player I want to play a Fighter so that I can kick ass and take names
            - attacks roll is increased by 1 for every level instead of every other level
            - has 10 hit points per level instead of 5

    */
    /*
    @Test
    public void GivenAPlayerWith20Constitution_WhenPlayerHitsOpponent200Times_ThenHitPointsAre25() {
        Player player = getStandardPlayer();
        setPlayerAbility(player, AbilityType.CONSTITUTION, 20);

        Player opponent = getStandardPlayer(
            new PlayerOptions(10, 10)
        );

        for(int i = 0; i < 200; i++ ) {
            attack(player, opponent, 19);
        }

        assertThat(player.getValue(ValueType.HIT_POINTS), is(25));
    }
    */
}
