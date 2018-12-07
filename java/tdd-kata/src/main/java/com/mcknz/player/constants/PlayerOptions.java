package com.mcknz.player.constants;

public class PlayerOptions {

    private final Alignment alignment;
    private final String name;
    private final int armorClass;
    private final int hitPoints;

    public PlayerOptions() {
        this("Player");
    }

    public PlayerOptions(String name) {
        this(name, Alignment.NEUTRAL);
    }

    public PlayerOptions(Alignment alignment) {
        this("Player", alignment);
    }

    public PlayerOptions(int armorClass, int hitPoints) {
        this("Player", Alignment.NEUTRAL, armorClass, hitPoints);
    }

    private PlayerOptions(String name, Alignment alignment) {
        this(name, alignment, 0);
    }

    private PlayerOptions(String name, Alignment alignment, int armorClass) {
        this(name, alignment, armorClass, 0);
    }

    private PlayerOptions(String name, Alignment alignment, int armorClass, int hitPoints) {
        this.name = name;
        this.alignment = alignment;
        this.armorClass = armorClass;
        this.hitPoints = hitPoints;
    }

    public final String getName() {
        return this.name;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final int getArmorClass() {
        return this.armorClass;
    }

    public final int getHitPoints() {
        return this.hitPoints;
    }
}
