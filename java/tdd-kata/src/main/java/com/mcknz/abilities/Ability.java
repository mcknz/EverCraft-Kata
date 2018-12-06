package com.mcknz.abilities;

import java.util.Arrays;
import java.util.List;

public abstract class Ability {
    private int score;

    public Ability() {
        this(10);
    }

    public Ability(int score) {
        this.score = score;
    }

    abstract AbilityType getType();

    private List<Integer> scoreModifiers = Arrays.asList(
        -999, -5, -4, -4, -3, -3, -2, -2, -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5
    );

    public int getScore() {
        return score;
    }

    public int change(int value) {
        score+=value;
        return validateScore();
    }

    public int set(int value) {
        score = value;
        return validateScore();
    }

    public int getModifier() {
        return scoreModifiers.get(score);
    }

    public int modifyRoll(int roll) {
        return roll;
    }

    public int modifyDamage(int damage) {
        return damage;
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
