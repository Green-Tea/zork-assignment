package io.muzoo.lorenzo.ssc.zork.items;


public class Item {

    private final String name;
    private final String effect;

    public Item(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
