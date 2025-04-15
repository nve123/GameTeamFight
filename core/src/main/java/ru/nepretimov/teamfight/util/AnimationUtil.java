package ru.nepretimov.teamfight.util;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationUtil {
    public static Animation<TextureRegion> getAnimationFromTexture(
            Texture png,
            int numberFrameWidth,
            int numberFrameHeight,
            float timeAnimation
    ) {
        TextureRegion[][] textureRegions = TextureRegion.split(
                png,
                png.getWidth() / numberFrameWidth,
                png.getHeight() / numberFrameHeight
        );
        int numberOfFrames = numberFrameWidth * numberFrameHeight;
        TextureRegion[] frameArray = new TextureRegion[numberOfFrames];
        int countFrames =  0;
        for (int i = 0; i < textureRegions.length; i++) {
            for (int j = 0; j < textureRegions[i].length; j++) {
                frameArray[countFrames] = textureRegions[i][j];
                countFrames++;
            }
        }
        Animation<TextureRegion> animation = new Animation<>(timeAnimation/numberOfFrames, frameArray);
        return animation;
    }
}
