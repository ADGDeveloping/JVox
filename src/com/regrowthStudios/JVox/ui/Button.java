package com.regrowthStudios.JVox.ui;

import org.newdawn.slick.opengl.Texture;

import com.regrowthStudios.JVox.graphics.SpriteBatch;
import com.regrowthStudios.JVox.math.Vector;
import com.regrowthStudios.JVox.systems.content.ResourceSystem;
import com.regrowthStudios.JVox.utils.EventUtils.EventState;

public class Button extends WidgetContainer {
    public Texture upTexture, downTexture;
    public Texture texture;

    public Button() {
        this.upTexture = (Texture) ResourceSystem.getResource("textures.button.up");
        this.downTexture = (Texture) ResourceSystem.getResource("textures.button.down");

        this.texture = this.upTexture;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(this.texture.getTextureID(), (float) this.bbox.x + (float) this.bbox.z * 0.5f, (float) this.bbox.y
                + (float) this.bbox.w * 0.5f, (float) this.bbox.z, (float) this.bbox.w, 0.0f, 0.0f, this.texture.getWidth(),
                this.texture.getHeight(), 0.0f, this.color);
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
}
