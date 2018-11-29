package com.mcknz;

class Player {

    private final String name;
    private final Alignment alignment;
    private final int armorClass;
    private int hitPoints;

    //public Player() {
    //    this(new PlayerOptions());
    //}

    Player(PlayerOptions options) {
        this.name = options.getName();
        this.alignment = options.getAlignment();
        this.armorClass = options.getArmorClass();
        this.hitPoints = options.getHitPoints();
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

    boolean attack(Player opponent, int roll) {
        boolean isHit = roll >= opponent.armorClass;
        if(isHit) {
            if(roll == 20) {
                opponent.hit(2);
            } else {
                opponent.hit(1);
            }
        }
        return isHit;
    }

    private void hit(int damage) {
        this.hitPoints-=damage;
    }

    boolean isDead() {
        return this.hitPoints < 1;
    }
}
