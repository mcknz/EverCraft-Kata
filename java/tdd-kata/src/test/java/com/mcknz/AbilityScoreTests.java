package com.mcknz;

import com.mcknz.abilities.Intelligence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class AbilityScoreTests {

    private int score;
    private int modifier;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 1, -5 }, { 2, -4 }, { 3, -4 }, { 4, -3 }, { 5, -3 },
            { 6, -2 }, { 7, -2 }, { 8, -1 }, { 9, -1 }, { 10, 0 },
            { 11, 0 }, { 12, 1 }, { 13, 1 }, { 14, 2 }, { 15, 2 },
            { 16, 3 }, { 17, 3 }, { 18, 4 }, { 19, 4 }, { 20, 5 },
        });
    }

    public AbilityScoreTests(int score, int modifier) {
        this.score = score;
        this.modifier = modifier;
    }

    /*
        Feature: Character Has Abilities Scores
            As a character I want to have several abilities so that I am not identical to other characters except in name
                - Abilities have modifiers according to the following table

        |   Score   | Modifier |   Score   | Modifier |   Score   | Modifier |   Score   | Modifier |
        |:---------:|:--------:|:---------:|:--------:|:---------:|:--------:|:---------:|:--------:|
        |   __1__   |    -5    |   __6__   |    -2    |  __11__   |     0    |  __16__   |    +3    |
        |   __2__   |    -4    |   __7__   |    -2    |  __12__   |    +1    |  __17__   |    +3    |
        |   __3__   |    -4    |   __8__   |    -1    |  __13__   |    +1    |  __18__   |    +4    |
        |   __4__   |    -3    |   __9__   |    -1    |  __14__   |    +2    |  __19__   |    +4    |
        |   __5__   |    -3    |  __10__   |     0    |  __15__   |    +2    |  __20__   |    +5    |
    */

    @Test
    public void GivenTheIntelligenceAbility_WhenHasScore_ThenModifierIsCorrect() {
        Intelligence intelligence = new Intelligence();
        intelligence.reset(score);
        assertThat(intelligence.getModifier(), is(modifier));
    }
}
