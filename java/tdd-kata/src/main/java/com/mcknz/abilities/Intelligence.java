package com.mcknz.abilities;

import com.mcknz.player.PlayerOptions;

public class Intelligence extends Ability {
    public Intelligence(PlayerOptions playerOptions) {
        super(playerOptions);
        switch (playerOptions.getRaceType()) {
            case ORC: set(9);
        }
    }
}
