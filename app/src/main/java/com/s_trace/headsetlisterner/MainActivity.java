package com.s_trace.headsetlisterner;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyDown: Got keycode=" + keyCode + ", event=" + event);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyUp: Got keycode=" + keyCode + ", event=" + event);
        if ((event.getFlags() & KeyEvent.FLAG_CANCELED) != 0) {
            Log.d(TAG, "onKeyUp: ignoring canceled KeyEvent");
            return super.onKeyUp(keyCode, event);
        }
        switch (keyCode) {
            case KeyEvent.KEYCODE_HEADSETHOOK:
                Log.d(TAG, "onKeyUp: keyevent.KEY_PTT_RELEASE");
                Intent intent = new Intent("keyevent.KEY_PTT_RELEASE");
                sendBroadcast(intent);
                return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyLongPress: Got keycode=" + keyCode + ", event=" + event);
        return super.onKeyLongPress(keyCode, event);
    }
}
