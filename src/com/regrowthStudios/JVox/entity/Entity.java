package com.regrowthStudios.JVox.entity;

import com.regrowthStudios.JVox.graphics.SpriteBatch;
import com.regrowthStudios.JVox.math.Vector4;

public class Entity {
    public Vector4 aabb = new Vector4();
    public int entityID = 0;
    public byte color[] = new byte[4];

    public Entity(int eID, Vector4 aabb) {
        this.entityID = eID;
        this.aabb = aabb;
        
        // Set color
        color[0] = (byte) 255;
        color[1] = (byte) 255;
        color[2] = (byte) 255;
        color[3] = (byte) 255;
    }

    public void render(SpriteBatch batch) {
        batch.draw(0, (float) aabb.x + (float) aabb.z * 0.5f, (float) aabb.y + (float) aabb.w * 0.5f, (float) aabb.z,
                (float) aabb.w, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, color);
    }

    public void update() {

    }
}
