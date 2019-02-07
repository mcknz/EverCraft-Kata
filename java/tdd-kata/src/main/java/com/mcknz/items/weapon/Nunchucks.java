package com.mcknz.items.weapon;

import com.mcknz.Battle;
import com.mcknz.player.Player;
import com.mcknz.player.constants.ClassType;

public class Nunchucks extends Weapon {

    @Override
    protected int getBaseDamage(Battle battle) {
        return 6;
    }

    @Override
    protected int getBaseAddedAttack(Battle battle) {
        if(battle.getPlayer().getClassType() != ClassType.MONK) {
            return -4;
        } else {
            return super.getBaseAddedAttack(battle);
        }
    }
}
