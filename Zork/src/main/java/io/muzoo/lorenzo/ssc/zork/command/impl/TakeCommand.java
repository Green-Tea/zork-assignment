package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.Player;
import io.muzoo.lorenzo.ssc.zork.command.Command;
import io.muzoo.lorenzo.ssc.zork.items.Item;
import io.muzoo.lorenzo.ssc.zork.map.Room;

import java.util.List;

public class TakeCommand implements Command {

    @Override
    public void execute(Game game, String argument) {

        boolean found = false;

        if (game.isInGame()) {
            Player player = game.getPlayer();
            Room room = game.getCurrentRoom();

            if (argument != null) {
                List<Item> items = room.getItems();
                for (Item item : items) {
                    if (item.getName().equalsIgnoreCase(argument)) {
                        // Pick up item
                        player.pickUpItem(item);
                        // Remove item from room
                        room.removeItem(item);
                        // Print message
                        System.out.println("You picked up the " + argument + "!");
                        return;
                    }
                }
                System.out.println("You cannot find the item in this room... Maybe try another one?");
            } else {
                System.out.println("You cannot pick up nothing.");
            }
        } else {
            System.out.println("You may only use this command in game.");
        }
    }
}
