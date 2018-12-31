package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.abilities.constants.ValueType;
import com.mcknz.player.Player;
import com.mcknz.player.constants.Alignment;
import com.mcknz.player.constants.RaceType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OrcTests extends AbstractTests {

    /*
    Feature: Characters Have Races

    As a player I want to play an Orc so that I can be crude, drunk, and stupid
    */
    @Test
    public void GivenAnOrc_WhenCreated_ThenRaceTypeIsOrc() {
        Player player = getPlayer(RaceType.ORC);
        assertThat(player.getRaceType(), is(RaceType.ORC));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play an Orc so that I can be crude, drunk, and stupid
        - +2 to Strength Modifier
    */
    @Test
    public void GivenAnOrc_WhenCreated_ThenHasPlusTwoStrengthModifier() {
        Player orc = getPlayer(RaceType.ORC);
        assertThat(orc.getAbilityModifier(AbilityType.STRENGTH), is(2));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play an Orc so that I can be crude, drunk, and stupid
        - +2 to Strength Modifier, -1 to Intelligence, Wisdom, and Charisma Modifiers
    */
    @Test
    public void GivenAnOrc_WhenCreated_ThenHasNegativeOneIntelligenceModifier() {
        Player orc = getPlayer(RaceType.ORC);
        assertThat(orc.getAbilityModifier(AbilityType.INTELLIGENCE), is(-1));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play an Orc so that I can be crude, drunk, and stupid
        - +2 to Strength Modifier, -1 to Intelligence, Wisdom, and Charisma Modifiers
    */
    @Test
    public void GivenAnOrc_WhenCreated_ThenHasNegativeOneWisdomModifier() {
        Player orc = getPlayer(RaceType.ORC);
        assertThat(orc.getAbilityModifier(AbilityType.WISDOM), is(-1));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play an Orc so that I can be crude, drunk, and stupid
        - +2 to Strength Modifier, -1 to Intelligence, Wisdom, and Charisma Modifiers
    */
    @Test
    public void GivenAnOrc_WhenCreated_ThenHasNegativeOneCharismaModifier() {
        Player orc = getPlayer(RaceType.ORC);
        assertThat(orc.getAbilityModifier(AbilityType.CHARISMA), is(-1));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play an Orc so that I can be crude, drunk, and stupid
        - +2 to Armor Class due to thick hide
    */
    @Test
    public void GivenAnOrc_WhenCreated_ThenHasPlusTwoArmorClass() {
        Player orc = getPlayer(RaceType.ORC,10);
        assertThat(orc.getValue(ValueType.ARMOR), is(12));
    }
}
