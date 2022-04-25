package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.command.Command;
import io.muzoo.lorenzo.ssc.zork.map.MapFactory;
import io.muzoo.lorenzo.ssc.zork.map.MapType;

public class PlayCommand implements Command {
    @Override
    public void execute(Game game, String argument) {

        if (game.isInMenu()) {
            if (argument != null) {

                for (MapType map : MapFactory.getAvailableMap().keySet()) {
                    if (map.getMapName().equals(argument.toLowerCase())) {
                        game.initiate(map);

                        System.out.println("Game starting..!");
                        System.out.println("Welcome to the " + game.getCurrentMap().getName() + " of the dungeon!");
                        System.out.println("OBJECTIVE: " + game.getCurrentMap().getObjective());

                        game.setInGame(true);
                        game.setInMenu(false);
                        return;
                    }
                }
                System.out.println("Incorrect map name.");

            } else {
                System.out.println("You must specify a map name.");
            }
        } else {
            System.out.println("You may only use this command in the main menu.");
        }
    }
}
