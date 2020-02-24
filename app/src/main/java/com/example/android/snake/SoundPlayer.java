package com.example.android.snake;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundPlayer {

    // U01A1:  variables for SoundPool
    private SoundPool soundPool;            //var for soundPool
    private int sound1, sound2, sound3;     //var for sound files, are int because ids are ints

    public SoundPlayer(Context context) {

        //SoundPool (int maxStreams, int streamType, int srcQuality)
        soundPool = new SoundPool (3, AudioManager.STREAM_MUSIC, 0);

        //loading the sounds; priority set to 1
        sound1 = soundPool.load(context, R.raw.sound1, 1);
        sound2 = soundPool.load(context, R.raw.sound2, 1);
        sound3 = soundPool.load(context, R.raw.sound3, 1);

    }

    //method to play sound1
    public void playMoveSound() {
        // play(int soundID, float leftVolume, float rightVolume, int priority, int loop, float rate)
        soundPool.play(sound1, 1,1,0,0,1);
    }

    //method to play sound2
    public void playEatSound() {
        soundPool.play(sound2, 1,1,0,0,1);
    }

    //method to play sound3
    public void playHitsound() {
        soundPool.play(sound3, 1,1,0,0,1);
    }


}
