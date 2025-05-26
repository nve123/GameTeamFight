package ru.nepretimov.teamfight.unit;

import com.badlogic.gdx.graphics.Texture;
import ru.nepretimov.teamfight.util.AnimationUtil;

public class MachineGunner extends Unit {
    private int ammo;
    private int dmg = 10;

    public MachineGunner(String name, int hp, int ammo) { // у этих юнитов мало хп но много дмаги
        super(name, hp, 0, 0, 250, 500);
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

    @Override
    public void initAnimationMaps() {
        enumMap.put(
            UnitState.IDLE,
            AnimationUtil.getAnimationFromTexture(new Texture("Soldier-Idle.png"), 6, 1,1)
        );
        enumMap.put(
            UnitState.ATTACK,
            AnimationUtil.getAnimationFromTexture(new Texture("Soldier-Attack03.png"), 9, 1,1)
        );
        enumMap.put(
            UnitState.DIE,
            AnimationUtil.getAnimationFromTexture(new Texture("Soldier-Death.png"), 4, 1,1)
        );
    }
}
