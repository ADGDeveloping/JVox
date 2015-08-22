package com.regrowthStudios.JVox.systems.particle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.regrowthStudios.JVox.math.vector.Vector2;
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
            /*for (int i = 0; i < 100; i++) {
                Particle2D tmp = new Particle2D();
                tmp.init(particleTexture, new Vector2(MouseEvents.getPosition().x, MouseEvents.getPositionInvY().y),
                        new Vector2((rand.nextInt((100 - -100) + 1) + -100) / 100.F,
                                (rand.nextInt((100 - -100) + 1) + -100) / 100.F));
                tmp.maxLife = rand.nextInt((1000 - 10) + 1) + 10;

                particles.add(tmp);
            }*/
            
            if(timer >= 1) {
                Particle2D tmp = new Particle2D();
                tmp.init(particleTexture, new Vector2(MouseEvents.getPosition().x, MouseEvents.getPositionInvY().y),
                        new Vector2(0, -1));
                tmp.maxLife = rand.nextInt((500 - 250) + 1) + 250;
                tmp.base = true;
                
                particles.add(tmp);
                
                timer = 0;
            }
        }
        
        if(particles.size() > 0) {
            for (int i = 0; i < particles.size(); i++) {
                Particle2D tmp = particles.get(i);

                if (tmp != null) {
                    if (tmp.currentLife > tmp.maxLife) {
                        if(tmp.base)
                        {
                            for(int i2 = 0; i2 < 100; i2++)
                            {
                                Particle2D tmp2 = new Particle2D();
                                tmp2.init(particleTexture, new Vector2((int)tmp.getPosition().x, (int)tmp.getPosition().y),
                                        new Vector2((rand.nextInt((100 - -100) + 1) + -100) / 250.F,
                                                (rand.nextInt((100 - -100) + 1) + -100) / 250.F));
                                tmp2.maxLife = rand.nextInt((500 - 10) + 1) + 10;

                                particles.add(tmp2);
                            }
                        }
                        
                        particles.remove(i);
                        particles.trimToSize();
                    } else {
                        tmp.update();
                        tmp.currentLife++;
                        
                        if(!tmp.base)
                        {
                            tmp.getPosition().add(0, 0.01F);
                        }
                    }
                }
            }
        }
        
        /*System.out.println(this.particles.size());

        for (int i = 0; i < particles.size(); i++) {
            Particle2D tmp = particles.get(i);

            if (tmp != null) {
                //tmp.getPosition().add(rand.nextInt((1 - -1) + 1) + -1, rand.nextInt((1 - -1) + 1) + -1);

                if (tmp.currentLife > tmp.maxLife) {
                    particles.remove(i);
                    particles.trimToSize();
                } else {
                    tmp.update();
                    tmp.currentLife++;
                }
            }
        }*/
    }

    public void render() {
        for (int i = 0; i < particles.size(); i++) {
            Particle2D tmp = particles.get(i);

            if (tmp != null) {
                //if ((rand.nextInt((10 - 0) + 1) + 0) == 1) {
                    tmp.render();
                //}
            }
        }
    }
}
