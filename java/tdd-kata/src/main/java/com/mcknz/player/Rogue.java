package com.mcknz.player;

import com.mcknz.Abilities;
import com.mcknz.Roll;
import com.mcknz.abilities.constants.AbilityType;

public class Rogue extends Player {

    public Rogue(PlayerOptions options, Abilities abilities, Roll roll) {
        super(options, abilities, roll);
    }

    @Override
    protected int getCriticalHitModifier() {
        return 3;
    }

    @Override
    protected int getArmorClassValue(Player opponent) {
        int opponentArmorClass = super.getArmorClassValue(opponent);
        int opponentDexterityModifier = opponent.getAbilityModifier(AbilityType.DEXTERITY);
        if(opponentDexterityModifier > 0) {
            return opponentArmorClass - opponentDexterityModifier;
        } else {
            return opponentArmorClass;
        }
    }
}
