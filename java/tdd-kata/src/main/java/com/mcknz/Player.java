package com.mcknz;

import com.mcknz.abilities.Ability;
import com.mcknz.abilities.AbilityException;
import com.mcknz.abilities.AbilityType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Player {

    private final String name;
    private final Alignment alignment;
    private int armorClass = 0;
    private int hitPoints = 0;
    private Map<AbilityType, Ability> abilities;

    //public Player() {
    //    this(new PlayerOptions());
    //}

    Player(PlayerOptions options) throws AbilityException {
        this.name = options.getName();
        this.alignment = options.getAlignment();
        this.armorClass = options.getArmorClass();
        this.hitPoints = options.getHitPoints();

        abilities = new HashMap<>();

        try {
            for (AbilityType type : AbilityType.values()) {
                Class<?> clazz = Class.forName("com.mcknz.abilities." + type.value());
                abilities.put(type, (Ability) clazz.getConstructor().newInstance());
            }
        } catch(Exception ex) {
            throw new AbilityException(ex);
        }
    }

    String getName() {
        return name;
    }

    Alignment getAlignment() {
        return alignment;
    }

    int getArmorClass() {
        return armorClass;
    }

    int getHitPoints() {
        return hitPoints;
    }

    int changeAbility(AbilityType type, int value) {
        return abilities.get(type).change(value);
    }

    int setAbility(AbilityType type, int value) {
        return abilities.get(type).set(value);
    }

    boolean attack(Player opponent, int roll) {
        boolean isHit = modifyRoll(roll) >= opponent.armorClass;
        if(isHit) {
            int damage = modifyDamage(1);
            if(roll == 20) {
                opponent.hit(damage * 2);
            } else {
                opponent.hit(damage);
            }
        }
        return isHit;
    }

    boolean isDead() {
        return this.hitPoints < 1;
    }

    private void hit(int damage) {
        this.hitPoints -= damage;
    }

    private int modifyRoll(int roll) {
        int newRoll = roll;
        for (Map.Entry<AbilityType, Ability> ability : abilities.entrySet()) {
            newRoll = ability.getValue().modifyRoll(newRoll);
        }
        return newRoll;
    }

    private int modifyDamage(int damage) {
        int newDamage = damage;
        for (Map.Entry<AbilityType, Ability> ability : abilities.entrySet()) {
            newDamage = ability.getValue().modifyDamage(newDamage);
        }
        return newDamage;
    }
}
