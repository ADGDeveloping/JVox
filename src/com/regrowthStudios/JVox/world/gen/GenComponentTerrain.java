package com.regrowthStudios.JVox.world.gen;

import com.regrowthStudios.JVox.math.Noise.BetterNoise;
import com.regrowthStudios.JVox.math.Noise.SimplexNoise;
import com.regrowthStudios.JVox.math.Vector;
import com.regrowthStudios.JVox.world.Chunk2D;
import com.regrowthStudios.JVox.world.ChunkManager2D;

public class GenComponentTerrain extends GenComponent {
    public GenComponentTerrain(int componentID, int priority) {
        super(componentID, priority);
    }

    float noise(Vector position, int octaves, float frequency, float persistence) {
        float total = 0.0f;
        float maxAmplitude = 0.0f;
        float amplitude = 1.0f;
        for (int i = 0; i < octaves; i++) {
            total += SimplexNoise.noise(position.x * frequency, position.y) * amplitude;
            frequency *= 2.0;
            maxAmplitude += amplitude;
            amplitude *= persistence;
        }
        return total / maxAmplitude;
    }

    @Override
    public void generate2D(Chunk2D c, ChunkManager2D chunkManager) {
        for (int i = 0; i < c.CHUNK_WIDTH; i++) {
            for (int j = 0; j < c.CHUNK_HEIGHT; j++) {
                double h = 32.0 * (BetterNoise.perlinNoise2D(i + (c.position.x * c.CHUNK_WIDTH), j
                        + (c.position.y * c.CHUNK_HEIGHT), 2983, 16, 0.5, 32.0));
                
                /*h += 32.F * noise(new Vector(i + (c.position.x * c.CHUNK_WIDTH), j
                        + (c.position.y * c.CHUNK_HEIGHT)), 8, 0.003F, 0.8F);*/

                if (h - (j + c.position.y * c.CHUNK_WIDTH) > 0) {
                    c.setObject(i, j, 1);
                }
            }
        }
    }
}
