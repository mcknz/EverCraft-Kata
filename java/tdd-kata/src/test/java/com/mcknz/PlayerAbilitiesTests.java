package com.mcknz;

import com.mcknz.abilities.AbilityType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerAbilitiesTests extends Tests {

    /*
        Feature: Character Ability Modifiers Modify Attributes
            As a character I want to apply my ability modifiers improve my capabilities in combat
            so that I can vanquish my enemy with extreme prejudice
                - add Strength modifier to:
                    - attack roll and damage dealt
    */
    @Test
    public void GivenAPlayerWithStrength15_WhenDieRolls8AndOpponentArmorClassIs10_ThenOpponentIsHit() {

        Player player = getStandardPlayer();
        player.setAbility(AbilityType.STRENGTH, 15);

        Player opponent = getStandardPlayer(
            new PlayerOptions(10,4)
        );

        assertThat(player.attack(opponent, 8), is(true));
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

        Player player = getStandardPlayer();
        player.setAbility(AbilityType.STRENGTH, 6);

        Player opponent = getStandardPlayer(
            new PlayerOptions(10,4)
        );

        assertThat(player.attack(opponent, 10), is(false));
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

        Player player = getStandardPlayer();
        player.setAbility(AbilityType.STRENGTH, 15);

        int opponentHitPoints = 4;

        Player opponent = getStandardPlayer(
            new PlayerOptions(8, opponentHitPoints)
        );

        player.attack(opponent, 10);

        assertThat(opponent.getHitPoints(), is(opponentHitPoints - 3));
    }

    /*
    Feature: Character Ability Modifiers Modify Attributes
        As a character I want to apply my ability modifiers improve my capabilities in combat
        so that I can vanquish my enemy with extreme prejudice
            - add Strength modifier to:
                - attack roll and damage dealt
    */
    @Test
    public void GivenAPlayerWithStrength15_WhenOpponentIsHitWith20Roll_ThenOpponentLoses6HitPoints() {

        Player player = getStandardPlayer();
        player.setAbility(AbilityType.STRENGTH, 15);

        int opponentHitPoints = 10;

        Player opponent = getStandardPlayer(
            new PlayerOptions(8, opponentHitPoints)
        );

        player.attack(opponent, 20);

        assertThat(opponent.getHitPoints(), is(opponentHitPoints - 6));
    }

    /*
        Feature: Character Ability Modifiers Modify Attributes
            As a character I want to apply my ability modifiers improve my capabilities in combat
            so that I can vanquish my enemy with extreme prejudice
                - add Strength modifier to:
                    - attack roll and damage dealt
                    - double Strength modifier on critical hits
                    -  minimum damage is always 1 (even on a critical hit)
                - add Dexterity modifier to armor class
                - add Constitution modifier to hit points (always at least 1 hit point)
    */
}
