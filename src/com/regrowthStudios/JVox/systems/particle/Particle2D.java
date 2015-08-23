package com.regrowthStudios.JVox.systems.particle;

import org.newdawn.slick.opengl.Texture;

import com.regrowthStudios.JVox.graphics.SpriteBatch;

public class Particle2D {
    public float x, y;
    private float vx, vy;
    private float sx, sy;
    public int maxLife, currentLife;
    private Texture texture;
    private byte[] color = new byte[4];

    public Particle2D() {
    }

    public void init(Texture t, float x, float y, float vx, float vy, float sx, float sy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.sx = sx;
        this.sy = sy;
        texture = t;
        color[0] = (byte) 255;
        color[1] = (byte) 255;
        color[2] = (byte) 255;
        color[3] = (byte) 255;
    }

    public void update() {
        x += vx;
        y += vy;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture.getTextureID(), x + sx * 0.5f, y + sy * 0.5f, sx, sy, 0.0f, 0.0f, texture.getWidth(), texture.getHeight(), 0.0f, color);
    }
}