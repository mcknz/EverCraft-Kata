package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.abilities.constants.ValueType;
import com.mcknz.player.constants.RaceType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ElfTests extends AbstractTests {

    /*
    Feature: Characters Have Races

    As a player I want to play an Elf so that I can drink wine and snub my nose at the crude dwarf and orc
    */
    @Test
    public void GivenAnElf_WhenCreated_ThenRaceTypeIsElf() {
        Player player = getPlayer(RaceType.ELF);
        assertThat(player.getRaceType(), is(RaceType.ELF));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play an Elf so that I can drink wine and snub my nose at the crude dwarf and orc
        - +1 to Dexterity Modifier, -1 to Constitution Modifier
        - does adds 1 to critical range for critical hits (20 -> 19-20, 19-20 -> 18-20)
        - +2 to Armor Class when being attacked by orcs
    */
    @Test
    public void GivenAnElf_WhenCreated_ThenHasPlusOneDexterityModifier() {
        Player elf = getPlayer(RaceType.ELF);
        assertThat(elf.getAbilityModifier(AbilityType.DEXTERITY), is(1));
    }

}
