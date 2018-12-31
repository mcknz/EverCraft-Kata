package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.player.Player;
import com.mcknz.player.constants.RaceType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RaceTests extends AbstractTests {

    /*
    Feature: Characters Have Races

    As a player I want to play a Human so that I can be boring and unoriginal
        - all characters default to Human
    */
    @Test
    public void GivenAPlayer_WhenCreated_ThenDefaultsToHuman() {
        Player player = getPlayer();
        assertThat(player.getRaceType(), is(RaceType.HUMAN));
    }
}
