package io.muzoo.lorenzo.ssc.zork.monsters;

public class MonsterFactory {

    public Monster createMonster(String name) {
        switch (name) {
            case "diablos":
                return new Diablos();
            case "furious rajang":
                return new FuriousRajang();
            case "great jagras":
                return new GreatJagras();
            case "rajang":
                return new Rajang();
            case "rathalos":
                return new Rathalos();
            case "velkhana":
                return new Velkhana();
        }
        return null;
    }
}
