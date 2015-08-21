package com.regrowthStudios.JVox.audio.types;

import paulscode.sound.SoundSystemConfig;

import com.regrowthStudios.JVox.utils.SoundUtils.SoundFlags;

public class Stream2D extends Sound2D {
    /**
     * Standard implementation for 2D streamed sound.
     */
    @Override
    public void create() {
        boolean loop = SoundFlags.checkFor(this.flags, SoundFlags.LOOP);
        boolean priority = SoundFlags.checkFor(this.flags, SoundFlags.PRIORITY);

        this.soundSystem.newStreamingSource(priority, this.sourceName,
                this.fileLocation, loop, this.position.x, this.position.y, 0,
                SoundSystemConfig.ATTENUATION_ROLLOFF,
                SoundSystemConfig.getDefaultRolloff());
    }
}