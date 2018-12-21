package com.mcknz;

import com.mcknz.abilities.constants.ValueType;
import com.mcknz.abilities.exceptions.AbilityException;
import com.mcknz.player.Player;
import com.mcknz.player.constants.*;

class Battle {

    private final Player player;
    private final Player opponent;

    Battle(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    boolean engage(int rollValue) throws AbilityException {
        int modifiedRoll = modifyRollValue(rollValue);
        int opponentArmorClass = player.getArmorClassValue(opponent);
        boolean isHit = modifiedRoll >= opponentArmorClass;
        int damage = player.modifyAbilities(ValueType.DAMAGE, player.getBaseDamage());
        if(isHit) {
            int maxRoll = 20;
            hit(modifiedRoll >= maxRoll, damage);
        }
        player.increaseExperience(10);
        player.recalculateLevel();
        return isHit;
    }

    private void hit(boolean isCriticalHit,
                     int damage) {
        if(damage < 1) {
            damage = 1;
        }
        if (isCriticalHit) {
            damage *= player.getCriticalHitModifier();
        }
        if(opponent.getClassType() == ClassType.PALADIN
            && player.getAlignment() == Alignment.EVIL) {
            damage += 2;
        }
        opponent.applyDamage(damage);
    }

    private int modifyRollValue(int value) throws AbilityException {
        int level = player.getValue(ValueType.LEVEL);
        int[] modulus = player.getLevelHitPointIncreaseModulus();

        int newRoll = value;
        for (int mod : modulus) {
            if(level % mod == 0) {
                newRoll += (level / mod);
            }
        }
        return player.modifyAbilities(ValueType.ROLL, newRoll);
    }
}
