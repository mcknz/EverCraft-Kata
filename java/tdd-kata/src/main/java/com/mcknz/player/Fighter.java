package com.mcknz.player;

import com.mcknz.Abilities;
import com.mcknz.Roll;

public class Fighter extends Player {

    public Fighter(PlayerOptions options, Abilities abilities, Roll roll) {
        super(options, abilities, roll);
    }

    @Override
    protected int getLevelHitPointIncreaseModulus() {
        return 1;
    }

    @Override
    protected int getLevelHitPointIncrease() {
        return 10;
    }
}
