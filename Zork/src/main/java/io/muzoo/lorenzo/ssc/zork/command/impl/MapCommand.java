package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.command.Command;
import io.muzoo.lorenzo.ssc.zork.map.Map;

public class MapCommand implements Command {
    @Override
    public void execute(Game game, String argument) {

        if (game.isInGame()) {
            Map map = game.getCurrentMap();
            map.showMap();
        } else {
            System.out.println("You may only use this command in game.");
        }
    }
}
