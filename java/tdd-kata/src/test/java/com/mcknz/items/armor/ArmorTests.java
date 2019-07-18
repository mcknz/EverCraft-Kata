package com.mcknz.items.armor;

import com.mcknz.AbstractTests;
import com.mcknz.constants.ValueType;
import com.mcknz.items.armor.exceptions.ArmorException;
import com.mcknz.items.shield.Hand;
import com.mcknz.items.weapon.Weapon;
import com.mcknz.player.Player;
import com.mcknz.player.PlayerOptions;
import com.mcknz.player.constants.Alignment;
import com.mcknz.player.constants.ClassType;
import com.mcknz.player.constants.RaceType;
import com.mcknz.player.exceptions.AlignmentException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.mcknz.player.constants.RaceType.HALFLING;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArmorTests extends AbstractTests {

    /*
    Feature: Armor

    As a character I want to be able to don armor and shield
        so that I can protect myself from attack
        - character can only don one shield and wear one suit of armor

    */
    @Test
    public void GivenAPlayer_WhenArmorAdded_ThenOnlyThatArmorIsAvailable() {
        Player player = getPlayer();
        Leather leather = new Leather();
        player.setArmor(leather);
        assertThat(player.getArmor(), is(leather));
    }

    /*
    Feature: Armor

    As a character I want to the be able to wear leather armor
        so that I can soften attacks against me
        - +2 to Armor Class

    */
    @Test
    public void GivenAPlayer_WhenLeatherArmorAdded_ThenNoHitOn11() {
        Player player = getPlayer();
        Player opponent = getPlayer();

        Leather leather = new Leather();
        opponent.setArmor(leather);

        assertThat(attack(player, opponent, 11), is(false));
    }

    /*
    Feature: Armor

    As a fighter (or dwarf) I want to be able to wear plate armor
        so that I can ignore the blows of my enemies
        - +8 to Armor Class
        - can only be worn by fighters (of any race) and dwarves (of any class)
    */
    @Test
    public void GivenAFighterDwarf_WhenPlateArmorAdded_ThenNoHitOn17() {
        Player player = getPlayer();
        Player opponent = getPlayer();

        Plate plate = new Plate();
        opponent.setArmor(plate);

        assertThat(attack(player, opponent, 17), is(false));
    }

    /*
    Feature: Armor

    As a fighter (or dwarf) I want to be able to wear plate armor
        so that I can ignore the blows of my enemies
        - can only be worn by fighters (of any race) and dwarves (of any class)
    */
    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    @Test
    public void GivenANonFighterDwarf_WhenPlateArmorAdded_ThenCannotBeWorn() {
        exceptionRule.expect(ArmorException.class);
        exceptionRule.expectMessage("Only fighters or dwarves can wear Plate armor.");
        Player player = getPlayer();
        player.setArmor(new Plate());
    }

}
