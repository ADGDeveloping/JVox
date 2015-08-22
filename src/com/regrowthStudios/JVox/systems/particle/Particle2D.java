package com.regrowthStudios.JVox.systems.particle;

import org.newdawn.slick.opengl.Texture;

import com.regrowthStudios.JVox.graphics.SpriteBatch;
import com.regrowthStudios.JVox.math.vector.Vector2;
import com.regrowthStudios.JVox.math.vector.Vector4;

public class Particle2D {
    private Vector2 position, velocity;
    private SpriteBatch spriteBatch = null;
    public boolean base = false;

    public int maxLife, currentLife;

    public Particle2D() {
    }

    public void init(Texture t, Vector2 position, Vector2 velocity) {
        this.setPosition(position);
        this.velocity = velocity;

        this.spriteBatch = new SpriteBatch();
        this.spriteBatch.texture = t;
        this.spriteBatch.init(new Vector4(this.getPosition().x, this.getPosition().y, 5, 5));
    }

    public void update() {
        this.getPosition().add(velocity);
        this.spriteBatch.bbox = new Vector4(this.getPosition().x, this.getPosition().y, 5, 5);
    }

    public void render() {
        this.spriteBatch.render();
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
}