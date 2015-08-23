package com.regrowthStudios.JVox.systems.particle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.regrowthStudios.JVox.graphics.SpriteBatch;
import com.regrowthStudios.JVox.utils.EventUtils.MouseEvents;

public class ParticleEmitter {
    private ArrayList<Particle2D> particles = new ArrayList<Particle2D>();
    private Random rand = null;
    private Texture particleTexture = null;

    private int timer = 0;

    public void init() {
        this.rand = new Random();

        try {
            particleTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("data/textures/spark.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        timer++;

        if (MouseEvents.buttonDown(0)) {
            if (timer >= 1) {
                Particle2D tmp = new Particle2D();
                tmp.init(particleTexture, (float) MouseEvents.getPosition().x, (float) MouseEvents.getPositionInvY().y, 5.0f,
                        5.0f, 0.0f, -1.0f);
                tmp.maxLife = rand.nextInt((500 - 250) + 1) + 250;

                particles.add(tmp);

                timer = 0;
            }
        }

        if (particles.size() > 0) {
            for (int i = 0; i < particles.size(); i++) {
                Particle2D tmp = particles.get(i);

                if (tmp != null) {
                    if (tmp.currentLife > tmp.maxLife) {

                        particles.remove(i);
                        particles.trimToSize();
                    } else {
                        tmp.update();
                        tmp.currentLife++;
                    }
                }
            }
        }

        /*
         * System.out.println(this.particles.size());
         * 
         * for (int i = 0; i < particles.size(); i++) { Particle2D tmp =
         * particles.get(i);
         * 
         * if (tmp != null) { //tmp.getPosition().add(rand.nextInt((1 - -1) + 1)
         * + -1, rand.nextInt((1 - -1) + 1) + -1);
         * 
         * if (tmp.currentLife > tmp.maxLife) { particles.remove(i);
         * particles.trimToSize(); } else { tmp.update(); tmp.currentLife++; } }
         * }
         */
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < particles.size(); i++) {
            Particle2D tmp = particles.get(i);

            if (tmp != null) {
                // if ((rand.nextInt((10 - 0) + 1) + 0) == 1) {
                tmp.render(batch);
                // }
            }
        }
    }
}
