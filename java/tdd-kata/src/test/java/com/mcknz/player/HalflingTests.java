package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.abilities.constants.ValueType;
import com.mcknz.player.constants.RaceType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HalflingTests extends AbstractTests {

    /*
    Feature: Characters Have Races

    As a player I want to play a Halfling so that I can steal from the other drunk characters
        - +1 to Dexterity Modifier, -1 to Strength Modifier
        - +2 to Armor Class when being attacked by non Halfling (they are small and hard to hit)
        - cannot have Evil alignment
    */
    @Test
    public void GivenAHalfling_WhenCreated_ThenRaceTypeIsHalfling() {
        Player player = getPlayer(RaceType.HALFLING);
        assertThat(player.getRaceType(), is(RaceType.HALFLING));
    }

}
