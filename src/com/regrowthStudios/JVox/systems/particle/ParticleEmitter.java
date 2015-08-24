package com.regrowthStudios.JVox.systems.particle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.regrowthStudios.JVox.graphics.SpriteBatch;
import com.regrowthStudios.JVox.math.Vector;
import com.regrowthStudios.JVox.utils.EventUtils.MouseEvents;

public class ParticleEmitter {
    static Random random = new Random();
    public float x, y;
    public int particlesPerSpawn = 1;
    public int framesUntilSpawn = 1;
    public int maxParticleLife = 500;
    public int minParticleLife = 250;
    public float particleWidth = 5.0f;
    public float particleHeight = 5.0f;
    public Vector direction = new Vector();
    public float spawnAngle = (float)Math.PI;
    public byte color[] = new byte[4];
    private int frame = 0;
    private ArrayList<Particle2D> particles = new ArrayList<Particle2D>();
    private Texture particleTexture = null;

    public void init(Texture texture, float x, float y, float dirX, float dirY) {
        particleTexture = texture;
        color[0] = (byte)255;
        color[1] = (byte)255;
        color[2] = (byte)255;
        color[3] = (byte)255;
        this.x = x;
        this.y = y;
        direction.x = dirX;
        direction.y = dirY;
        direction.normalizeLocal();
    }
    
    public void setColor(byte r, byte g, byte b, byte a) {
        color[0] = r;
        color[1] = g;
        color[2] = b;
        color[3] = a;
    }

    public void update() {
        frame++;
        if (frame >= framesUntilSpawn) {
            for (int i = 0; i < particlesPerSpawn; i++) {
                Particle2D p = new Particle2D();
                
                float angle = ((random.nextInt(Integer.MAX_VALUE)) / (float)(Integer.MAX_VALUE) * 2.0f - 1.0f) * spawnAngle;
                float dx = (float)direction.x * (float) Math.cos(angle) - (float)direction.y * (float) Math.sin(angle);
                float dy = (float)direction.x * (float) Math.sin(angle) + (float)direction.y * (float) Math.cos(angle);
                
                p.init((float)x, (float)y, dx, dy, particleWidth, particleHeight);
                p.maxLife = random.nextInt((maxParticleLife - minParticleLife) + 1) + minParticleLife;
    
                particles.add(p);
            }
            frame = 0;
        }

        if (particles.size() > 0) {
            for (int i = particles.size() - 1; i >= 0; i--) {
                Particle2D tmp = particles.get(i);

                if (tmp != null) {
                    if (tmp.currentLife > tmp.maxLife) {
                        
                        particles.set(i, particles.get(particles.size() - 1));
                        particles.remove(particles.size() - 1);
                    } else {
                        tmp.update();
                        tmp.currentLife++;
                    }
                }
            }
        } else {
            particles.trimToSize();
        }

    }

    public void render(SpriteBatch batch) {
        for (Particle2D p : particles) {
            batch.draw(particleTexture.getTextureID(), p.x + p.sx * 0.5f, p.y + p.sy * 0.5f, p.sx, p.sy, 0.0f, 0.0f, particleTexture.getWidth(), particleTexture.getHeight(), 0.0f, color);
        }
    }
}
