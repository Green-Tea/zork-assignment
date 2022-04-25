package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.command.Command;


public class ExitCommand implements Command {

    @Override
    public void execute(Game game, String argument) {
        if (game.isInMenu()) {
            game.exit();
        } else {
            System.out.println("You can only exit from the main menu.");
        }

    }
}
