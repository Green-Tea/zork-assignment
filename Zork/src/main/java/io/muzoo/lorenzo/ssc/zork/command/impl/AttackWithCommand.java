package io.muzoo.lorenzo.ssc.zork.command.impl;

import io.muzoo.lorenzo.ssc.zork.Game;
import io.muzoo.lorenzo.ssc.zork.Player;
import io.muzoo.lorenzo.ssc.zork.command.Command;
import io.muzoo.lorenzo.ssc.zork.items.ItemFactory;
import io.muzoo.lorenzo.ssc.zork.items.weapon.Weapon;
import io.muzoo.lorenzo.ssc.zork.map.Room;
import io.muzoo.lorenzo.ssc.zork.monsters.Monster;

import java.util.Random;

public class AttackWithCommand implements Command {

    @Override
    public void execute(Game game, String argument) {

        if (argument != null) {

            Player player = game.getPlayer();
            Room room = game.getCurrentRoom();
            Monster monster = room.getMonster();
            final Random random = new Random();

            ItemFactory factory = new ItemFactory();
            Weapon weapon = factory.createWeapon(argument);

            if (weapon == null) {
                System.out.println("You cannot attack with this.");
            } else if (!player.hasItem(argument.toLowerCase())) {
                System.out.println("You don't have this item in your inventory.");
            } else {
                if (!room.hasMonster()) {
                    System.out.println("There is nothing to attack.");
                } else {
                    if (monster.isAlive()) {
                        int damage = player.getDmg() + weapon.getAtkDmg();
                        monster.takeDamage(damage);
                        System.out.println(monster.getName() + " took " + damage + " damage!");
                        System.out.println(monster.getName() + ": " + monster.getHp() + "/" + monster.getMaxHp());
                    }

                    if (!monster.isAlive()) {
                        System.out.println("Your efforts paid off! You have slain " + monster.getName());
                        room.setMonster(null);
                        return;
                    }

                    if (random.nextDouble() <= monster.getAttackProb()) {
                        player.takeDamage(monster.getDmg());
                        System.out.println(monster.getName() + " hit you for " + monster.getDmg() + " HP!");
                        System.out.println("HP: " + player.getHp() + "/" + player.getMaxHp());

                        if (!player.isAlive()) {
                            System.out.println("You have fallen in battle...");
                            System.out.println("Returning to the main menu...");
                            game.setInMenu(true);
                            game.setInGame(false);

                        }
                    } else {
                        System.out.println(monster.getName() + " tried to attack but missed!");
                    }
                }
            }

        } else if (game.isInMenu()){
            System.out.println("You may only use this command in game.");
        } else {
            System.out.println("You cannot attack with nothing.");
        }
    }
}
