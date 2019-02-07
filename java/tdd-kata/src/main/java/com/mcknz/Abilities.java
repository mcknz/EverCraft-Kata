package com.mcknz;

import com.mcknz.abilities.Ability;
import com.mcknz.abilities.constants.*;
import com.mcknz.abilities.exceptions.AbilityException;
import com.mcknz.constants.ValueType;
import com.mcknz.player.PlayerOptions;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Abilities {

    private Map<AbilityType, Ability> abilities = new HashMap<>();

    public Abilities(PlayerOptions playerOptions) throws AbilityException {
        try {
            for (AbilityType type : AbilityType.values()) {
                Class<?> clazz = Class.forName("com.mcknz.abilities." + type.value());
                abilities.put(type, (Ability) clazz.getConstructor(PlayerOptions.class).newInstance(playerOptions));
            }
        } catch(Exception ex) {
            throw new AbilityException(ex);
        }
    }

    public void setAbility(AbilityType type, int score) {
        abilities.get(type).set(score);
    }

    public int getAbilityModifier(AbilityType type) {
        return abilities.get(type).getModifier();
    }

    public void doubleAbilityModifier(AbilityType type) { abilities.get(type).doubleModifier(); }

    public int modifyValueType(ValueType type, int value) throws AbilityException {
        String abilityName = "[NONE]";
        try {
            int newValue = value;
            for (Map.Entry<AbilityType, Ability> ability : abilities.entrySet()) {
                Ability abilityInstance = ability.getValue();
                Class<?> abilityClass = abilityInstance.getClass();
                abilityName = abilityClass.getSimpleName();
                Method method = abilityClass.getMethod("add", ValueType.class, Integer.TYPE);
                newValue += (Integer)method.invoke(abilityInstance, type, value);
            }
            return newValue;
        } catch (Exception ex) {
            throw new AbilityException("unable to call add(ValueType." + type + ", " + value + ")" +
                " for " + abilityName + " ability", ex);
        }
    }
}
