package com.mcknz.player;

import com.mcknz.player.constants.Alignment;
import com.mcknz.player.constants.PlayerClass;
import com.mcknz.player.exceptions.AlignmentException;

public class PlayerOptions {

    private final Alignment alignment;
    private final String name;
    private final int armorClass;
    private final int hitPoints;
    private final PlayerClass playerClass;

    public PlayerOptions(String name) throws AlignmentException {
        this(PlayerClass.PLAYER, name);
    }

    public PlayerOptions(PlayerClass playerClass, String name) throws AlignmentException {
        this(playerClass, name, Alignment.NEUTRAL);
    }

    public PlayerOptions(Alignment alignment) throws AlignmentException {
        this(PlayerClass.PLAYER, alignment);
    }

    public PlayerOptions(PlayerClass playerClass, Alignment alignment) throws AlignmentException {
        this(playerClass, alignment, 0,0);
    }

    public PlayerOptions(PlayerClass playerClass, String name, Alignment alignment) throws AlignmentException {
        this(playerClass, name, alignment, 0,0);
    }

    public PlayerOptions(int armorClass, int hitPoints) throws AlignmentException {
        this(PlayerClass.PLAYER, Alignment.NEUTRAL, armorClass, hitPoints);
    }

    public PlayerOptions(PlayerClass playerClass, int armorClass, int hitPoints) throws AlignmentException {
        this(playerClass, Alignment.NEUTRAL, armorClass, hitPoints);
    }

    public PlayerOptions(PlayerClass playerClass, String name, int armorClass, int hitPoints) throws AlignmentException {
        this(playerClass, name, Alignment.NEUTRAL, armorClass, hitPoints);
    }

    public PlayerOptions(PlayerClass playerClass,
                          Alignment alignment,
                          int armorClass,
                          int hitPoints) throws AlignmentException {
        this(playerClass, playerClass.toString(), alignment, armorClass, hitPoints);
    }

    private PlayerOptions(PlayerClass playerClass,
                          String name,
                          Alignment alignment,
                          int armorClass,
                          int hitPoints) throws AlignmentException {
        if(playerClass == PlayerClass.ROGUE && alignment == Alignment.GOOD) {
            throw new AlignmentException("A Rogue cannot have good alignment.");
        }
        this.playerClass = playerClass;
        this.name = name;
        this.alignment = alignment;
        this.armorClass = armorClass;
        this.hitPoints = hitPoints;
    }

    final PlayerClass getPlayerClass() { return this.playerClass; }

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
