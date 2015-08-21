package com.regrowthStudios.JVox.audio.types;

import java.io.File;
import java.net.MalformedURLException;

import com.regrowthStudios.JVox.utils.SoundUtils.SoundFlags;

public class SoundBG extends Sound {
    /**
     * Standard implementation for background sound.
     */
    private int flags = SoundFlags.NONE;

    public void init(int flags, String sn, String fl, String fn) {
        this.flags = flags;
        this.sourceName = sn;
        this.fileLocation = fl;
        this.fileName = fn;
    }

    @Override
    public void create() {
        boolean loop = SoundFlags.checkFor(this.flags, SoundFlags.LOOP);

        try {
            this.soundSystem.backgroundMusic(this.sourceName, new File(this.fileLocation).toURI().toURL(), this.fileName, loop);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}