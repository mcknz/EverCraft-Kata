package com.mcknz.player;

import com.mcknz.AbstractTests;
import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.constants.ValueType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerExperienceTests extends AbstractTests {

    /*
    Feature: A Character can gain experience when attacking
        As a character I want to accumulate experience points (xp) when I attack my enemies
        so that I can earn bragging rights at the tavern
            - When a successful attack occurs, the character gains 10 experience points
    */
    @Test
    public void GivenAPlayerAttack_WhenOpponentIsHit_ThenPlayerGains10ExperiencePoints() {

        Player player = getPlayer();

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        attack(player, opponent, 19);

        assertThat(player.getValue(ValueType.EXPERIENCE_POINTS), is(10));
    }

    /*
    Feature: A Character Can Level
        As a character I want my experience points to increase my level and combat capabilities
        so that I can bring vengeance to my foes
            - Level defaults to 1
     */
    @Test
    public void GivenAPlayer_WhenCreated_ThenPlayerHasLevel1() {
        Player player = getPlayer();
        assertThat(player.getValue(ValueType.LEVEL), is(1));
    }

    /*
    Feature: A Character Can Level
    As a character I want my experience points to increase my level and combat capabilities
    so that I can bring vengeance to my foes
        - After 1000 experience points, the character gains a level
            - 0 xp -> 1st Level
            - 1000 xp -> 2nd Level
            - 2000 xp -> 3rd Level
            - etc.
 */
    @Test
    public void GivenAPlayer_WhenPlayerHitsOpponent100Times_ThenPlayerHasLevel2() {
        Player player = getPlayer();

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        setPlayerLevel(player, opponent, 2);

        assertThat(player.getValue(ValueType.LEVEL), is(2));
    }

    /*
    Feature: A Character Can Level
        As a character I want my experience points to increase my level and combat capabilities
        so that I can bring vengeance to my foes
            - For each level:
                - hit points increase by 5 plus Con modifier
     */
    @Test
    public void GivenAPlayerWith20Constitution_WhenPlayerIsLevel3_ThenHitPointsAre25() {
        Player player = getPlayer();
        setPlayerAbility(player, AbilityType.CONSTITUTION, 20);

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        setPlayerLevel(player, opponent, 3);

        assertThat(player.getValue(ValueType.HIT_POINTS), is(25));
    }

    /*
    Feature: A Character Can Level
        As a character I want my experience points to increase my level and combat capabilities
        so that I can bring vengeance to my foes
                - 1 is added to attack roll for every even level achieved
     */
    @Test
    public void GivenAPlayerWithLevel4_WhenOpponentArmorClassIs10AndRollIs8_ThenOpponentIsHit() {
        Player player = getPlayer();

        Player opponent = getPlayer(
            getPlayerOptions(10, 10)
        );

        setPlayerLevel(player, opponent, 4);

        assertThat(attack(player, opponent, 8), is(true));
    }
}
