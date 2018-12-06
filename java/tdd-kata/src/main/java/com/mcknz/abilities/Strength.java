package com.mcknz.abilities;

public class Strength extends Ability {

    @Override
    AbilityType getType() {
        return AbilityType.STRENGTH;
    }

    @Override
    public int modifyRoll(int roll) {
        return roll + this.getModifier();
    }

    @Override
    public int modifyDamage(int damage) {
        return damage + this.getModifier();
    }
}
