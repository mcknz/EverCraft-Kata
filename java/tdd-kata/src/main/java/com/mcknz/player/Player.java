package com.mcknz.player;

import com.mcknz.Abilities;
import com.mcknz.Battle;
import com.mcknz.constants.ValueType;
import com.mcknz.abilities.exceptions.AbilityException;
import com.mcknz.items.armor.*;
import com.mcknz.items.shield.Hand;
import com.mcknz.items.shield.Shield;
import com.mcknz.items.weapon.*;
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
    private final RaceType raceType;
    private Weapon weapon = new Fist();
    private Armor armor = new Skin();
    private Shield shield = new Hand();

    public Player(PlayerOptions options, Abilities abilities) {
        this.abilities = abilities;
        this.name = options.getName();
        this.alignment = options.getAlignment();
        this.classType = options.getClassType();
        this.raceType = options.getRaceType();

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
        return abilities.modifyValueType(type, value);
    }

    public void setAbility(AbilityType type, int score) throws AbilityException {
        abilities.setAbility(type, score);
        for(Map.Entry<ValueType, Integer> entry : values.entrySet()) {
            entry.setValue(abilities.modifyValueType(entry.getKey(), entry.getValue()));
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
            if(raceType == RaceType.DWARF) {
                doubleAbilityModifier(AbilityType.CONSTITUTION);
            }
        }
        setLevelValue(newLevel < 1 ? 1 : newLevel);
    }

    public int[] getLevelRollIncreaseModulus() {
        return new int[]{2};
    }

    public int getCriticalHitModifier(Player opponent) {
        return 2;
    }

    public int getOpponentArmorClassValue(Player opponent) {

        int opponentArmorValue = opponent.getValue(ValueType.ARMOR);

        boolean isOrcAttackingElf =
            opponent.getRaceType() == RaceType.ELF
            && getRaceType() == RaceType.ORC;

        boolean isNonHalflingAttackingHalfling =
            opponent.getRaceType() == RaceType.HALFLING
                && getRaceType() != RaceType.HALFLING;

        if(isOrcAttackingElf || isNonHalflingAttackingHalfling) {
            opponentArmorValue += 2;
        }

        return opponentArmorValue;
    }

    public int getOpponentArmorAttackDecrease(Armor opponentArmor) {
        return opponentArmor.getAttackDecrease();
    }

    public final int getBaseDamage(Battle battle) {
        int weaponDamage = getWeaponBaseDamage(battle);
        if(weaponDamage > 0) {
            return weaponDamage;
        } else {
            return getPlayerBaseDamage(battle);
        }
    }

    public int getAdditionalDamage(Player opponent) {
        int additionalDamage = 0;
        switch(getRaceType()){
            case DWARF:
                if(opponent.getRaceType() == RaceType.ORC) {
                    additionalDamage += 2;
                }
        }
        return additionalDamage;
    }

    public int getRollIncrease(Player opponent) { return 0; }

    public RaceType getRaceType() {
        return raceType;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getWeaponAddedAttack(Battle battle) { return weapon.getAddedAttack(battle); }

    public int getWeaponAddedCriticalHitModifier(Player opponent) { return weapon.getAddedCriticalHitModifier(opponent); }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public Shield getShield() {
        return this.shield;
    }

    protected int getLevelHitPointIncrease() {
        return 5;
    }

    protected int getPlayerBaseDamage(Battle battle) {
        return 1;
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

    private int getWeaponBaseDamage(Battle battle) {
        return weapon.getDamage(battle);
    }

    private void doubleAbilityModifier(AbilityType type) { abilities.doubleAbilityModifier(type); }

    private void addToValue(ValueType type, int value) {
        values.put(type, getValue(type) + value);
    }

    private void setLevelValue(int value) {
        values.put(ValueType.LEVEL, value);
    }


}
