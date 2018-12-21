package com.mcknz.player;

import com.mcknz.Abilities;

public class Paladin extends Player {

    public Paladin(PlayerOptions options, Abilities abilities) {
        super(options, abilities);
    }

    @Override
    protected int getLevelHitPointIncrease() {
        return 8;
    }

    @Override
    public int getBaseDamage() {
        return 3;
    }
}
