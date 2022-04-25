package io.muzoo.lorenzo.ssc.zork.map;

import io.muzoo.lorenzo.ssc.zork.items.ItemFactory;
import io.muzoo.lorenzo.ssc.zork.items.Key;
import io.muzoo.lorenzo.ssc.zork.items.potion.Potion;
import io.muzoo.lorenzo.ssc.zork.items.weapon.Weapon;
import io.muzoo.lorenzo.ssc.zork.monsters.Monster;
import io.muzoo.lorenzo.ssc.zork.monsters.MonsterFactory;

import java.util.ArrayList;
import java.util.List;

public class FirstFloor extends Map {

    private final List<Room> roomsList = new ArrayList<>();

    public FirstFloor() {
        setName("First Floor");
        setDesc("Welcome to the first floor of the dungeon.");
        setObjective("Kill the boss and find the key to the exit.");

        ItemFactory itemFactory = new ItemFactory();
        MonsterFactory monsterFactory = new MonsterFactory();

        Room room1 = new Room("Starting Room");
        Room room2 = new Room("Storage Room");
        Room room3 = new Room("Dining Hall");
        Room room4 = new Room("Kitchen");
        Room room5 = new Room("Treasury");
        Room room6 = new Room("Frozen Room");

        setStartingRoom(room1);

        room1.setSouthExit(room2);
        room1.setNorthExit(room3);
        room2.setNorthExit(room1);
        room3.setSouthExit(room1);
        room3.setWestExit(room4);
        room3.setEastExit(room5);
        room3.setNorthExit(room6);
        room4.setEastExit(room3);
        room5.setWestExit(room3);
        room6.setSouthExit(room3);

        Weapon longSword = itemFactory.createWeapon("long sword");
        Weapon dualBlades = itemFactory.createWeapon("dual blades");
        Potion lifePowder = itemFactory.createPotion("life powder");
        Potion demonDrug = itemFactory.createPotion("demon drug");
        Key key = itemFactory.createKey("key");

        Monster greatJagras = monsterFactory.createMonster("great jagras");
        Monster rathalos = monsterFactory.createMonster("rathalos");
        Monster velkhana = monsterFactory.createMonster("velkhana");

        room2.setItem(lifePowder);
        room2.setItem(longSword);
        room3.setItem(lifePowder);
        room3.setItem(dualBlades);
        room4.setItem(demonDrug);
        room4.setMonster(greatJagras);
        room5.setItem(key);
        room5.setMonster(rathalos);
        room6.setMonster(velkhana);

        roomsList.add(room1);
        roomsList.add(room2);
        roomsList.add(room3);
        roomsList.add(room4);
        roomsList.add(room5);
        roomsList.add(room6);
    }

    @Override
    public boolean taskComplete() {
        boolean keyInRoom = true;

        if (roomsList.get(4).getItems().size() != 1) {
            keyInRoom = false;
        }

        return !roomsList.get(5).hasMonster() && !keyInRoom;
    }

    @Override
    public void showMap() {
        System.out.println("\n");
        System.out.println("========================FIRST FLOOR======================");
        System.out.println("=========================================================");
        System.out.println("                     ###############                     ");
        System.out.println("                     #             #                     ");
        System.out.println("                     #             #                     ");
        System.out.println("                     # Frozen Room #                     ");
        System.out.println("                     #             #                     ");
        System.out.println("                     #             #                     ");
        System.out.println("                     ######   ######                     ");
        System.out.println("                          #   #                          ");
        System.out.println("                          #   #                          ");
        System.out.println("################     ######   ######     ################");
        System.out.println("#              #     #             #     #              #");
        System.out.println("#              #######             #######              #");
        System.out.println("#    Kitchen           Dining Hall           Treasury   #");
        System.out.println("#              #######             #######              #");
        System.out.println("#              #     #             #     #              #");
        System.out.println("################     ######   ######     ################");
        System.out.println("                          #   #                          ");
        System.out.println("                          #   #                          ");
        System.out.println("                     ######   ######                     ");
        System.out.println("                     #             #                     ");
        System.out.println("                     #             #                     ");
        System.out.println("                     #Starting Room#                     ");
        System.out.println("                     #             #                     ");
        System.out.println("                     #             #                     ");
        System.out.println("                     ######   ######                     ");
        System.out.println("                          #   #                          ");
        System.out.println("                          #   #                          ");
        System.out.println("                     ######   ######                     ");
        System.out.println("                     #             #                     ");
        System.out.println("                     #             #                     ");
        System.out.println("                     #Storage Room #                     ");
        System.out.println("                     #             #                     ");
        System.out.println("                     #             #                     ");
        System.out.println("                     ###############                     ");
        System.out.println("\n");
    }
}
