package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.Player;
import io.muzoo.lorenzo.ssc.zork.command.Command;
import io.muzoo.lorenzo.ssc.zork.items.Item;

import java.util.List;

public class DropCommand implements Command {

    @Override
    public void execute(Game game, String argument) {
        if (argument != null) {
            Player player = game.getPlayer();
            List<Item> inventory = player.getInventory();

            for (Item item : inventory) {
                if (item.getName().equals(argument)) {
                    inventory.remove(item);
                    System.out.println("You dropped " + argument + ".");
                    return;
                }
            }
            System.out.println("You don't have this item.");

        } else if (game.isInMenu()) {
            System.out.println("You may only use this command in game.");

        } else {
            System.out.println("You cannot drop nothing.");
        }
    }
}
