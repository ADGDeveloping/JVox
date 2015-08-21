package com.regrowthStudios.JVox.audio.types;

import com.regrowthStudios.JVox.utils.SoundUtils.SoundFlags;

public class SoundBG extends Sound {
    /**
     * Standard implementation for background sound.
     */
    private int flags = SoundFlags.NONE;

    public void init(int flags, String sn, String fl) {
        this.flags = flags;
        this.sourceName = sn;
        this.fileLocation = fl;
    }

    @Override
    public void create() {
        boolean loop = SoundFlags.checkFor(this.flags, SoundFlags.LOOP);

        this.soundSystem.backgroundMusic(this.sourceName, this.fileLocation,
                loop);
    }
}