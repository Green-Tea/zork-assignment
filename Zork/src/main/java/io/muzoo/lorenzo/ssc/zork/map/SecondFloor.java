package io.muzoo.lorenzo.ssc.zork.map;

import io.muzoo.lorenzo.ssc.zork.items.ItemFactory;
import io.muzoo.lorenzo.ssc.zork.items.potion.Potion;
import io.muzoo.lorenzo.ssc.zork.items.weapon.Weapon;
import io.muzoo.lorenzo.ssc.zork.monsters.Monster;
import io.muzoo.lorenzo.ssc.zork.monsters.MonsterFactory;

import java.util.ArrayList;
import java.util.List;

public class SecondFloor extends Map{

    private final List<Room> roomsList = new ArrayList<>();

    public SecondFloor() {
        setName("Second Floor");
        setDesc("Welcome to the second floor of the dungeon.");
        setObjective("Kill all monsters to get to the next floor.");

        ItemFactory itemFactory = new ItemFactory();
        MonsterFactory monsterFactory = new MonsterFactory();

        Room room1 = new Room("Starting Room");
        Room room2 = new Room("Hallway Start");
        Room room3 = new Room("Giant Pit of Sand");
        Room room4 = new Room("Hallway End");
        Room room5 = new Room("Small Jungle Enclosure");
        Room room6 = new Room("Large Jungle Enclosure");

        setStartingRoom(room1);

        room1.setEastExit(room2);
        room2.setWestExit(room1);
        room2.setNorthExit(room3);
        room2.setEastExit(room4);
        room3.setSouthExit(room2);
        room4.setWestExit(room2);
        room4.setEastExit(room5);
        room5.setWestExit(room4);
        room5.setNorthExit(room6);
        room6.setSouthExit(room5);

        Weapon greatSword = itemFactory.createWeapon("great sword");
        Weapon bow = itemFactory.createWeapon("bow");
        Potion megaPotion = itemFactory.createPotion("mega potion");
        Potion mightPill = itemFactory.createPotion("might pill");
        Potion lifePowder = itemFactory.createPotion("life powder");

        Monster diablos = monsterFactory.createMonster("diablos");
        Monster rajang = monsterFactory.createMonster("rajang");
        Monster furiousRajang = monsterFactory.createMonster("furious rajang");

        room2.setItem(lifePowder);
        room3.setItem(greatSword);
        room3.setMonster(diablos);
        room4.setItem(mightPill);
        room4.setItem(bow);
        room5.setItem(megaPotion);
        room5.setMonster(rajang);
        room6.setItem(lifePowder);
        room6.setMonster(furiousRajang);

        roomsList.add(room1);
        roomsList.add(room2);
        roomsList.add(room3);
        roomsList.add(room4);
        roomsList.add(room5);
        roomsList.add(room6);
    }

    @Override
    public boolean taskComplete() {
        for (Room room : roomsList) {
            if (room.hasMonster()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void showMap() {
        System.out.println("\n");
        System.out.println("=================================SECOND FLOOR==============================");
        System.out.println("===========================================================================");
        System.out.println("                    ###############                         ###############");
        System.out.println("                    #             #                         #             #");
        System.out.println("                    #  Giant Pit  #                         # Large       #");
        System.out.println("                    #  Of         #                         # Jungle      #");
        System.out.println("                    #  Sand       #                         # Enclosure   #");
        System.out.println("                    #             #                         #             #");
        System.out.println("                    ######   ######                         ######   ######");
        System.out.println("                         #   #                                   #   #     ");
        System.out.println("                         #   #                                   #   #     ");
        System.out.println("###############     ######   ######     ###############     ######   ######");
        System.out.println("#             #     #             #     #             #     #             #");
        System.out.println("#             #######             #######             ####### Small       #");
        System.out.println("#Starting Room       Hallway Start        Hallway End         Jungle      #");
        System.out.println("#             #######             #######             ####### Enclosure   #");
        System.out.println("#             #     #             #     #             #     #             #");
        System.out.println("###############     ###############     ###############     ###############");
        System.out.println("\n");

    }
}
