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
    private int chunkRadius = 3, objectSize = 5;
    public HashMap<Vector, Chunk2D> activeChunks = new HashMap<Vector, Chunk2D>();
    public ArrayList<GenComponent> genComponents = new ArrayList<GenComponent>();

    public ChunkManager2D(Camera2D camera) {
        this.camera = camera;
    }

    public void init() {
        this.addComponent(new GenComponentTerrain(0, 0));
    }

    public void update() {
        Vector pos = this.toLocal(new Vector(Math.round(camera.getPosition().x), Math.round(camera.getPosition().y)));

        for (int j = (int) pos.y + this.chunkRadius; j > pos.y - (this.chunkRadius * 2); j--) {
            for (int i = (int) pos.x + this.chunkRadius; i > pos.x - (this.chunkRadius * 2); i--) {
                double x = (i * 32.0);
                double y = (j * 32.0);

                if (Math.abs(this.camera.getPosition().x - x) <= (32.0 * this.chunkRadius)
                        && Math.abs(this.camera.getPosition().y - y) <= (32.0 * this.chunkRadius)) {
                    Chunk2D c = this.activeChunks.get(new Vector(i, j));

                    if (c == null) {
                        c = new Chunk2D(new Vector(i, j));
                        c.init();

                        activeChunks.put(new Vector(i, j), c);
                    } else {
                        c.update();
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

        for (int j = (int) pos.y + this.chunkRadius; j > pos.y - (this.chunkRadius * 2); j--) {
            for (int i = (int) pos.x + this.chunkRadius; i > pos.x - (this.chunkRadius * 2); i--) {
                double x = (i * 32.0);
                double y = (j * 32.0);

                if (Math.abs(this.camera.getPosition().x - x) <= (32.0 * this.chunkRadius)
                        && Math.abs(this.camera.getPosition().y - y) <= (32.0 * this.chunkRadius)) {
                    Chunk2D c = this.activeChunks.get(new Vector(i, j));

                    if (c != null && !c.built) {
                        c.generate(this);
                        c.build();
                        c.built = true;

                        activeChunks.put(new Vector(i, j), c);
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        Vector pos = this.toLocal(new Vector(Math.round(camera.getPosition().x), Math.round(camera.getPosition().y)));

        for (int j = (int) pos.y + this.chunkRadius; j > pos.y - (this.chunkRadius * 2); j--) {
            for (int i = (int) pos.x + this.chunkRadius; i > pos.x - (this.chunkRadius * 2); i--) {
                double x = (i * 32);
                double y = (j * 32);

                if (Math.abs(this.camera.getPosition().x - x) <= (32.0 * this.chunkRadius)
                        && Math.abs(this.camera.getPosition().y - y) <= (32.0 * this.chunkRadius)) {
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
