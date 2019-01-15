package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.abilities.constants.ValueType;
import com.mcknz.player.constants.Alignment;
import com.mcknz.player.constants.ClassType;
import com.mcknz.player.constants.RaceType;
import com.mcknz.player.exceptions.AlignmentException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

    /*
    Feature: Characters Have Races

    As a player I want to play a Halfling so that I can steal from the other drunk characters
        - +1 to Dexterity Modifier, -1 to Strength Modifier
    */
    @Test
    public void GivenAHalfling_WhenCreated_ThenHasPlusOneDexterityModifier() {
        Player halfling = getPlayer(RaceType.HALFLING);
        assertThat(halfling.getAbilityModifier(AbilityType.DEXTERITY), is(1));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play a Halfling so that I can steal from the other drunk characters
        - +1 to Dexterity Modifier, -1 to Strength Modifier
    */
    @Test
    public void GivenAHalfling_WhenCreated_ThenHasNegativeOneStrengthModifier() {
        Player halfling = getPlayer(RaceType.HALFLING);
        assertThat(halfling.getAbilityModifier(AbilityType.STRENGTH), is(-1));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play a Halfling so that I can steal from the other drunk characters
        - +2 to Armor Class when being attacked by non Halfling (they are small and hard to hit)
    */
    @Test
    public void GivenAHalfling_WhenAttackedByNonHalfling_ThenHasPlusTwoArmorClass() {
        Player halfling = getPlayer(RaceType.HALFLING, 10, 10);
        Player elf = getPlayer(RaceType.ELF, 10, 10);
        assertThat(attack(elf, halfling, 11), is(false));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play a Halfling so that I can steal from the other drunk characters
        - cannot have Evil alignment
    */
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void GivenAHalfling_WhenCreated_ThenCannotHaveEvilAlignment() throws AlignmentException {
        exceptionRule.expect(AlignmentException.class);
        exceptionRule.expectMessage("Halfling cannot have evil alignment.");
        getPlayer(
            new PlayerOptions(ClassType.PLAYER, RaceType.HALFLING, "Player", Alignment.EVIL)
        );
    }
}
