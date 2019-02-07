package com.mcknz.abilities;

import com.mcknz.constants.ValueType;
import com.mcknz.player.PlayerOptions;

import java.util.Arrays;
import java.util.List;

public abstract class Ability {
    private int score;
    private PlayerOptions playerOptions;

    Ability(PlayerOptions playerOptions) {
        this(playerOptions,10);
    }

    private Ability(PlayerOptions playerOptions, int score) {
        this.playerOptions = playerOptions;
        this.score = score;
    }

    private final List<Integer> scoreModifiers = Arrays.asList(
        -999, -5, -4, -4, -3, -3, -2, -2, -1, -1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5
    );

    PlayerOptions getPlayerOptions() { return playerOptions; }

    int getScore() {
        return score;
    }

    void change(int value) {
        score+=value;
        validateScore();
    }

    public void set(int value) {
        score = value;
        validateScore();
    }

    public void doubleModifier() {
        switch(getModifier()) {
            case 1: set(14); break;
            case 2: set(18); break;
            case 3:
            case 4:
            case 5: set(20); break;
        }
    }

    public int getModifier() {
        return scoreModifiers.get(score);
    }

    public int add(ValueType type, int value) {
        return 0;
    }

    private void validateScore() {
        if(score > 20) {
            score = 20;
        } else {
            if(score < 1) {
                score = 1;
            }
        }
    }
}
