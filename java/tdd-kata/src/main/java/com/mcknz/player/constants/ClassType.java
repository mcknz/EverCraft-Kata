package com.mcknz.player.constants;

public enum PlayerClassType {
    DEFAULT("Default"),
    FIGHTER("Fighter"),
    MONK("Monk"),
    PALADIN("Paladin"),
    ROGUE("Rogue");

    private final String val;

    PlayerClassType(String value) {
        this.val = value;
    }

    public String value() {
        return val;
    }
}
