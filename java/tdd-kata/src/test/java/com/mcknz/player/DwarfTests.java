package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.constants.ValueType;
import com.mcknz.player.constants.RaceType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DwarfTests extends AbstractTests {

    /*
    Feature: Characters Have Races

    As a player I want to play a Dwarf so that I can drink more than the orc
    */
    @Test
    public void GivenADwarf_WhenCreated_ThenRaceTypeIsDwarf() {
        Player player = getPlayer(RaceType.DWARF);
        assertThat(player.getRaceType(), is(RaceType.DWARF));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play a Dwarf so that I can drink more than the orc
        - +1 to Constitution Modifier, -1 to Charisma Modifier
    */
    @Test
    public void GivenADwarf_WhenCreated_ThenHasPlusOneConstitutionModifier() {
        Player dwarf = getPlayer(RaceType.DWARF);
        assertThat(dwarf.getAbilityModifier(AbilityType.CONSTITUTION), is(1));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play a Dwarf so that I can drink more than the orc
        - +1 to Constitution Modifier, -1 to Charisma Modifier
    */
    @Test
    public void GivenADwarf_WhenCreated_ThenHasMinusOneCharismaModifier() {
        Player dwarf = getPlayer(RaceType.DWARF);
        assertThat(dwarf.getAbilityModifier(AbilityType.CHARISMA), is(-1));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play a Dwarf so that I can drink more than the orc
        - doubles Constitution Modifier when adding to hit points per level (if positive)
    */
    @Test
    public void GivenADwarfWithPlusOneConstitutionModifier_WhenHasLevelThree_ThenHasPlusFourConstitutionModifier() {
        Player dwarf = getPlayer(RaceType.DWARF);
        Player opponent = getPlayer(
            getPlayerOptions(10,10)
        );
        setPlayerAbility(dwarf, AbilityType.CONSTITUTION, 12);
        int level = 3;
        for(int i = 0; i < (level - 1) * 100; i++ ) {
            attack(dwarf, opponent, 19);
        }
        assertThat(dwarf.getAbilityModifier(AbilityType.CONSTITUTION), is(4));
    }

    /*
    Feature: Characters Have Races

    As a player I want to play a Dwarf so that I can drink more than the orc
        - +2 bonus to attack/damage when attacking orcs (Dwarves hate Orcs)
    */
    @Test
    public void GivenADwarf_WhenAttackingAnOrc_ThenHasPlusTwoAttackAndDamage() {
        Player dwarf = getPlayer(RaceType.DWARF, 10);
        Player orc = getPlayer(RaceType.ORC, 10, 10);

        // orc has +2 armor, so roll of 10 should boost to hit
        attack(dwarf, orc, 10);

        assertThat(orc.getValue(ValueType.HIT_POINTS), is(7));
    }
}
