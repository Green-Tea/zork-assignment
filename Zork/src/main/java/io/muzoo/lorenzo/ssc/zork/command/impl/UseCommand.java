package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.Player;
import io.muzoo.lorenzo.ssc.zork.command.Command;
import io.muzoo.lorenzo.ssc.zork.items.Item;
import io.muzoo.lorenzo.ssc.zork.items.ItemFactory;
import io.muzoo.lorenzo.ssc.zork.items.potion.Potion;

import java.util.Iterator;
import java.util.List;

public class UseCommand implements Command {

    @Override
    public void execute(Game game, String argument) {

        if (game.isInGame()) {
            Player player = game.getPlayer();
            List<Item> inventory = player.getInventory();

            if (argument == null) {
                System.out.println("You cannot use nothing!");
            } else {
                ItemFactory factory = new ItemFactory();
                Potion potion = factory.createPotion(argument);

                if (potion == null) {
                    System.out.println("You cannot consume this item.");
                } else {
                    Iterator<Item> iter = inventory.iterator();
                    while (iter.hasNext()) {
                        Item item = iter.next();

                        if (item.getName().equals(argument)) {
                            // Increase health or damage
                            player.buffStats(potion.getHealAmount(), potion.getDamageBuff());
                            // Remove from inventory
                            iter.remove();

                            System.out.println("You consumed 1x " + potion.getName() + ".");

                            if (potion.getHealAmount() > 0 && potion.getDamageBuff() > 0 ) {
                                System.out.println("HP: " + player.getHp() + "/" + player.getMaxHp());
                                System.out.println("DMG: " + player.getDmg());
                            } else if (potion.getDamageBuff() > 0) {
                                System.out.println("DMG: " + player.getDmg());
                            } else {
                                System.out.println("HP: " + player.getHp() + "/" + player.getMaxHp());
                            }
                            return;
                        }
                    }
                }
            }
        } else {
            System.out.println("You may only use this command in game.");
        }
    }
}
