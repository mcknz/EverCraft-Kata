package com.mcknz.player;

import com.mcknz.Abilities;

public class Fighter extends Player {

    public Fighter(PlayerOptions options, Abilities abilities) {
        super(options, abilities);
    }

    @Override
    public int[] getLevelRollIncreaseModulus() {
        return new int[]{1};
    }

    @Override
    protected int getLevelHitPointIncrease() {
        return 10;
    }
}
