package com.mcknz.items.shield;

import com.mcknz.AbstractTests;
import com.mcknz.player.Player;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShieldTests extends AbstractTests {

    /*
    Feature: Armor

    As a character I want to be able to don armor and shield
        so that I can protect myself from attack
        - character can only don one shield and wear one suit of armor
    */
    @Test
    public void GivenAPlayer_WhenShieldAdded_ThenOnlyThatShieldIsAvailable() {
        Player player = getPlayer();

        Hand hand = new Hand();
        player.setShield(hand);

        assertThat(player.getShield(), is(hand));
    }
}
