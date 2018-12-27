package com.mcknz.player;

import com.mcknz.player.constants.Alignment;
import com.mcknz.player.constants.ClassType;
import com.mcknz.player.exceptions.AlignmentException;

public class PlayerOptions {

    private final Alignment alignment;
    private final String name;
    private final int armorClass;
    private final int hitPoints;
    private final ClassType classType;

    public PlayerOptions(String name) throws AlignmentException {
        this(ClassType.PLAYER, name);
    }

    public PlayerOptions(ClassType classType, String name) throws AlignmentException {
        this(classType, name, Alignment.NEUTRAL);
    }

    public PlayerOptions(Alignment alignment) throws AlignmentException {
        this(ClassType.PLAYER, alignment);
    }

    public PlayerOptions(ClassType classType, Alignment alignment) throws AlignmentException {
        this(classType, alignment, 0,0);
    }

    public PlayerOptions(ClassType classType, String name, Alignment alignment) throws AlignmentException {
        this(classType, name, alignment, 0,0);
    }

    public PlayerOptions(Alignment alignment, int armorClass, int hitPoints) throws AlignmentException {
        this(ClassType.PLAYER, alignment, armorClass, hitPoints);
    }

    public PlayerOptions(int armorClass, int hitPoints) throws AlignmentException {
        this(ClassType.PLAYER, Alignment.NEUTRAL, armorClass, hitPoints);
    }

    public PlayerOptions(ClassType classType, int armorClass, int hitPoints) throws AlignmentException {
        this(classType, Alignment.NEUTRAL, armorClass, hitPoints);
    }

    public PlayerOptions(ClassType classType, String name, int armorClass, int hitPoints) throws AlignmentException {
        this(classType, name, Alignment.NEUTRAL, armorClass, hitPoints);
    }

    public PlayerOptions(ClassType classType,
                         Alignment alignment,
                         int armorClass,
                         int hitPoints) throws AlignmentException {
        this(classType, classType.toString(), alignment, armorClass, hitPoints);
    }

    private PlayerOptions(ClassType classType,
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
        this.classType = classType;
        this.name = name;
        this.alignment = alignment;
        this.armorClass = armorClass;
        this.hitPoints = hitPoints;
    }

    public final ClassType getClassType() { return this.classType; }

    final String getName() {
        return this.name;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    final int getArmorClass() {
        return this.armorClass;
    }

    final int getHitPoints() {
        return this.hitPoints;
    }
}
