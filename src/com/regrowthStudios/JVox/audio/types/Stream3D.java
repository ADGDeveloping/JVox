package com.regrowthStudios.JVox.audio.types;

import paulscode.sound.SoundSystemConfig;

import com.regrowthStudios.JVox.utils.SoundUtils.SoundFlags;

public class Stream3D extends Sound3D {
    /**
     * Standard implementation for 3D streamed sound.
     */
    @Override
    public void create() {
        boolean loop = SoundFlags.checkFor(this.flags, SoundFlags.LOOP);
        boolean priority = SoundFlags.checkFor(this.flags, SoundFlags.PRIORITY);

        this.soundSystem.newStreamingSource(priority, this.sourceName,
                this.fileLocation, loop, this.position.x, this.position.y,
                this.position.z, SoundSystemConfig.ATTENUATION_ROLLOFF,
                SoundSystemConfig.getDefaultRolloff());
    }
}