package com.regrowthStudios.JVox.ui;

import java.io.IOException;

import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.regrowthStudios.JVox.graphics.SpriteBatch;
import com.regrowthStudios.JVox.math.vector.IVector2;
import com.regrowthStudios.JVox.math.vector.IVector4;
import com.regrowthStudios.JVox.utils.EventUtils.EventState;
import com.regrowthStudios.JVox.utils.EventUtils.MouseEvents;

public class WidgetContainer {
    private SpriteBatch spriteBatch = null;
    private IVector4 bbox = new IVector4(0);
    private int eventState = EventState.NONE;

    public SpriteBatch getSpriteBatch() {
        return this.spriteBatch;
    }

    public void setSpriteBatch(SpriteBatch sb) {
        this.spriteBatch = sb;
    }

    public int getEventState() {
        return this.eventState;
    }

    public void setBounds(IVector4 bounds) {
        this.bbox = bounds;
    }

    public IVector4 getBounds() {
        return this.bbox;
    }

    // Override
    public void init(IVector4 bbox) {
        this.bbox = bbox;
        this.spriteBatch = new SpriteBatch();

        try {
            this.spriteBatch.texture = TextureLoader.getTexture("PNG",
                    ResourceLoader.getResourceAsStream("data/textures/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.spriteBatch.init(bbox);
    }

    public void draw() {
        this.spriteBatch.render();
    }

    public void update(IVector2 mouseMove, IVector2 mousePos) {
        eventState = EventState.NONE;

        if (this.isInBounds(mousePos.x, mousePos.y)) {
            eventState = EventState.HOVER;

            if (MouseEvents.buttonDown(0)) {
                eventState = EventState.HOVER | EventState.DOWN_LEFT;
            } else if (MouseEvents.buttonDown(1)) {
                eventState = EventState.HOVER | EventState.DOWN_RIGHT;
            } else if (MouseEvents.buttonDown(2)) {
                eventState = EventState.HOVER | EventState.DOWN_MID;
            } else {
                if (MouseEvents.buttonUp(0)) {
                    eventState = EventState.HOVER | EventState.UP_LEFT;
                } else if (MouseEvents.buttonUp(1)) {
                    eventState = EventState.HOVER | EventState.UP_RIGHT;
                } else if (MouseEvents.buttonUp(2)) {
                    eventState = EventState.HOVER | EventState.UP_MID;
                }
            }
        }
    }

    // Functions
    public boolean isInBounds(int mX, int mY) {
        return (mX >= bbox.x && mX < bbox.x + bbox.z && mY >= bbox.y && mY < bbox.y + bbox.w);
    }
}
