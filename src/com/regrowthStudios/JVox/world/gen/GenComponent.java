package com.regrowthStudios.JVox.world.gen;

import com.regrowthStudios.JVox.world.Chunk2D;
import com.regrowthStudios.JVox.world.ChunkManager2D;

public class GenComponent implements Comparable<GenComponent> {
    public int componentID = 0;
    private int priority = 0;

    public GenComponent(int componentID, int priority) {
        this.componentID = 0;
        this.priority = priority;
    }

    public void generate2D(Chunk2D c, ChunkManager2D chunkManager) { }
    public void generate3D() { }

    /* Other functions */
    public int getPriority() {
        return this.priority;
    }

    @Override
    public int compareTo(GenComponent other) {
        return this.getPriority() - other.getPriority();
    }
}
