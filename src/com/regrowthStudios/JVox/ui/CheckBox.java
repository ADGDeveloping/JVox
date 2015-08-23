package com.regrowthStudios.JVox.ui;

import org.newdawn.slick.opengl.Texture;

import com.regrowthStudios.JVox.math.Vector;
import com.regrowthStudios.JVox.utils.EventUtils.EventState;

public class CheckBox extends WidgetContainer {
    public Texture uncheckedTexture, checkedTexture;
    private int timer = 0;
    private boolean toggled = false;

    @Override
    public void update(Vector mouseMove, Vector mousePos) {
        super.update(mouseMove, mousePos);

        timer++;

        if (timer >= 100 && EventState.checkFor(this.getEventState(), EventState.DOWN_LEFT)) {
            this.toggled = !this.toggled;

            if (this.toggled) {
                //this.getSpriteBatch().texture = uncheckedTexture;
            } else {
               // this.getSpriteBatch().texture = checkedTexture;
            }

            timer = 0;
        }
    }
}