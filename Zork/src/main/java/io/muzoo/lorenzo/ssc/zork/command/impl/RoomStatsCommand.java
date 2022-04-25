package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.command.Command;

public class RoomStatsCommand implements Command {

    @Override
    public void execute(Game game, String argument) {

        if (game.isInGame()) {
            game.getCurrentRoom().roomStats();
        } else {
            System.out.println("You may only use this command in game.");
        }
    }
}
