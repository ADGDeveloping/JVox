package com.regrowthStudios.JVox.audio.types;

import paulscode.sound.SoundSystem;

public class Sound {
    /**
     * Base class for all sound extensions.
     */
    protected SoundSystem soundSystem = null;
    protected String sourceName, fileLocation, fileName;

    public void setSoundSystem(SoundSystem ss) {
        this.soundSystem = ss;
    }

    public SoundSystem getSoundSystem() {
        return this.soundSystem;
    }

    public void create() {
        /* Nothing to see in here */
    }

    public void destroy() {
        this.soundSystem.removeSource(this.sourceName);
    }

    public void play() {
        this.soundSystem.play(this.sourceName);
    }

    public void stop() {
        this.soundSystem.stop(this.sourceName);
    }

    public void pause() {
        this.soundSystem.pause(this.sourceName);
    }

    public void rewind() {
        this.soundSystem.rewind(this.sourceName);
    }
}
