package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.command.Command;

public class QuitCommand implements Command {
    @Override
    public void execute(Game game, String argument) {
        if (game.isInGame()) {
            System.out.println("Returning to the main menu...");
            System.out.println("=================================================================");
            System.out.println("\n");
            game.setInGame(false);
            game.setInMenu(true);
        } else {
            System.out.println("You may only use this command in game.");
        }

    }
}
