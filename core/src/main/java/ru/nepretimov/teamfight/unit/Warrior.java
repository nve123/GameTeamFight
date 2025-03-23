package ru.nepretimov.teamfight.unit;

public class Warrior extends Unit {
    private int armor;
    private int dmg = 2;

    public Warrior(String name, int hp, int armor) {
        super(name, hp);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    @Override
    public void attack(Unit unit) {
        unit.getDamage(2);
    }

    @Override
    public void getDamage(int dmg) {
        if (armor > 0){
            this.hp -= dmg / 2;
            this.armor -= 2;
        } else {
            this.hp -= dmg;
        }
    }

    public int getDmg(){
        return dmg;
    }
}
