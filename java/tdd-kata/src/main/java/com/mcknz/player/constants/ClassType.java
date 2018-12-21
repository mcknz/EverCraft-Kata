package com.mcknz.player.constants;

public enum ClassType {
    FIGHTER,
    MONK,
    PALADIN,
    PLAYER,
    ROGUE;

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
