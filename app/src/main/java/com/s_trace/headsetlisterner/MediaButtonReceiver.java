package com.s_trace.headsetlisterner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

/**
 * Created by s-trace on 25.01.18.
 * Test class
 */

public class MediaButtonReceiver extends BroadcastReceiver {

    private static final String TAG = MediaButtonReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        Log.d(TAG, "action=" + intentAction);
        if (!Intent.ACTION_MEDIA_BUTTON.equals(intentAction)) {
            Log.d(TAG, "Wrong intentAction == " + intentAction);
            return;
        }
        KeyEvent event = intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
        if (event == null) {
            Log.d(TAG, "event == null");
            return;
        }
        Log.d(TAG, "event=" + event);
        int action = event.getAction();
        Log.d(TAG, "action=" + action);
        if (action == KeyEvent.ACTION_DOWN) {
            // do something
            Toast.makeText(context, "BUTTON PRESSED!", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "BUTTON PRESSED");
        } else if (action == KeyEvent.ACTION_UP) {
            // do something
            Toast.makeText(context, "BUTTON RELEASED!", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "BUTTON RELEASED");
        } else {
            Toast.makeText(context, "unknown action=" + action, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "unknown intentAction=" + intentAction + " action=" + action);
        }
//        abortBroadcast();
    }
}
