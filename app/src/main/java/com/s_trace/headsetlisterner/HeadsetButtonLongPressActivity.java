package com.s_trace.headsetlisterner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by s-trace on 27.01.18.
 * Dummy activity for wired headset long press hooking
 */

public class HeadsetButtonLongPressActivity extends Activity {
    private static final String TAG = HeadsetButtonLongPressActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: keyevent.KEY_PTT_PRESS");
        Intent intent = new Intent("keyevent.KEY_PTT_PRESS");
        sendBroadcast(intent);
        startActivity(new Intent().setClass(this, MainActivity.class));
        finish();
    }
}
