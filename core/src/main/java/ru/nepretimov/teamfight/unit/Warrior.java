package ru.nepretimov.teamfight.unit;

import com.badlogic.gdx.graphics.Texture;
import ru.nepretimov.teamfight.util.AnimationUtil;

public class Warrior extends Unit {
    private int armor;
    private int dmg = 2;

    public Warrior(String name, int hp, int armor) {
        super(name, hp, 240, 0, 250, 500);
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

    @Override
    public void initAnimationMaps() {
        enumMap.put(
            UnitState.IDLE,
            AnimationUtil.getAnimationFromTexture(new Texture("Orc-Idle.png"), 6, 1,1)
        );
        enumMap.put(
            UnitState.ATTACK,
            AnimationUtil.getAnimationFromTexture(new Texture("Orc-Attack01.png"), 6, 1,1)
        );
        enumMap.put(
            UnitState.DIE,
            AnimationUtil.getAnimationFromTexture(new Texture("Orc-Death.png"), 4, 1,1)
        );
    }

}
