package ru.nepretimov.teamfight;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.nepretimov.teamfight.util.AnimationUtil;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Animation<TextureRegion> orc;
    private float curTime;

    @Override
    public void create() {
        batch = new SpriteBatch();
        Texture image = new Texture("Orc-Attack01.png");
        orc = AnimationUtil.getAnimationFromTexture(image, 6, 1, 1);
        curTime = 0;
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(orc.getKeyFrame(curTime, true), 140, 210);
        batch.end();
        curTime += Gdx.graphics.getDeltaTime();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
