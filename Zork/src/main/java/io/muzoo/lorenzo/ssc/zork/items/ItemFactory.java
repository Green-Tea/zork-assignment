package io.muzoo.lorenzo.ssc.zork.items;

import io.muzoo.lorenzo.ssc.zork.items.potion.*;
import io.muzoo.lorenzo.ssc.zork.items.weapon.*;

public class ItemFactory {

    public Potion createPotion(String name) {
        switch (name.toLowerCase()) {
            case "demon drug":
                return new DemonDrug();
            case "life powder":
                return new LifePowder();
            case "mega potion":
                return new MegaPotion();
            case "might pill":
                return new MightPill();
        }
        return null;
    }

    public Weapon createWeapon(String name) {
        switch (name.toLowerCase()) {
            case "bow":
                return new Bow();
            case "dual blades":
                return new DualBlades();
            case "great sword":
                return new GreatSword();
            case "long sword":
                return new LongSword();
        }
        return null;
    }

    public Key createKey(String name) {
        return new Key();
    }

}
