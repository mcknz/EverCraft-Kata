package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.abilities.constants.ValueType;
import com.mcknz.player.constants.Alignment;
import com.mcknz.player.constants.ClassType;
import com.mcknz.player.exceptions.AlignmentException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FighterTests extends AbstractTests {

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters
    */
    @Test
    public void GivenAFighter_WhenCreated_ThenHasPlayerClassFighter() {
        Player fighter = getPlayer(ClassType.FIGHTER);
        assertThat(fighter.getClassType(), is(ClassType.FIGHTER));
    }

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
        Player fighter = getPlayer(ClassType.FIGHTER);

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
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

        As a player I want to play a Rogue so that I can defeat my enemies with finesse
            - does triple damage on critical hits
    */
    @Test
    public void GivenARogue_WhenGetsCriticalHitOnOpponent_ThenDamageIsTripled() {
        Player rogue = getPlayer(ClassType.ROGUE);

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        attack(rogue, opponent, 20);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(7));
    }

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters

        As a player I want to play a Rogue so that I can defeat my enemies with finesse
            - ignores an opponents Dexterity modifier (if positive) to Armor Class when attacking
    */
    @Test
    public void GivenARogue_WhenOpponentHasPositiveDexterity_ThenOpponentDexterityIsIgnored() {
        Player rogue = getPlayer(ClassType.ROGUE);

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        setPlayerAbility(opponent, AbilityType.DEXTERITY, 15);

        assertThat(attack(rogue, opponent, 10), is(true));
    }

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters

        As a player I want to play a Rogue so that I can defeat my enemies with finesse
            - adds Dexterity modifier to attacks instead of Strength
            - cannot have Good alignment
    */
    @Test
    public void GivenARogue_WhenHasDexterity_ThenAddedToAttacksInsteadOfStrength() {
        Player rogue = getPlayer(ClassType.ROGUE);

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        setPlayerAbility(rogue, AbilityType.DEXTERITY, 15);

        assertThat(attack(rogue, opponent, 8), is(true));
    }

    /*
    Feature: Characters Have Classes
        As a player I want a character to have a class that customizes its capabilities
        so that I can play more interesting characters

        As a player I want to play a Rogue so that I can defeat my enemies with finesse
            - cannot have Good alignment
    */
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void GivenARogue_WhenCreated_ThenCannotHaveGoodAlignment() throws AlignmentException {
        exceptionRule.expect(AlignmentException.class);
        exceptionRule.expectMessage("Rogue cannot have good alignment.");
        getPlayer(
            new PlayerOptions(
                ClassType.ROGUE,
                Alignment.GOOD)
        );
    }
}
