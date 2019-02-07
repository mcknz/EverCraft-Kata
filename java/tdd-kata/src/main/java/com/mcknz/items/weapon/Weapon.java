package com.mcknz.items.weapon;

import com.mcknz.Battle;
import com.mcknz.player.Player;

public abstract class Weapon {

    private final int level;

    public Weapon() {
        this.level = 0;
    }
    public Weapon(int level) {
        this.level = level;
    }

    protected int getBaseDamage(Battle battle) {
        return 0;
    }

    protected int getBaseAddedAttack(Battle battle) {
        return 0;
    }

    public final int getDamage(Battle battle) {
        return getBaseDamage(battle) + level;
    }

    public final int getAddedAttack(Battle battle) {
        return getBaseAddedAttack(battle) + level;
    }

    public int getAddedCriticalHitModifier(Player opponent) {
        return 0;
    }
}
