package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;
import com.mcknz.player.Player;
import com.mcknz.player.PlayerOptions;
import com.mcknz.AbstractTests;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerAbilityTests extends AbstractTests {

    /*
        Feature: Character Ability Modifiers Modify Attributes
            As a character I want to apply my ability modifiers improve my capabilities in combat
            so that I can vanquish my enemy with extreme prejudice
                - add Strength modifier to:
                    - attack roll and damage dealt
    */
    @Test
    public void GivenAPlayerWithStrength15_WhenDieRolls8AndOpponentArmorClassIs10_ThenOpponentIsHit() {

        Player player = getPlayer();
        setPlayerAbility(player, AbilityType.STRENGTH, 15);

        Player opponent = getPlayer(
            getPlayerOptions(10,4)
        );

        assertThat(attack(player, opponent, 8), is(true));
    }

    /*
        Feature: Character Ability Modifiers Modify Attributes
            As a character I want to apply my ability modifiers improve my capabilities in combat
            so that I can vanquish my enemy with extreme prejudice
                - add Strength modifier to:
                    - attack roll and damage dealt
    */
    @Test
    public void GivenAPlayerWithStrength6_WhenDieRolls10AndOpponentArmorClassIs8_ThenOpponentIsNotHit() {

        Player player = getPlayer();
        setPlayerAbility(player, AbilityType.STRENGTH, 6);

        Player opponent = getPlayer(
            getPlayerOptions(10,4)
        );

        assertThat(attack(player, opponent, 10), is(false));
    }

    /*
    Feature: Character Ability Modifiers Modify Attributes
        As a character I want to apply my ability modifiers improve my capabilities in combat
        so that I can vanquish my enemy with extreme prejudice
            - add Strength modifier to:
                - attack roll and damage dealt
    */
    @Test
    public void GivenAPlayerWithStrength15_WhenOpponentIsHit_ThenOpponentLoses3HitPoints() {

        Player player = getPlayer();
        setPlayerAbility(player, AbilityType.STRENGTH, 15);

        int opponentHitPoints = 4;

        Player opponent = getPlayer(
            getPlayerOptions(8, opponentHitPoints)
        );

        attack(player, opponent, 10);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(opponentHitPoints - 3));
    }

    /*
    Feature: Character Ability Modifiers Modify Attributes
        As a character I want to apply my ability modifiers improve my capabilities in combat
        so that I can vanquish my enemy with extreme prejudice
            - add Strength modifier to:
                - double Strength modifier on critical hits
    */
    @Test
    public void GivenAPlayerWithStrength15_WhenOpponentIsHitWith20Roll_ThenOpponentLoses6HitPoints() {

        Player player = getPlayer();
        setPlayerAbility(player, AbilityType.STRENGTH, 15);

        int opponentHitPoints = 10;

        Player opponent = getPlayer(
            getPlayerOptions(8, opponentHitPoints)
        );

        attack(player, opponent, 20);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(opponentHitPoints - 6));
    }

    /*
        Feature: Character Ability Modifiers Modify Attributes
            As a character I want to apply my ability modifiers improve my capabilities in combat
            so that I can vanquish my enemy with extreme prejudice
                - add Strength modifier to:
                    -  minimum damage is always 1 (even on a critical hit)
                - add Dexterity modifier to armor class
                - add Constitution modifier to hit points (always at least 1 hit point)
    */
    @Test
    public void GivenAPlayerWithStrength1_WhenOpponentIsHitWith20Roll_ThenOpponentLoses1HitPoint() {

        Player player = getPlayer();
        setPlayerAbility(player, AbilityType.STRENGTH, 1);

        int opponentHitPoints = 10;

        Player opponent = getPlayer(
            getPlayerOptions(8, opponentHitPoints)
        );

        attack(player, opponent,20);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(opponentHitPoints - 1));
    }

    /*
        Feature: Character Ability Modifiers Modify Attributes
            As a character I want to apply my ability modifiers improve my capabilities in combat
            so that I can vanquish my enemy with extreme prejudice
                - add Dexterity modifier to armor class
    */
    @Test
    public void GivenAnOpponentWithDexterity12AndArmorClass10_WhenAttackRollIs10_ThenOpponentIsNotHit() {

        Player player = getPlayer();

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        setPlayerAbility(opponent, AbilityType.DEXTERITY, 12);

        assertThat(attack(player, opponent, 10), is(false));
    }

    /*
    Feature: Character Ability Modifiers Modify Attributes
        As a character I want to apply my ability modifiers improve my capabilities in combat
        so that I can vanquish my enemy with extreme prejudice
            - add Constitution modifier to hit points (always at least 1 hit point)
    */
    @Test
    public void GivenAnOpponentWithConstitution20AndArmorClassIs10_WhenAttackRollIs10_ThenHitPointsAre14() {

        Player player = getPlayer();

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        // 20 is +5 modifier = 15 hit points
        setPlayerAbility(opponent, AbilityType.CONSTITUTION, 20);

        attack(player, opponent, 10);

        assertThat(opponent.getValue(ValueType.HIT_POINTS), is(14));
    }

    @Test
    public void GivenAnOpponentWithConstitution1AndArmorClassIs10_WhenAttackRollIs10_ThenHitPointsAre4() {
        /*
        Player player = getPlayer();

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        // 1 is -5 modifier = 15 hit points
        opponent.setAbility(AbilityType.CONSTITUTION, 1);

        attack(player, opponent, 10);

        assertThat(getPlayerHitPoints(player), is(4));
         */
    }
}
