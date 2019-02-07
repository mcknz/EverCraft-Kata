package com.mcknz.items.weapon;

import com.mcknz.AbstractTests;
import com.mcknz.constants.ValueType;
import com.mcknz.player.Player;
import com.mcknz.player.constants.ClassType;
import com.mcknz.player.constants.RaceType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WaraxeTests extends AbstractTests {

    /*
    Feature: Weapons

    As a character I want to be able to wield a +2 waraxe that so that I can be cool
        - does 6 points of damage
        - does +2 to damage
    */

    @Test
    public void GivenAPlayer_WhenAttackingWithAPlusTwoWarAxe_ThenOpponentTakesEightDamage() {
        Player player = getPlayer();
        Player opponent = getPlayer();

        setWaraxe(player);
        attack(player, opponent, 10);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(2));
    }

    /*
    Feature: Weapons

    As a character I want to be able to wield a +2 waraxe that so that I can be cool
        - +2 to attack
    */

    @Test
    public void GivenAPlayer_WhenAttackingWithAPlusTwoWarAxe_ThenAddsTwoToAttack() {
        Player player = getPlayer();
        Player opponent = getPlayer();

        setWaraxe(player);

        assertThat(attack(player, opponent, 8), is(true));
    }


    /*
    Feature: Weapons

    As a character I want to be able to wield a +2 waraxe that so that I can be cool
        - triple damage on a critical (quadruple for a Rogue)
    */

    @Test
    public void GivenAPlayer_WhenAttackingWithAPlusTwoWarAxe_ThenDoesTripleDamageOnCritical() {
        Player player = getPlayer();
        Player opponent = getPlayer(getPlayerOptions(10,50));

        setWaraxe(player);
        attack(player, opponent, 20);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(26));
    }

    /*
    Feature: Weapons

    As a character I want to be able to wield a +2 waraxe that so that I can be cool
        - triple damage on a critical (quadruple for a Rogue)
    */

    @Test
    public void GivenAPlayer_WhenAttackingRogueWithAPlusTwoWarAxe_ThenDoesQuadDamageOnCritical() {
        Player player = getPlayer();
        Player opponent = getPlayer(getPlayerOptions(ClassType.ROGUE,10,50));

        setWaraxe(player);
        attack(player, opponent, 20);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(18));
    }
}
