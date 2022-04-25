package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.Player;
import io.muzoo.lorenzo.ssc.zork.command.Command;
import io.muzoo.lorenzo.ssc.zork.map.Room;


public class GoCommand implements Command {
    @Override
    public void execute(Game game, String argument) {

        if (argument != null) {

            Player player = game.getPlayer();
            Room room = game.getCurrentRoom();
            Room currentRoom;

            if (room.getAllExits().contains(argument)) {
                switch (argument.toLowerCase()) {
                    case "north":
                        game.goToRoom(room.getNorthExit());
                        currentRoom = room.getNorthExit();

                        break;
                    case "east":
                        game.goToRoom(room.getEastExit());
                        currentRoom = room.getEastExit();

                        break;
                    case "west":
                        game.goToRoom(room.getWestExit());
                        currentRoom = room.getWestExit();

                        break;
                    default:
                        game.goToRoom(room.getSouthExit());
                        currentRoom = room.getSouthExit();
                        break;
                }
                player.buffStats(20, 0);
                System.out.println("You are now in the " + currentRoom.getDesc() + ".");
                System.out.println("20 HP recovered.");
                System.out.println("HP: " + player.getHp() + "/" + player.getMaxHp());
            } else {
                System.out.println("There is no exit in this direction.");
            }
        } else if (game.isInMenu()) {
            System.out.println("You may only use this command in game.");
        } else {
            System.out.println("You must specify a direction.");
        }
    }
}
