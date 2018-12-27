package com.mcknz.player;

import com.mcknz.Abilities;
import com.mcknz.abilities.exceptions.AbilityException;
import com.mcknz.player.constants.*;
import com.mcknz.abilities.constants.*;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private final String name;
    private final Alignment alignment;
    private final Abilities abilities;
    private final Map<ValueType, Integer> values = new HashMap<>();
    private final ClassType classType;
    private final PlayerOptions options;

    public Player(PlayerOptions options, Abilities abilities) {
        this.abilities = abilities;
        this.options = options;
        this.name = options.getName();
        this.alignment = options.getAlignment();
        this.classType = options.getClassType();

        values.put(ValueType.ARMOR, options.getArmorClass());
        values.put(ValueType.HIT_POINTS, options.getHitPoints());
        values.put(ValueType.EXPERIENCE_POINTS, 0);
        values.put(ValueType.LEVEL, 1);
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public int getValue(ValueType type) {
        return values.get(type);
    }

    public ClassType getClassType() {
        return this.classType;
    }

    public int modifyUsingAbilities(ValueType type, int value) throws AbilityException {
        return abilities.modifyValueType(options, type, value);
    }

    public void setAbility(AbilityType type, int score) throws AbilityException {
        abilities.setAbility(type, score);
        for(Map.Entry<ValueType, Integer> entry : values.entrySet()) {
            entry.setValue(abilities.modifyValueType(options, entry.getKey(), entry.getValue()));
        }
    }

    public void applyDamage(int value) {
        addToValue(ValueType.HIT_POINTS, -value);
    }

    public void increaseExperience(int value) {
        addToValue(ValueType.EXPERIENCE_POINTS, value);
    }

    public void recalculateLevel() {
        int experiencePoints = getValue(ValueType.EXPERIENCE_POINTS);
        if(experiencePoints < 1000) {
            return;
        }
        int newLevel = Math.floorDiv(experiencePoints, 1000) + 1;
        int oldLevel = getValue(ValueType.LEVEL);
        if(newLevel > oldLevel) {
            addToValue(ValueType.HIT_POINTS, getLevelHitPointIncrease());
        }
        setValue(ValueType.LEVEL, newLevel < 1 ? 1 : newLevel);
    }

    public int[] getLevelRollIncreaseModulus() {
        return new int[]{2};
    }

    public int getCriticalHitModifier(Player opponent) {
        return 2;
    }

    public int getArmorClassValue(Player opponent) {
        return opponent.getValue(ValueType.ARMOR);
    }

    public int getBaseDamage(Player opponent) { return 1; }

    public int getRollIncrease(Player opponent) { return 0; }

    protected int getLevelHitPointIncrease() {
        return 5;
    }

    String getName() {
        return name;
    }

    int getAbilityModifier(AbilityType type) {
        return abilities.getAbilityModifier(type);
    }

    boolean isDead() {
        return getValue(ValueType.HIT_POINTS) < 1;
    }

    private void addToValue(ValueType type, int value) {
        values.put(type, getValue(type) + value);
    }

    private void setValue(ValueType type, int value) {
        values.put(type, value);
    }
}
