package com.mcknz.player.classes;

public class Monk extends PlayerClass {

    @Override
    public int[] getLevelIncreasedAttackModulus() {
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
