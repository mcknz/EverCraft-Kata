package com.mcknz;

public class PlayerOptions {

    private final Alignment alignment;
    private final String name;
    private final int armorClass;
    private final int hitPoints;

    public PlayerOptions() {
        this("Player");
    }

    PlayerOptions(String name) {
        this(name, Alignment.NEUTRAL);
    }

    PlayerOptions(Alignment alignment) {
        this("Player", alignment);
    }

    PlayerOptions(int armorClass, int hitPoints) {
        this("Player", Alignment.NEUTRAL, armorClass, hitPoints);
    }

    PlayerOptions(String name, Alignment alignment) {
        this(name, alignment, 0);
    }

    PlayerOptions(String name, Alignment alignment, int armorClass) {
        this(name, alignment, armorClass, 0);
    }

    PlayerOptions(String name, Alignment alignment, int armorClass, int hitPoints) {
        this.name = name;
        this.alignment = alignment;
        this.armorClass = armorClass;
        this.hitPoints = hitPoints;
    }

    final String getName() {
        return this.name;
    }

    final Alignment getAlignment() {
        return this.alignment;
    }

    final int getArmorClass() {
        return this.armorClass;
    }

    final int getHitPoints() {
        return this.hitPoints;
    }

}
