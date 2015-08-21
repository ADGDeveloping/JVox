package com.regrowthStudios.JVox.audio;

import java.util.HashMap;

import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.codecs.CodecJOgg;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryJavaSound;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

public class SoundManager {
    /**
     * This is the sound manager, used to manage sounds and soundpools from
     * external locations
     */
    private HashMap<String, SoundPool> poolMap = new HashMap<>();
    private SoundSystem soundSystem = null;

    public void init() {
        try {
            SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
            SoundSystemConfig.addLibrary(LibraryJavaSound.class);
            SoundSystemConfig.setCodec("wav", CodecWav.class);
            SoundSystemConfig.setCodec("ogg", CodecJOgg.class);
        } catch (SoundSystemException e) {
            e.printStackTrace();
        }

        this.soundSystem = new SoundSystem();
    }

    public SoundSystem getSoundSystem() {
        return this.soundSystem;
    }

    /* Map Functions */
    public boolean addSoundPool(String key, SoundPool value) {
        if (!this.poolMap.containsKey(key)) {
            this.poolMap.put(key, value);
            return true;
        }

        return false;
    }

    public SoundPool getSoundPool(String key) {
        if (this.poolMap.containsKey(key)) {
            return this.poolMap.get(key);
        }

        return null;
    }

    public void setSoundPool(String key, SoundPool value) {
        this.poolMap.put(key, value);
    }

    public void removeSoundPool(String key) {
        if (this.poolMap.containsKey(key)) {
            this.poolMap.remove(key);
        }
    }

    /* Pool Functions */
    public void destroy(String key, String key2) {
        this.getSoundPool(key).getSound(key2).destroy();
    }

    public void play(String key, String key2) {
        this.getSoundPool(key).getSound(key2).play();
    }

    public void stop(String key, String key2) {
        this.getSoundPool(key).getSound(key2).stop();
    }

    public void pause(String key, String key2) {
        this.getSoundPool(key).getSound(key2).pause();
    }

    public void rewind(String key, String key2) {
        this.getSoundPool(key).getSound(key2).rewind();
    }
}
