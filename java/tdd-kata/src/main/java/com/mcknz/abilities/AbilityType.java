package com.mcknz.abilities;

public enum AbilityType {
    CHARISMA("Charisma"),
    CONSTITUTION("Constitution"),
    DEXTERITY("Dexterity"),
    INTELLIGENCE("Intelligence"),
    STRENGTH("Strength"),
    WISDOM("Wisdom");

    private final String val;

    AbilityType(String value) {
        this.val = value;
    }

    public String value() {
        return val;
    }
}
