package com.mcknz.player.constants;

public enum RaceType {
    HUMAN,
    ORC, DWARF, ELF, HALFLING;

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
