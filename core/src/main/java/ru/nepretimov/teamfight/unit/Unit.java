package ru.nepretimov.teamfight.unit;

public abstract class Unit {
    protected String name;
    protected int hp;
    protected boolean isAlive;

    public Unit(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        if (hp > 0) {
            isAlive = true;
        } else {
            isAlive = false;
        }
        return isAlive;
    }

    public abstract void attack(Unit unit);

    public abstract void getDamage(int dmg);

    public abstract int getDmg();
}
