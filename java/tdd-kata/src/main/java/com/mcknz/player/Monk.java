package com.mcknz.player;

import com.mcknz.Abilities;
import com.mcknz.Battle;

public class Monk extends Player {

    public Monk(PlayerOptions options, Abilities abilities) {
        super(options, abilities);
    }

    @Override
    public int[] getLevelRollIncreaseModulus() {
        return new int[] {2, 3};
    }

    @Override
    protected int getLevelHitPointIncrease() {
        return 6;
    }

    @Override
    public int getPlayerBaseDamage(Battle battle) {
        return 3;
    }
}
