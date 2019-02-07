package com.mcknz.items.weapon;

import com.mcknz.Battle;
import com.mcknz.player.Player;
import com.mcknz.player.constants.ClassType;

public class Waraxe extends Weapon{
    public Waraxe(int level) {
        super(level);
    }

    @Override
    public int getAddedCriticalHitModifier(Player opponent) {
        if(opponent.getClassType() == ClassType.ROGUE) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    protected int getBaseDamage(Battle battle) {
        return 6;
    }

    @Override
    protected int getBaseAddedAttack(Battle battle) {
        return 1;
    }
}
