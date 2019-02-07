package com.mcknz.items.weapon;

import com.mcknz.AbstractTests;
import com.mcknz.constants.ValueType;
import com.mcknz.player.Player;
import com.mcknz.player.constants.ClassType;
import com.mcknz.player.constants.RaceType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ElvenLongswordTests extends AbstractTests {

    /*
    Feature: Weapons

    As an elf I want to be able to wield a elven longsword
     so that I can stick it to that orc with the waraxe

        - does 5 points of damage
        - +1 to attack and damage
    */

    @Test
    public void GivenAHuman_WhenAttackingWithAnElevenLongSword_ThenOpponentTakesSixDamage() {
        Player human = getPlayer(RaceType.HUMAN);
        Player opponent = getPlayer(RaceType.HUMAN);

        ElvenLongsword sword = new ElvenLongsword(1);
        human.setWeapon(sword);
        attack(human, opponent, 10);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(4));
    }

    /*
    Feature: Weapons

    As an elf I want to be able to wield a elven longsword
     so that I can stick it to that orc with the waraxe

        - +2 to attack and damage when wielded by an elf or against an orc
    */

    @Test
    public void GivenAnElf_WhenAttackingWithAnElevenLongSword_ThenOpponentTakesEightDamage() {
        Player elf = getPlayer(RaceType.ELF);
        Player opponent = getPlayer();

        ElvenLongsword sword = new ElvenLongsword(1);
        elf.setWeapon(sword);
        attack(elf, opponent, 10);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(2));
    }

    /*
    Feature: Weapons

    As an elf I want to be able to wield a elven longsword
     so that I can stick it to that orc with the waraxe

        - +2 to attack and damage when wielded by an elf or against an orc
    */

    @Test
    public void GivenAHuman_WhenAttackingWithAnElevenLongSword_ThenOpponentTakesEightDamage() {
        Player human = getPlayer(RaceType.HUMAN);
        Player opponent = getPlayer(RaceType.ORC);

        ElvenLongsword sword = new ElvenLongsword(1);
        human.setWeapon(sword);
        attack(human, opponent, 15);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(2));
    }

    /*
    Feature: Weapons

    As an elf I want to be able to wield a elven longsword
     so that I can stick it to that orc with the waraxe

        - +5 to attack and damage when wielded by an elf and against orc
    */

    @Test
    public void GivenAnElf_WhenAttackingOrcWithAnElevenLongSword_ThenOpponentTakesElevenDamage() {
        Player elf = getPlayer(RaceType.ELF, 10,20);
        Player opponent = getPlayer(RaceType.ORC,10,20);

        ElvenLongsword sword = new ElvenLongsword(1);
        elf.setWeapon(sword);
        attack(elf, opponent, 15);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(9));
    }
}
