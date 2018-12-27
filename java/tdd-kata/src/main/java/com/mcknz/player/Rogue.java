package com.mcknz.player;

import com.mcknz.Abilities;
import com.mcknz.abilities.constants.AbilityType;

public class Rogue extends Player {

    public Rogue(PlayerOptions options, Abilities abilities) {
        super(options, abilities);
    }

    @Override
    public int getCriticalHitModifier(Player opponent) {
        return 3;
    }

    @Override
    public int getArmorClassValue(Player opponent) {
        int opponentArmorClass = super.getArmorClassValue(opponent);
        int opponentDexterityModifier = opponent.getAbilityModifier(AbilityType.DEXTERITY);
        if(opponentDexterityModifier > 0) {
            return opponentArmorClass - opponentDexterityModifier;
        } else {
            return opponentArmorClass;
        }
    }
}
