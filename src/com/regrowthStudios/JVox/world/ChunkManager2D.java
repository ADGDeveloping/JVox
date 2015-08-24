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
    public int chunkRadius = 3, objectSize = 5;
    public HashMap<Vector, Chunk2D> activeChunks = new HashMap<Vector, Chunk2D>();
    public ArrayList<GenComponent> genComponents = new ArrayList<GenComponent>();
    int centerX, centerY;

    public ChunkManager2D(Camera2D camera) {
        this.camera = camera;
        
        Vector pos = this.toLocal(new Vector(Math.round(camera.getPosition().x / (double)objectSize), Math.round(camera.getPosition().y / (double)objectSize)));

        centerX = (int)pos.x;
        centerY = (int)pos.y;      
    }

    public void init() {
        this.addComponent(new GenComponentTerrain(0, 0));
        
        // Set up initial chunks
        for (int y = (int) centerY - this.chunkRadius; y <= (int) centerY + this.chunkRadius; y++) {
            for (int x = (int) centerX - this.chunkRadius; x <= (int) centerX + this.chunkRadius; x++) {
                Chunk2D c = new Chunk2D(new Vector(x, y));
                c.init();
                c.generate(this);
                c.build();
                c.built = true;
                activeChunks.put(new Vector(x, y), c);
                System.out.println(new Vector(x, y).x + " " + new Vector(x, y).y);
            }
        }
    }

    public void update() {
        Vector pos = this.toLocal(new Vector(Math.round(camera.getPosition().x / (double)objectSize), Math.round(camera.getPosition().y / (double)objectSize)));

        int ncx = (int)pos.x;
        int ncy = (int)pos.y;
        
        while (centerX != ncx) {
            if (ncx < centerX) {
                // Remove chunks from right and add to left
                for (int y = -this.chunkRadius; y <= this.chunkRadius; y++) {
                    // Remove
                    Vector p = new Vector(centerX + this.chunkRadius, centerY + y);
                    Chunk2D c = activeChunks.get(p);
                    c.destroy();
                    activeChunks.remove(p);
                    // Add
                    Vector p2 = new Vector(centerX - this.chunkRadius - 1, centerY + y);
                    Chunk2D c2 = new Chunk2D(p2);
                    c2.init();
                    c2.generate(this);
                    c2.build();
                    c2.built = true;
                    activeChunks.put(p2, c2);
                }
                // Going left
                centerX--;
                System.out.println("L");
            } else {
                // Remove chunks from left and add to right
                for (int y = -this.chunkRadius; y <= this.chunkRadius; y++) {
                    // Remove
                    Vector p = new Vector(centerX - this.chunkRadius, centerY + y);
                    Chunk2D c = activeChunks.get(p);
                    c.destroy();
                    activeChunks.remove(p);
                    // Add
                    Vector p2 = new Vector(centerX + this.chunkRadius + 1, centerY + y);
                    Chunk2D c2 = new Chunk2D(p2);
                    c2.init();
                    c2.generate(this);
                    c2.build();
                    c2.built = true;
                    activeChunks.put(p2, c2);
                }
                // Going right
                centerX++;
                System.out.println("R");
            }
        }
        while (centerY != ncy) {
            if (ncy < centerY) {
                // Remove chunks from top and add to bottom
                for (int x = -this.chunkRadius; x <= this.chunkRadius; x++) {
                    // Remove
                    Vector p = new Vector(centerX + x, centerY + this.chunkRadius);
                    Chunk2D c = activeChunks.get(p);
                    c.destroy();
                    activeChunks.remove(p);
                    // Add
                    Vector p2 = new Vector(centerX + x, centerY - this.chunkRadius - 1);
                    Chunk2D c2 = new Chunk2D(p2);
                    c2.init();
                    c2.generate(this);
                    c2.build();
                    c2.built = true;
                    activeChunks.put(p2, c2);
                }
                // Going down
                centerY--;
                System.out.println("D");
            } else {
                // Remove chunks from bottom and add to top
                for (int x = -this.chunkRadius; x <= this.chunkRadius; x++) {
                    // Remove
                    Vector p = new Vector(centerX + x, centerY - this.chunkRadius);
                    Chunk2D c = activeChunks.get(p);
                    c.destroy();
                    activeChunks.remove(p);
                    // Add
                    Vector p2 = new Vector(centerX + x, centerY + this.chunkRadius + 1);
                    Chunk2D c2 = new Chunk2D(p2);
                    c2.init();
                    c2.generate(this);
                    c2.build();
                    c2.built = true;
                    activeChunks.put(p2, c2);
                }
                // Going right
                centerY++;
                System.out.println("U");
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (Chunk2D c : this.activeChunks.values()) {
            c.render(batch, objectSize);
        }
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
