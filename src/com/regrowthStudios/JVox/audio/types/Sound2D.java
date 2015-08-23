package com.regrowthStudios.JVox.audio.types;

import java.io.File;
import java.net.MalformedURLException;

import paulscode.sound.SoundSystemConfig;

import com.regrowthStudios.JVox.math.Vector;
import com.regrowthStudios.JVox.utils.SoundUtils.SoundFlags;

public class Sound2D extends Sound {
    /**
     * Standard implementation for 2D sound.
     */
    protected int flags = SoundFlags.NONE;
    protected Vector position = new Vector();

    public void init(int flags, String sn, String fl, String fn, Vector p) {
        this.flags = flags;
        this.sourceName = sn;
        this.fileLocation = fl;
        this.fileName = fn;
        this.position = p;
    }

    @Override
    public void create() {
        boolean loop = SoundFlags.checkFor(this.flags, SoundFlags.LOOP);
        boolean priority = SoundFlags.checkFor(this.flags, SoundFlags.PRIORITY);

        try {
            this.soundSystem.newSource(priority, this.sourceName, new File(this.fileLocation).toURI().toURL(), this.fileName,
                    loop, (float)this.position.x, (float)this.position.y, 0, SoundSystemConfig.ATTENUATION_ROLLOFF,
                    SoundSystemConfig.getDefaultRolloff());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}