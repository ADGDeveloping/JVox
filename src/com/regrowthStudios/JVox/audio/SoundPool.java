package com.regrowthStudios.JVox.audio;

import java.util.HashMap;

import com.regrowthStudios.JVox.audio.types.Sound;

public class SoundPool {
    /**
     * This is a pool of sounds, you store a group of same-type sounds inside
     * this class.
     */
    private HashMap<String, Sound> soundMap = new HashMap<>();

    /* Map Functions */
    public boolean addSound(String key, Sound value) {
        if (!this.soundMap.containsKey(key)) {
            this.soundMap.put(key, value);
            return true;
        }

        return false;
    }

    public Sound getSound(String key) {
        if (this.soundMap.containsKey(key)) {
            return this.soundMap.get(key);
        }

        return null;
    }

    public void setSound(String key, Sound value) {
        this.soundMap.put(key, value);
    }

    public void removeSound(String key) {
        if (this.soundMap.containsKey(key)) {
            this.soundMap.remove(key);
        }
    }

    /* Pool Functions */
    public void destroy(String key) {
        this.getSound(key).destroy();
    }

    public void play(String key) {
        this.getSound(key).play();
    }

    public void stop(String key) {
        this.getSound(key).stop();
    }

    public void pause(String key) {
        this.getSound(key).pause();
    }

    public void rewind(String key) {
        this.getSound(key).rewind();
    }
}
