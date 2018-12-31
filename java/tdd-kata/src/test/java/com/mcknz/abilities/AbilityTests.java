package com.mcknz.abilities;

import com.mcknz.AbstractTests;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AbilityTests extends AbstractTests {

    /*
        Feature: Character Has Abilities Scores
            As a character I want to have several abilities so that I am not identical to other characters except in name
                - Abilities are Strength, Dexterity, Constitution, Wisdom, Intelligence, Charisma
                - Abilities range from 1 to 20 and default to 10
    */
    @Test
    public void GivenTheStrengthAbility_WhenCreated_ThenDefaultValueShouldBe10() {
        assertThat(new Strength(getPlayerOptions()).getScore(), is(10));
    }

    /*
    Feature: Character Has Abilities Scores
        As a character I want to have several abilities
        so that I am not identical to other characters except in name
            - Abilities are Strength, Dexterity, Constitution, Wisdom, Intelligence, Charisma
            - Abilities range from 1 to 20 and default to 10
    */
    @Test
    public void GivenTheDexterityAbility_WhenCreated_ThenDefaultValueShouldBe10() {
        assertThat(new Dexterity(getPlayerOptions()).getScore(), is(10));
    }

    /*
        Feature: Character Has Abilities Scores
            As a character I want to have several abilities
            so that I am not identical to other characters except in name
                - Abilities range from 1 to 20 and default to 10
    */
    @Test
    public void GivenTheConstitutionAbility_WhenIncreased_ThenMaxValueShouldBe20() {
        Constitution constitution = new Constitution(getPlayerOptions());
        constitution.change(50);
        assertThat(constitution.getScore(), is(20));
    }

    /*
        Feature: Character Has Abilities Scores
            As a character I want to have several abilities
            so that I am not identical to other characters except in name
                - Abilities range from 1 to 20 and default to 10
    */
    @Test
    public void GivenTheWisdomAbility_WhenDecreased_ThenMinValueShouldBe1() {
        Wisdom wisdom = new Wisdom(getPlayerOptions());
        wisdom.change(-50);
        assertThat(wisdom.getScore(), is(1));
    }

    /*
        Feature: Character Has Abilities Scores
            As a character I want to have several abilities
            so that I am not identical to other characters except in name
                - Abilities range from 1 to 20 and default to 10
    */
    @Test
    public void GivenTheCharismaAbility_WhenResetTo5_ThenValueShouldBe5() {
        Charisma charisma = new Charisma(getPlayerOptions());
        charisma.set(5);
        assertThat(charisma.getScore(), is(5));
    }
}
