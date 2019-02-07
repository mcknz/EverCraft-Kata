package com.mcknz.items.armor;

import com.mcknz.AbstractTests;
import com.mcknz.constants.ValueType;
import com.mcknz.items.weapon.Weapon;
import com.mcknz.player.Player;
import com.mcknz.player.constants.ClassType;
import com.mcknz.player.constants.RaceType;
import org.junit.Test;

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
    Feature: Weapons

    As a character I want to be able to wield a longsword so that I can look cool
        - does 5 points of damage

    @Test
    public void GivenAPlayer_WhenAttackingWithLongsword_ThenOpponentTakesFiveDamage() {
        Player player = getPlayer();
        Player opponent = getPlayer();

        Longsword longsword = new Longsword();
        player.setWeapon(longsword);
        attack(player, opponent, 19);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(5));
    }
*/

}
