package com.mcknz.items.weapon;

import com.mcknz.Battle;
import com.mcknz.player.Player;
import com.mcknz.player.constants.RaceType;

public class Longsword extends Weapon {
    @Override
    protected int getBaseDamage(Battle battle) {
        return 5;
    }
}
