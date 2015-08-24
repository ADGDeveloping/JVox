package com.regrowthStudios.JVox.world;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.regrowthStudios.JVox.graphics.Camera2D;
import com.regrowthStudios.JVox.graphics.SpriteBatch;
import com.regrowthStudios.JVox.math.Vector;
import com.regrowthStudios.JVox.world.gen.GenComponent;
import com.regrowthStudios.JVox.world.gen.GenComponentTerrain;

public class ChunkManager2D {
    private Camera2D camera = null;
    private int chunkRadius = 3, objectSize = 2;
    public HashMap<Vector, Chunk2D> activeChunks = new HashMap<Vector, Chunk2D>();
    public ArrayList<GenComponent> genComponents = new ArrayList<GenComponent>();

    public ChunkManager2D(Camera2D camera) {
        this.camera = camera;
    }

    public void init() {
        this.addComponent(new GenComponentTerrain(0, 0));
    }

    public void update() {
        Vector pos = this.toLocal(new Vector(Math.round(camera.getPosition().x / (double)objectSize), Math.round(camera.getPosition().y / (double)objectSize)));

        for (int j = (int) pos.y + this.chunkRadius; j >= (int) pos.y - this.chunkRadius; j--) {
            for (int i = (int) pos.x + this.chunkRadius; i >= (int) pos.x - this.chunkRadius; i--) {

                if (Math.abs(pos.x - i) <= (this.chunkRadius)
                        && Math.abs(pos.y - j) <= (this.chunkRadius)) {
                    Chunk2D c = this.activeChunks.get(new Vector(i, j));

                    if (c == null) {
                        c = new Chunk2D(new Vector(i, j));
                        c.init();

                        activeChunks.put(new Vector(i, j), c);
                    } else {
                        c.update();
                    }
                    
                    if (c != null && !c.built) {
                        c.generate(this);
                        c.build();
                        c.built = true;
                    }
                }
                else
                {
                    if (this.activeChunks.get(new Vector(i, j)) != null) {
                        this.activeChunks.get(new Vector(i, j)).destroy();
                        this.activeChunks.remove(new Vector(i, j));
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        double chunkWidth = objectSize * 32.0;
        Vector pos = this.toLocal(new Vector(Math.round(camera.getPosition().x), Math.round(camera.getPosition().y)));

        for (int j = (int) pos.y + this.chunkRadius; j > pos.y - (this.chunkRadius * 2); j--) {
            for (int i = (int) pos.x + this.chunkRadius; i > pos.x - (this.chunkRadius * 2); i--) {
                double x = (i * chunkWidth);
                double y = (j * chunkWidth);

                if (Math.abs(this.camera.getPosition().x - x) <= (chunkWidth * this.chunkRadius)
                        && Math.abs(this.camera.getPosition().y - y) <= (chunkWidth * this.chunkRadius)) {
                    Chunk2D c = this.activeChunks.get(new Vector(i, j));

                    if (c != null) {
                        c.render(batch, objectSize);
                    }
                }
            }
        }
    }

    /* Object Functions */
    public void setObject(Vector pos, int type) {
        Vector chunkPos = toLocal(pos);
        Chunk2D c = activeChunks.get(chunkPos);

        if (c != null) {
            c.setObject(pos, type);
        }
    }

    public int getObject(Vector pos) {
        Vector chunkPos = toLocal(pos);
        Chunk2D c = activeChunks.get(chunkPos);

        if (c != null) {
            return c.getObject(pos);
        }

        return 0;
    }

    /* Other functions */
    public Vector toLocal(Vector pos) {
        Vector global = pos;
        Vector chunkPos = new Vector();

        chunkPos.x = (int) global.x >> 5;
        chunkPos.y = (int) global.y >> 5;

        return chunkPos;
    }

    public void sortComponents() {
        Collections.sort(this.genComponents);
    }

    public void addComponent(GenComponent genComponent) {
        this.genComponents.add(genComponent);
    }
}
