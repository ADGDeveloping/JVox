package com.regrowthStudios.JVox.audio.types;

import paulscode.sound.SoundSystemConfig;

import com.regrowthStudios.JVox.math.vector.Vector;
import com.regrowthStudios.JVox.utils.SoundUtils.SoundFlags;

public class Sound3D extends Sound {
    /**
     * Standard implementation for 3D sound.
     */
    protected int flags = SoundFlags.NONE;
    protected Vector position = new Vector(0);

    public void init(int flags, String sn, String fl, Vector p) {
        this.flags = flags;
        this.sourceName = sn;
        this.fileLocation = fl;
        this.position = p;
    }

    @Override
    public void create() {
        boolean loop = SoundFlags.checkFor(this.flags, SoundFlags.LOOP);
        boolean priority = SoundFlags.checkFor(this.flags, SoundFlags.PRIORITY);

        this.soundSystem.newSource(priority, this.sourceName,
                this.fileLocation, loop, this.position.x, this.position.y,
                this.position.z, SoundSystemConfig.ATTENUATION_ROLLOFF,
                SoundSystemConfig.getDefaultRolloff());
    }
}