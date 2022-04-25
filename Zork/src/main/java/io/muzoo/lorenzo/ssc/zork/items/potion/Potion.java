package io.muzoo.lorenzo.ssc.zork.items.potion;

import io.muzoo.lorenzo.ssc.zork.items.Item;

public class Potion extends Item {

    public int healAmount;
    public int damageBuff;


    public int getHealAmount() {
        return healAmount;
    }

    public int getDamageBuff() {
        return damageBuff;
    }

    public Potion(String name, String desc, int healAmount, int damageBuff) {
        super(name, desc);
        this.healAmount = healAmount;
        this.damageBuff = damageBuff;
    }
}
