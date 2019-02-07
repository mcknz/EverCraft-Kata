package com.mcknz.items.weapon;

import com.mcknz.AbstractTests;
import com.mcknz.constants.ValueType;
import com.mcknz.player.Player;
import com.mcknz.player.constants.ClassType;
import com.mcknz.player.constants.RaceType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WeaponTests extends AbstractTests {

    /*
    Feature: Weapons

    As a character I want to be able to wield a single weapon
    so that I can achieve victory through superior firepower
        - character can wield only one weapon

    */
    @Test
    public void GivenAPlayer_WhenWeaponAdded_ThenOnlyThatWeaponIsAvailable() {
        Player player = getPlayer();
        Weapon weapon = new Longsword();
        player.setWeapon(weapon);
        assertThat(player.getWeapon(), is(weapon));
    }

    /*
    Feature: Weapons

    As a character I want to be able to wield a longsword so that I can look cool
        - does 5 points of damage
    */
    @Test
    public void GivenAPlayer_WhenAttackingWithLongsword_ThenOpponentTakesFiveDamage() {
        Player player = getPlayer();
        Player opponent = getPlayer();

        Longsword longsword = new Longsword();
        player.setWeapon(longsword);
        attack(player, opponent, 19);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(5));
    }

    /*
    Feature: Weapons

        As a monk I want nun chucks that work with my martial arts
            so that I can kick ass like Chuck Norris

            - does 6 points of damage
            - when used by a non-monk there is a -4 penalty to attack
    */
    @Test
    public void GivenAMonk_WhenAttackingWithNunchucks_ThenOpponentTakesSixDamage() {
        Player monk = getPlayer(ClassType.MONK);
        Player opponent = getPlayer(RaceType.HUMAN);

        Nunchucks chucks = new Nunchucks();
        monk.setWeapon(chucks);
        attack(monk, opponent, 15);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(4));
    }

    /*
Feature: Weapons

    As a monk I want nun chucks that work with my martial arts
        so that I can kick ass like Chuck Norris

        - when used by a non-monk there is a -4 penalty to attack
*/
    @Test
    public void GivenAFighter_WhenAttackingWithNunchucks_ThenDoesNotHit10On13() {
        Player fighter = getPlayer(ClassType.FIGHTER);
        Player opponent = getPlayer(RaceType.HUMAN);

        Nunchucks chucks = new Nunchucks();
        fighter.setWeapon(chucks);

        assertThat(attack(fighter, opponent, 13), is(false));
    }
}
