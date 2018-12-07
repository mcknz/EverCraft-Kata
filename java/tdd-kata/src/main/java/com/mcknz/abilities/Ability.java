package com.mcknz.abilities;

import com.mcknz.abilities.constants.*;

import java.util.Arrays;
import java.util.List;

public abstract class Ability {
    private int score;

    Ability() {
        this(10);
    }

    private Ability(int score) {
        this.score = score;
    }

    abstract AbilityType getType();

    private final List<Integer> scoreModifiers = Arrays.asList(
        -999, -5, -4, -4, -3, -3, -2, -2, -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5
    );

    public int getScore() {
        return score;
    }

    public void change(int value) {
        score+=value;
        validateScore();
    }

    public void set(int value) {
        score = value;
        validateScore();
    }

    public int getModifier() {
        return scoreModifiers.get(score);
    }

    public int add(ValueType type, int value) {
        return 0;
    }

    private int validateScore() {
        if(score > 20) {
            score = 20;
        } else {
            if(score < 1) {
                score = 1;
            }
        }
        return score;
    }
}
