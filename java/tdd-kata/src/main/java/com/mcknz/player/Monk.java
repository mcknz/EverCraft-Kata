package com.mcknz.player;

import com.mcknz.Abilities;
import com.mcknz.Roll;
import com.mcknz.abilities.constants.AbilityType;

public class Monk extends Player {

    public Monk(PlayerOptions options, Abilities abilities, Roll roll) {
        super(options, abilities, roll);
    }

    @Override
    protected int[] getLevelHitPointIncreaseModulus() {
        return new int[] {2, 3};
    }

    @Override
    protected int getLevelHitPointIncrease() {
        return 6;
    }

    @Override
    protected int getBaseDamage() {
        return 3;
    }
}
