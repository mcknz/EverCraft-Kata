package com.mcknz.player;

import com.mcknz.player.constants.Alignment;
import com.mcknz.player.constants.ClassType;
import com.mcknz.player.exceptions.AlignmentException;
import com.mcknz.player.constants.RaceType;

public class PlayerOptions {

    private final Alignment alignment;
    private final String name;
    private final int armorClass;
    private final int hitPoints;
    private final ClassType classType;
    private final RaceType raceType;

    public PlayerOptions(String name) throws AlignmentException {
        this(ClassType.PLAYER, name);
    }

    public PlayerOptions(ClassType classType, String name) throws AlignmentException {
        this(classType, RaceType.HUMAN, name, Alignment.NEUTRAL);
    }

    public PlayerOptions(RaceType raceType, String name) throws AlignmentException {
        this(ClassType.PLAYER, raceType, name, Alignment.NEUTRAL);
    }

    public PlayerOptions(ClassType classType, RaceType raceType, String name) throws AlignmentException {
        this(classType, raceType, name, Alignment.NEUTRAL);
    }

    public PlayerOptions(Alignment alignment) throws AlignmentException {
        this(ClassType.PLAYER, alignment);
    }

    public PlayerOptions(ClassType classType, Alignment alignment) throws AlignmentException {
        this(classType, RaceType.HUMAN, alignment, 0,0);
    }

    public PlayerOptions(ClassType classType, RaceType raceType, String name, Alignment alignment) throws AlignmentException {
        this(classType, raceType, name, alignment, 0,0);
    }

    public PlayerOptions(Alignment alignment, int armorClass, int hitPoints) throws AlignmentException {
        this(ClassType.PLAYER, RaceType.HUMAN, alignment, armorClass, hitPoints);
    }

    public PlayerOptions(int armorClass, int hitPoints) throws AlignmentException {
        this(ClassType.PLAYER, RaceType.HUMAN, Alignment.NEUTRAL, armorClass, hitPoints);
    }

    public PlayerOptions(ClassType classType, RaceType raceType, int armorClass, int hitPoints) throws AlignmentException {
        this(classType, raceType, Alignment.NEUTRAL, armorClass, hitPoints);
    }

    public PlayerOptions(ClassType classType, RaceType raceType, String name, int armorClass, int hitPoints) throws AlignmentException {
        this(classType, raceType, name, Alignment.NEUTRAL, armorClass, hitPoints);
    }

    public PlayerOptions(ClassType classType,
                         RaceType raceType,
                         Alignment alignment,
                         int armorClass,
                         int hitPoints) throws AlignmentException {
        this(classType, raceType, classType.toString(), alignment, armorClass, hitPoints);
    }

    private PlayerOptions(ClassType classType,
                          RaceType raceType,
                          String name,
                          Alignment alignment,
                          int armorClass,
                          int hitPoints) throws AlignmentException {
        if(classType == ClassType.ROGUE && alignment == Alignment.GOOD) {
            throw new AlignmentException("A Rogue cannot have good alignment.");
        }
        if(classType == ClassType.PALADIN && alignment != Alignment.GOOD) {
            throw new AlignmentException("A Paladin must have good alignment.");
        }
        if(raceType == RaceType.HALFLING && alignment == Alignment.EVIL) {
            throw new AlignmentException("A Halfling cannot have evil alignment.");
        }
        this.classType = classType;
        this.name = name;
        this.alignment = alignment;
        this.armorClass = armorClass;
        this.hitPoints = hitPoints;
        this.raceType = raceType;
    }

    public final ClassType getClassType() { return this.classType; }

    final String getName() {
        return this.name;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    final int getArmorClass() {
        int raceTypeModifier = 0;
        switch(getRaceType()) {
            case ORC: raceTypeModifier = 2;
        }
        return this.armorClass + raceTypeModifier;
    }

    final int getHitPoints() {
        return this.hitPoints;
    }

    public final RaceType getRaceType() {
        return this.raceType;
    }
}
