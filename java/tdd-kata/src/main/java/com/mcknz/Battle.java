package com.mcknz;

import com.mcknz.abilities.constants.ValueType;
import com.mcknz.abilities.exceptions.AbilityException;
import com.mcknz.player.Player;

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
        if(isHit) {
            int damage = player.modifyAbilities(ValueType.DAMAGE, player.getBaseDamage(opponent));
            int maxRoll = 20;
            hit(modifiedRoll >= maxRoll, damage);
            player.increaseExperience(10);
            player.recalculateLevel();
        }
        return isHit;
    }

    private void hit(boolean isCriticalHit,
                     int damage) {
        if(damage < 1) {
            damage = 1;
        }
        if (isCriticalHit) {
            damage *= player.getCriticalHitModifier(opponent);
        }
        opponent.applyDamage(damage);
    }

    private int modifyRollValue(int value) throws AbilityException {
        int level = player.getValue(ValueType.LEVEL);
        int newRoll = value;

        if(level > 1) {
            int[] modulus = player.getLevelRollIncreaseModulus();
            for (int mod : modulus) {
                if (level % mod == 0) {
                    newRoll += (level / mod);
                }
            }
        }

        newRoll = player.modifyAbilities(ValueType.ROLL, newRoll);
        return newRoll + player.getRollIncrease(opponent);
    }
}
