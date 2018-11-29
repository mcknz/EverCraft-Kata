package com.mcknz;

public class Player {

    private final String name;
    private final Alignment alignment;
    private final int armorClass;
    private int hitPoints;

    public Player() {
        this(new PlayerOptions());
    }

    public Player(PlayerOptions options) {
        this.name = options.getName();
        this.alignment = options.getAlignment();
        this.armorClass = options.getArmorClass();
        this.hitPoints = options.getHitPoints();
    }

    public String getName() {
        return name;
    }

    public Object getAlignment() {
        return alignment;
    }

    public Object getArmorClass() {
        return armorClass;
    }

    public Object getHitPoints() {
        return hitPoints;
    }

    public boolean attack(Player opponent, int roll) {
        boolean isHit = roll >= opponent.armorClass;
        if(isHit) {
            opponent.hit(1);
        }
        return isHit;
    }

    public void hit(int damage) {
        this.hitPoints-=1;
    }
}
