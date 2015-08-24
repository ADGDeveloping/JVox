package com.regrowthStudios.JVox.systems.particle;

public class Particle2D {
    public float x, y;
    protected float vx, vy;
    protected float sx, sy;
    public int maxLife, currentLife;

    public void init(float x, float y, float vx, float vy, float sx, float sy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.sx = sx;
        this.sy = sy;
    }

    public void update() {
        x += vx;
        y += vy;
    }
}