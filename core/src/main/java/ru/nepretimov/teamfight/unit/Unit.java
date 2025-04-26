package ru.nepretimov.teamfight.unit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.EnumMap;

public abstract class Unit {
    protected String name;
    protected int hp;
    protected boolean isAlive;
    protected float x;
    protected float y;
    protected float wight;
    protected float height;
    protected UnitState curState;
    protected EnumMap<UnitState, Animation<TextureRegion>> enumMap;
    protected float timeInState;

    public Unit(String name, int hp, float x,float y, float wight, float height) {
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
        this.x = x;
        this.y = y;
        this.wight = wight;
        this.height = height;
        enumMap = new EnumMap<>(UnitState.class);
        initAnimationMaps();
        setCurState(UnitState.IDLE);
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

    public void setCurState (UnitState state){
        timeInState = 0;
        curState = state;
    }

    public void setTimeInState (float dTime){
        timeInState += dTime;
    }

    public TextureRegion getCurFrame (){

        return enumMap.get(curState).getKeyFrame(timeInState, true);
    }

    public void draw (SpriteBatch batch){
        batch.draw(getCurFrame(), x, y, wight, height);
    }

    public abstract void attack(Unit unit);

    public abstract void getDamage(int dmg);

    public abstract int getDmg();

    public abstract void initAnimationMaps();
}
