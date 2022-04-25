package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.command.Command;
import io.muzoo.lorenzo.ssc.zork.Player;

public class InfoCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (game.isInGame()) {
            Player player = game.getPlayer();
            player.status();
        } else {
            System.out.println("You may only use this command in game.");
        }
    }
}
