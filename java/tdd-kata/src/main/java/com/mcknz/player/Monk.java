package com.mcknz.player;

import com.mcknz.Abilities;

public class Monk extends Player {

    public Monk(PlayerOptions options, Abilities abilities) {
        super(options, abilities);
    }

    @Override
    public int[] getLevelHitPointIncreaseModulus() {
        return new int[] {2, 3};
    }

    @Override
    protected int getLevelHitPointIncrease() {
        return 6;
    }

    @Override
    public int getBaseDamage() {
        return 3;
    }
}
