package ru.nepretimov.teamfight.unit;

public class MachineGunner extends Unit {
    private int ammo;
    private int dmg = 10;

    public MachineGunner(String name, int hp, int ammo) { // у этих юнитов мало хп но много дмаги
        super(name, hp);
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getHp() {
        return super.getHp();
    }

    @Override
    public void attack(Unit unit) {
        if (ammo > 0) {
            unit.getDamage(10);
            this.ammo -= 10;
        } else {
            System.out.println("Недостаточно амуниции");
        }
    }

    @Override
    public void getDamage(int dmg) {
        this.hp -= dmg;
    }

    public int getDmg(){
        return dmg;
    }
}
