package com.mcknz;

import com.mcknz.abilities.exceptions.AbilityException;
import com.mcknz.constants.ValueType;
import com.mcknz.player.Player;
import com.mcknz.player.constants.RaceType;

public class Battle {

    private final Player player;
    private final Player opponent;

    Battle(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Player getOpponent() {
        return this.opponent;
    }

    boolean engage(int rollValue) throws AbilityException {
        int modifiedRoll = modifyRollValue(rollValue);
        int opponentArmorClass = player.getOpponentArmorClassValue(opponent);
        boolean isHit = modifiedRoll >= opponentArmorClass;
        if(isHit) {
            int damage = player.modifyUsingAbilities(ValueType.DAMAGE, player.getBaseDamage(this));
            hit(modifiedRoll, damage);
            player.increaseExperience(10);
            player.recalculateLevel();
        }
        return isHit;
    }

    private boolean isCriticalHit(int rollValue) {
        int maxRoll = 20;
        if(player.getRaceType() == RaceType.ELF && rollValue >= (maxRoll - 1)) {
            return true;
        }
        return rollValue >= maxRoll;
    }

    private void hit(int rollValue, int damage) {
        if(damage < 1) {
            damage = 1;
        }
        if (isCriticalHit(rollValue)) {
            damage *= (
                player.getCriticalHitModifier(opponent)
                  + player.getWeaponAddedCriticalHitModifier(opponent)
            );
        }
        damage += player.getAdditionalDamage(opponent);
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

        newRoll = player.modifyUsingAbilities(ValueType.ROLL, newRoll);

        switch(player.getRaceType()) {
            case DWARF:
                if(opponent.getRaceType() == RaceType.ORC) {
                    newRoll += 2;
                }
        }

        newRoll += player.getWeaponAddedAttack(this);

        newRoll -= player.getOpponentArmorAttackDecrease(opponent.getArmor());

        return newRoll + player.getRollIncrease(opponent);
    }
}
