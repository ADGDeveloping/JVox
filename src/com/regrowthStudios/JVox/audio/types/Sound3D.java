package com.regrowthStudios.JVox.audio.types;

import java.io.File;
import java.net.MalformedURLException;

import paulscode.sound.SoundSystemConfig;

import com.regrowthStudios.JVox.math.Vector3;
import com.regrowthStudios.JVox.utils.SoundUtils.SoundFlags;

public class Sound3D extends Sound {
    /**
     * Standard implementation for 3D sound.
     */
    protected int flags = SoundFlags.NONE;
    protected Vector3 position = new Vector3();

    public void init(int flags, String sn, String fl, String fn, Vector3 p) {
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
                    loop, (float)this.position.x, (float)this.position.y, (float)this.position.z, SoundSystemConfig.ATTENUATION_ROLLOFF,
                    SoundSystemConfig.getDefaultRolloff());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}