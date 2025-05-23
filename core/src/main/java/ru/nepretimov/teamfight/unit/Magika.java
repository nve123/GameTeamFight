package ru.nepretimov.teamfight.unit;

import com.badlogic.gdx.graphics.Texture;
import ru.nepretimov.teamfight.util.AnimationUtil;

public class Magika extends Unit {
    private int mp;
    private int dmg = 5;

    public Magika(String name, int hp, int mp) {
        super(name, hp, 0, 0, 250, 500);
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
