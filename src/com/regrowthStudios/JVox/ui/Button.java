package com.regrowthStudios.JVox.ui;

import org.newdawn.slick.opengl.Texture;

import com.regrowthStudios.JVox.math.vector.IVector2;
import com.regrowthStudios.JVox.utils.EventUtils.EventState;

public class Button extends WidgetContainer {
    public Texture upTexture, downTexture;

    @Override
    public void update(IVector2 mouseMove, IVector2 mousePos) {
        super.update(mouseMove, mousePos);

        if (EventState.checkFor(this.getEventState(), EventState.DOWN_LEFT)) {
       //     this.getSpriteBatch().texture = downTexture;

            this.getBounds().add(mouseMove.x, mouseMove.y, 0, 0);
        } else {
         //   this.getSpriteBatch().texture = upTexture;
        }
    }
}
