package com.mcknz.player;

import com.mcknz.Abilities;
import com.mcknz.Roll;
import com.mcknz.abilities.exceptions.AbilityException;
import com.mcknz.player.constants.*;
import com.mcknz.abilities.constants.*;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private final String name;
    private final Alignment alignment;
    private final Abilities abilities;
    private final Roll roll;
    private final Map<ValueType, Integer> values = new HashMap<>();
    private final PlayerClass playerClass;

    public Player(PlayerOptions options, Abilities abilities, Roll roll) {
        this.abilities = abilities;
        this.roll = roll;
        this.name = options.getName();
        this.alignment = options.getAlignment();
        this.playerClass = options.getPlayerClass();

        values.put(ValueType.ARMOR, options.getArmorClass());
        values.put(ValueType.HIT_POINTS, options.getHitPoints());
        values.put(ValueType.EXPERIENCE_POINTS, 0);
        values.put(ValueType.LEVEL, 1);
    }

    String getName() {
        return name;
    }

    Alignment getAlignment() {
        return alignment;
    }

    public int getValue(ValueType type) {
        return values.get(type);
    }

    public PlayerClass getPlayerClass() {
        return this.playerClass;
    }

    public void setAbility(AbilityType type, int score) throws AbilityException {
        abilities.setAbility(type, score);
        for(Map.Entry<ValueType, Integer> entry : values.entrySet()) {
            entry.setValue(abilities.modify(playerClass, entry.getKey(), entry.getValue()));
        }
    }

    public int getAbilityModifier(AbilityType type) {
        return abilities.getAbilityModifier(type);
    }

    public boolean attack(Player opponent, int rollValue) throws AbilityException {
        int modifiedRoll = roll.get(rollValue, getValue(ValueType.LEVEL), getLevelHitPointIncreaseModulus());
        int opponentArmorClass = getArmorClassValue(opponent);
        boolean isHit = modifiedRoll >= opponentArmorClass;
        int damage = abilities.modify(playerClass, ValueType.DAMAGE, 1);
        if(isHit) {
            int criticalHitModifier = getCriticalHitModifier();
            int maxRoll = 20;
            opponent.hit(modifiedRoll >= maxRoll, damage, criticalHitModifier);
        }
        increaseExperience();
        setLevel();
        return isHit;
    }

    boolean isDead() {
        return getValue(ValueType.HIT_POINTS) < 1;
    }

    private void hit(boolean isCriticalHit, int damage, int criticalHitModifier) {
        if(damage < 1) {
            damage = 1;
        }
        if (isCriticalHit) {
            damage *= criticalHitModifier;
        }
        addToValue(ValueType.HIT_POINTS, -damage);
    }

    private void setLevel() {
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

    protected int getLevelHitPointIncreaseModulus() {
        return 2;
    }

    protected int getLevelHitPointIncrease() {
        return 5;
    }

    protected int getCriticalHitModifier() {
        return 2;
    }

    protected int getArmorClassValue(Player opponent) {
        return opponent.getValue(ValueType.ARMOR);
    }

    private void increaseExperience() {
        addToValue(ValueType.EXPERIENCE_POINTS, 10);
    }

    private void addToValue(ValueType type, int value) {
        values.put(type, getValue(type) + value);
    }

    private void setValue(ValueType type, int value) {
        values.put(type, value);
    }
}