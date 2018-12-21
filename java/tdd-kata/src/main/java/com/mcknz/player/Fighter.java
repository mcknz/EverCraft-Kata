package com.mcknz.player.classes;

import com.mcknz.Abilities;
import com.mcknz.player.classes.PlayerClass;

public class Fighter extends PlayerClass {

    @Override
    public int[] getLevelIncreasedAttackModulus() {
        return new int[]{1};
    }

    @Override
    protected int getLevelHitPointIncrease() {
        return 10;
    }
}
