package com.regrowthStudios.JVox.world;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import com.regrowthStudios.JVox.graphics.SpriteBatch;
import com.regrowthStudios.JVox.math.Vector;
import com.regrowthStudios.JVox.systems.content.ResourceSystem;
import com.regrowthStudios.JVox.world.gen.GenComponent;

public class Chunk2D {
    public Vector position = null;
    public boolean built = false;
    public int CHUNK_WIDTH = 32, CHUNK_HEIGHT = 32;
    private int[][] objects = new int[CHUNK_WIDTH][CHUNK_HEIGHT];

    public Chunk2D(Vector position) {
        this.position = position;
    }

    public void init() {
    }

    public void generate(ChunkManager2D chunkManager) {
        for (GenComponent tmp : chunkManager.genComponents) {
            tmp.generate2D(this, chunkManager);
        }
    }

    public void build() {

    }

    public void update() {

    }

    public void render(SpriteBatch batch, float objectSize) {
        Texture tex = (Texture) ResourceSystem.getResource("textures.misc.empty");
        byte color[] = { (byte) 255, (byte) 255, (byte) 255, (byte) 255 };

        for (int i = 0; i < this.CHUNK_WIDTH; i++) {
            for (int j = 0; j < this.CHUNK_HEIGHT; j++) {
                if (this.objects[i][j] != 0) {
                    batch.draw(
                            tex.getTextureID(),
                            (float) ((this.position.x * this.CHUNK_WIDTH * objectSize) + (i * objectSize))
                                    + (objectSize * 0.5f),
                            (float) (((this.position.y * this.CHUNK_HEIGHT * objectSize) + (j * objectSize)) - (Display
                                    .getHeight() / 2.F)) + (objectSize * 0.5f), objectSize, objectSize, 0.0f, 0.0f,
                            tex.getWidth(), tex.getHeight(), 0.0f, color);
                }
            }
        }
    }

    /* Object Functions */
    public void setObject(Vector pos, int type) {
        this.objects[(int) pos.x & (this.CHUNK_WIDTH - 1)][(int) pos.y & (this.CHUNK_HEIGHT - 1)] = type;
    }

    public int getObject(Vector pos) {
        return this.objects[(int) pos.x & (this.CHUNK_WIDTH - 1)][(int) pos.y & (this.CHUNK_HEIGHT - 1)];
    }

    public void destroy() {
        objects = null;
        position = null;
    }
}
