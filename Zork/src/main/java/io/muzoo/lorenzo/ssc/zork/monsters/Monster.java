package io.muzoo.lorenzo.ssc.zork.monsters;

public class Monster {

    private String name;
    private String desc;
    private int maxHp;
    private int hp;
    private int dmg;
    private double attackProb;
    private boolean alive;

    public Monster(String name, String desc, int hp, int dmg, double attackProb) {
        this.name = name;
        this.desc = desc;
        this.maxHp = hp;
        this.hp = hp;
        this.dmg = dmg;
        this.attackProb = attackProb;
        alive = true;
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp <= 0) {
            alive = false;
        }
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getDmg() {
        return dmg;
    }

    public double getAttackProb() {
        return attackProb;
    }

    public boolean isAlive() {
        return alive;
    }

    public void monsterStats() {
        System.out.println("MONSTER STATS");
        System.out.println("NAME: " + name);
        System.out.println("HP: " + hp + "/" + maxHp);
        System.out.println("DESCRIPTION: " + desc);
    }
}
