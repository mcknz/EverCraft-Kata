package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.abilities.constants.ValueType;
import com.mcknz.player.constants.Alignment;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerTests extends AbstractTests {

    /*
    Feature: Create a Character
        As a character I want to have a name so that I can be distinguished from other characters
            - can get and set Name
    */
    @Test
    public void GivenAPlayer_WhenCreated_ThenShouldHaveAName() {
        PlayerOptions options = getPlayerOptions("Gandalf");
        assertThat(getPlayer(options).getName(), is("Gandalf"));
    }

    /*
    Feature: Alignment
        As a character I want to have an alignment so that I have something to guide my actions
            - can get and set alignment
            - alignments are Good, Evil, and Neutral
     */
    @Test
    public void GivenAPlayer_WhenCreated_ThenShouldHaveAnAlignment() {
        PlayerOptions options = getPlayerOptions(Alignment.EVIL);
        assertThat(getPlayer(options).getAlignment(), is(Alignment.EVIL));
    }

    /*
    Feature: Armor Class & Hit Points
    As a combatant I want to have an armor class and hit points so that I can resist attacks from my enemies
        - has an Armor Class that defaults to 10
        - has 5 Hit Points by default
    */
    @Test
    public void GivenAPlayer_WhenCreated_ThenHasArmorAndHitPoints() {
        Player player = getPlayer(
            getPlayerOptions(10, 5)
        );
        assertThat(player.getValue(ValueType.ARMOR), is(10));
        assertThat(player.getValue(ValueType.HIT_POINTS), is(5));
    }

    /*
    Feature: Character Can Attack
        As a combatant I want to be able to attack other combatants so that I can survive to fight another day
            - roll a 20 sided die (don't code the die)
            - roll must meet or beat opponents armor class to hit
    */
    @Test
    public void GivenAPlayerAttack_WhenDieRolls10AndOpponentArmorClassIs8_ThenOpponentIsHit() {

        Player player = getPlayer();

        Player opponent = getPlayer(
            getPlayerOptions(8,4)
        );

        assertThat(attack(player, opponent, 10), is(true));
    }

    /*
    Feature: Character Can Be Damaged
        As an attacker I want to be able to damage my enemies so that they will die and I will live
            - If attack is successful, other character takes 1 point of damage when hit
    */
    @Test
    public void GivenAPlayerAttack_WhenDieRolls10AndOpponentArmorClassIs8_ThenOpponentTakesOneHitPointLoss() {

        int opponentHitPoints = 5;
        int rollValue = 10;

        Player player = getPlayer();

        Player opponent = getPlayer(
            getPlayerOptions(8, opponentHitPoints)
        );

        attack(player, opponent, rollValue);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(opponentHitPoints - 1));
    }

    /*
    Feature: Character Can Be Damaged
        As an attacker I want to be able to damage my enemies so that they will die and I will live
            - If a roll is a natural 20 then a critical hit is dealt and the damage is doubled
    */
    @Test
    public void GivenAPlayerAttack_WhenDieRolls20AndOpponentArmorClassIs8_ThenOpponentTakesDoubleDamagePointLoss() {

        int opponentHitPoints = 5;
        int rollValue = 20;

        Player player = getPlayer();

        Player opponent = getPlayer(
            getPlayerOptions(8, opponentHitPoints)
        );

        attack(player, opponent, rollValue);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(opponentHitPoints - 2));
    }

    /*
        Feature: Character Can Be Damaged
            As an attacker I want to be able to damage my enemies so that they will die and I will live
                - when hit points are 0 or less, the character is dead
    */
    @Test
    public void GivenAPlayerAttack_WhenOpponentLosesLastHitPoint_ThenOpponentIsDead() {

        int opponentHitPoints = 1;
        int rollValue = 20;

        Player player = getPlayer();

        Player opponent = getPlayer(
            getPlayerOptions(8, opponentHitPoints)
        );

        attack(player, opponent, rollValue);

        assertThat(opponent.isDead(), is(true));
    }
}
