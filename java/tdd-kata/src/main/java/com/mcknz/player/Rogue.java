package com.mcknz.player.classes;

import com.mcknz.abilities.constants.AbilityType;
import com.mcknz.player.Player;

public class Rogue extends PlayerClass {

    @Override
    public int getCriticalHitModifier() {
        return 3;
    }

    @Override
    public int getOpponentArmorClassValue(Player opponent) {
        int opponentArmorClass = super.getOpponentArmorClassValue(opponent);
        int opponentDexterityModifier = opponent.getAbilityModifier(AbilityType.DEXTERITY);
        if(opponentDexterityModifier > 0) {
            return opponentArmorClass - opponentDexterityModifier;
        } else {
            return opponentArmorClass;
        }
    }
}
