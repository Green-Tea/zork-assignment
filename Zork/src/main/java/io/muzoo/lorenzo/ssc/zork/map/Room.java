package io.muzoo.lorenzo.ssc.zork.map;

import io.muzoo.lorenzo.ssc.zork.items.Item;
import io.muzoo.lorenzo.ssc.zork.monsters.Monster;
import io.muzoo.lorenzo.ssc.zork.items.weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private Room northExit;
    private Room eastExit;
    private Room westExit;
    private Room southExit;
    private List<String> allExits;
    private List<Item> items;
    private List<Weapon> weapons;
    private Monster monster;
    private String desc;

    public Room(String desc) {
        northExit = null;
        eastExit = null;
        westExit = null;
        southExit = null;
        allExits = new ArrayList<>();
        items = new ArrayList<>();
        weapons = new ArrayList<>();
        monster = null;
        this.desc = desc;
    }

    public Room getNorthExit() {
        return northExit;
    }

    public void setNorthExit(Room room) {
        this.northExit = room;
        allExits.add("north");
        northExit.southExit = this; // The north exit leads to the south exit of the next room
    }

    public Room getEastExit() {
        return eastExit;
    }

    public void setEastExit(Room room) {
        this.eastExit = room;
        allExits.add("east");
        eastExit.westExit = this;
    }

    public Room getWestExit() {
        return westExit;
    }

    public void setWestExit(Room room) {
        this.westExit = room;
        allExits.add("west");
        westExit.eastExit = this;
    }

    public Room getSouthExit() {
        return southExit;
    }

    public void setSouthExit(Room room) {
        this.southExit = room;
        allExits.add("south");
        southExit.northExit = this;
    }

    public List<String> getAllExits() {
        return allExits;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItem(Item item) {
        this.items.add(item);
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon weapons) {
        this.weapons.add(weapons);
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getDesc() {
        return desc;
    }

    public boolean hasMonster() {
        return monster != null;
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public void roomStats() {
        System.out.println(desc);
        System.out.println("Doors: " + getAllExits());
        if (!getItems().isEmpty()) {
            List<String> itemList = new ArrayList<>();
            for (Item item: items) {
                itemList.add(item.getName());
            }
            System.out.println("Items: " + itemList);
        } else {
            System.out.println("Items: None");
        }

        if (hasMonster()) {
            System.out.println("Monster: " + getMonster().getName());
        } else {
            System.out.println("There are no monsters. This room is safe.");
        }
    }

}
