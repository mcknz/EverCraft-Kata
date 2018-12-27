package com.mcknz.player;

import com.mcknz.Abilities;
import com.mcknz.player.constants.Alignment;

public class Paladin extends Player {

    public Paladin(PlayerOptions options, Abilities abilities) {
        super(options, abilities);
    }

    @Override
    protected int getLevelHitPointIncrease() {
        return 8;
    }

    @Override
    public int getBaseDamage(Player opponent) {
        if(opponent.getAlignment() == Alignment.EVIL) {
            return 3;
        } else {
            return super.getBaseDamage(opponent);
        }
    }

    @Override
    public int getRollIncrease(Player opponent) {
        if(opponent.getAlignment() == Alignment.EVIL) {
            return 2;
        } else {
            return super.getRollIncrease(opponent);
        }
    }

    @Override
    public int getCriticalHitModifier(Player opponent) {
        if(opponent.getAlignment() == Alignment.EVIL) {
            return 3;
        } else {
            return super.getCriticalHitModifier(opponent);
        }
    }

    public int[] getLevelRollIncreaseModulus() {
        return new int[]{1};
    }
}
