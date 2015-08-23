package com.regrowthStudios.JVox.ui;

import org.newdawn.slick.opengl.Texture;

import com.regrowthStudios.JVox.math.Vector;
import com.regrowthStudios.JVox.math.Vector4;
import com.regrowthStudios.JVox.utils.EventUtils.EventState;
import com.regrowthStudios.JVox.utils.math.VectorHelper;

public class Button extends WidgetContainer {
    public Texture upTexture, downTexture;

    @Override
    public void update(Vector mouseMove, Vector mousePos) {
        super.update(mouseMove, mousePos);

        if (EventState.checkFor(this.getEventState(), EventState.DOWN_LEFT)) {
       //     this.getSpriteBatch().texture = downTexture;
            
            this.setBounds(VectorHelper.add(this.getBounds(), new Vector4(mouseMove.x, mouseMove.y, 0, 0)));
        } else {
         //   this.getSpriteBatch().texture = upTexture;
        }
    }
}
