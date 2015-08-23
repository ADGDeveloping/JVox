package com.regrowthStudios.JVox.ui;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.regrowthStudios.JVox.graphics.SpriteBatch;
import com.regrowthStudios.JVox.math.Vector;
import com.regrowthStudios.JVox.utils.EventUtils.EventState;

public class Button extends WidgetContainer {
    public Texture upTexture, downTexture;
    public Texture texture;

    public Button() {
        try {
            upTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("data/textures/up.png"));
            downTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("data/textures/down.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        texture = upTexture;
    }

    @Override
    public void update(Vector mouseMove, Vector mousePos) {
        super.update(mouseMove, mousePos);

        if (EventState.checkFor(this.getEventState(), EventState.DOWN_LEFT)) {
            texture = downTexture;
        } else {
            texture = upTexture;
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture.getTextureID(), (float) bbox.x, (float) bbox.y, (float) bbox.z, (float) bbox.w, 0.0f, 0.0f,
                texture.getWidth(), texture.getHeight(), 0.0f, color);
    }
}
