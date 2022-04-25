package io.muzoo.lorenzo.ssc.zork.items.weapon;

import io.muzoo.lorenzo.ssc.zork.items.Item;

public class Weapon extends Item {

    private int atkDmg;

    public int getAtkDmg() {
        return atkDmg;
    }

    public Weapon(String name, String desc, int atkDmg) {
        super(name, desc);
        this.atkDmg = atkDmg;
    }
}
