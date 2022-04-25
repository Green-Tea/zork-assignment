package io.muzoo.lorenzo.ssc.zork;

import io.muzoo.lorenzo.ssc.zork.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int maxHp;
    private int hp;
    private int dmg;
    private boolean alive;
    private List<Item> inventory;

    public Player() {
        maxHp = 200;
        hp = maxHp;
        dmg = 20;
        alive = true;
        inventory = new ArrayList<>();
    }

    public void buffStats(int healAmount, int damageBuff) {
        if (hp + healAmount >= maxHp) {
            hp = maxHp;
        } else {
            hp += healAmount;
        }

        dmg += damageBuff;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp <= 0) {
            alive = false;
        }
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public boolean hasItem(String item) {
        for (Item i : inventory) {
            if (i.getName().equals(item)) {
                return true;
            }
        }
        return false;
    }

    public void pickUpItem(Item item) {
        inventory.add(item);
    }

    public void status() {
        System.out.println("PLAYER STATS");
        System.out.println("HP: " + this.hp + "/" + this.maxHp);
        System.out.println("DMG: " + this.dmg);
        if (inventory.isEmpty()) {
            System.out.println("Your bag is empty.");
        } else {
            System.out.println("INVENTORY");
            for (Item item : inventory) {
                System.out.println("* " + item.getName());
            }
        }
    }
}
