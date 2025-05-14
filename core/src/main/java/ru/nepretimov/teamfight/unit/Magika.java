package ru.nepretimov.teamfight.unit;

public class Magika extends Unit {
    private int mp;
    private int dmg = 5;

    public Magika(String name, int hp, int mp) {
        super(name, hp, 120, 0, 120, 120);
        this.mp = mp;
    }

    public int getMp() {
        return mp;
    }

    @Override
    public void attack(Unit unit) {
        if (mp > 0) {
            unit.getDamage(5);
            this.mp -= 2;

        } else {
            this.mp += 2;
        }
    }

    @Override
    public void getDamage(int dmg) {
        this.hp -= dmg;
    }

    public int getDmg(){
        return dmg;
    }

    @Override
    public void initAnimationMaps() {

    }
}
