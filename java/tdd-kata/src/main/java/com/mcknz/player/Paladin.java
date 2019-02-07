package com.mcknz.player;

import com.mcknz.Abilities;
import com.mcknz.Battle;
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
    public int getPlayerBaseDamage(Battle battle) {
        Player opponent = battle.getOpponent();
        if(opponent.getAlignment() == Alignment.EVIL) {
            return 3;
        } else {
            return super.getPlayerBaseDamage(battle);
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
