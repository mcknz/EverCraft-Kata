package com.mcknz.items.weapon;

import com.mcknz.Battle;
import com.mcknz.player.Player;
import com.mcknz.player.constants.RaceType;

public class ElvenLongsword extends Weapon{

    ElvenLongsword(int level) { super(level); }

    @Override
    protected int getBaseDamage(Battle battle) {
        Player player = battle.getPlayer();
        Player opponent = battle.getOpponent();
        boolean playerIsElf = player.getRaceType() == RaceType.ELF;
        boolean opponentIsOrc = opponent.getRaceType() == RaceType.ORC;
        if(playerIsElf && opponentIsOrc) {
            return 10;
        }
        if(playerIsElf || opponentIsOrc) {
            return 7;
        } else {
            return 5;
        }
    }

}
