package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.constants.ValueType;
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
    */
    @Test
    public void GivenAnElf_WhenCreated_ThenHasPlusOneDexterityModifier() {
        Player elf = getPlayer(RaceType.ELF);
        assertThat(elf.getAbilityModifier(AbilityType.DEXTERITY), is(1));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play an Elf so that I can drink wine and snub my nose at the crude dwarf and orc
        - +1 to Dexterity Modifier, -1 to Constitution Modifier
    */
    @Test
    public void GivenAnElf_WhenCreated_ThenHasNegativeOneConstitutionModifier() {
        Player elf = getPlayer(RaceType.ELF);
        assertThat(elf.getAbilityModifier(AbilityType.CONSTITUTION), is(-1));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play an Elf so that I can drink wine and snub my nose at the crude dwarf and orc
        - does adds 1 to critical range for critical hits (20 -> 19-20, 19-20 -> 18-20)
    */
    @Test
    public void GivenAnElf_WhenAttacking_ThenDoesCriticalHitOn19() {
        Player elf = getPlayer(RaceType.ELF);
        Player opponent = getPlayer(RaceType.HUMAN,10, 10);
        attack(elf, opponent, 19);
        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(8));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play an Elf so that I can drink wine and snub my nose at the crude dwarf and orc
        - +2 to Armor Class when being attacked by orcs
    */
    @Test
    public void GivenAnElf_WhenAttackedByOrcs_ThenDoesHasPlusTwoArmor() {
        Player elf = getPlayer(RaceType.ELF, 10, 10);
        Player opponent = getPlayer(RaceType.ORC,10, 10);

        // orc has +2 roll so 9 = 11
        assertThat(attack(opponent, elf, 9), is(false));
    }

}
