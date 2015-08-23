package com.regrowthStudios.JVox.ui;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.regrowthStudios.JVox.graphics.SpriteBatch;
import com.regrowthStudios.JVox.math.Vector;
import com.regrowthStudios.JVox.math.Vector4;
import com.regrowthStudios.JVox.utils.EventUtils.EventState;
import com.regrowthStudios.JVox.utils.EventUtils.MouseEvents;

public class WidgetContainer {
    private Vector4 bbox = new Vector4();
    private int eventState = EventState.NONE;
    private Texture texture;
    public byte color[] = new byte[4];

    public int getEventState() {
        return this.eventState;
    }

    public void setBounds(Vector4 bounds) {
        this.bbox = bounds;
    }

    public Vector4 getBounds() {
        return this.bbox;
    }

    // Override
    public void init(Vector4 bbox) {
        this.bbox = bbox;
        
        try {
            texture = TextureLoader.getTexture("PNG",
                      ResourceLoader.getResourceAsStream("data/textures/test.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        // Set color
        color[0] = (byte)255;
        color[1] = (byte)255;
        color[2] = (byte)255;
        color[3] = (byte)255;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture.getTextureID(), (float)bbox.x, (float)bbox.y, (float)bbox.z, (float)bbox.w, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, color);
    }

    public void update(Vector mouseMove, Vector mousePos) {
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
    public boolean isInBounds(double x, double y) {
        return (x >= bbox.x && x < bbox.x + bbox.z && y >= bbox.y && y < bbox.y + bbox.w);
    }
}
