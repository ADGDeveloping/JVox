package com.regrowthStudios.JVox.audio.types;

import java.io.File;
import java.net.MalformedURLException;

import paulscode.sound.SoundSystemConfig;

import com.regrowthStudios.JVox.math.vector.Vector;
import com.regrowthStudios.JVox.utils.SoundUtils.SoundFlags;

public class Stream3D extends Sound3D {
    /**
     * Standard implementation for 3D streamed sound.
     */
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
            this.soundSystem.newStreamingSource(priority, this.sourceName, new File(this.fileLocation).toURI().toURL(), this.fileName,
                    loop, this.position.x, this.position.y, this.position.z, SoundSystemConfig.ATTENUATION_ROLLOFF,
                    SoundSystemConfig.getDefaultRolloff());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}