package ru.nepretimov.teamfight;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.nepretimov.teamfight.unit.UnitState;
import ru.nepretimov.teamfight.unit.Warrior;
import ru.nepretimov.teamfight.util.AnimationUtil;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private float curTime;
    private Warrior warrior;

    @Override
    public void create() {
        batch = new SpriteBatch();
        curTime = 0;
        warrior = new Warrior("Jane Doe",100,10);
        warrior.setCurState(UnitState.ATTACK);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        float deltaTime = Gdx.graphics.getDeltaTime();
        warrior.setTimeInState(deltaTime);
        batch.begin();
        warrior.draw(batch);
        batch.end();
        curTime += deltaTime;
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
