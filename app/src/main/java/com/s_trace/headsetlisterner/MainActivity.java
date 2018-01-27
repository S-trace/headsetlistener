package com.s_trace.headsetlisterner;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ComponentName mediaButtonReceiver;
        mediaButtonReceiver = new ComponentName(getPackageName(), MediaButtonReceiver.class.getName());
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (audioManager == null) {
            Log.e(TAG, "audioManager is null!");
        } else {
            audioManager.registerMediaButtonEventReceiver(mediaButtonReceiver);
        }
    }

}
