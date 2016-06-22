package com.mehcode.reactnative.splashscreen;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

public class SplashActivity extends Activity {
    BroadcastReceiver onHide = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    };

    @Override
    public void onBackPressed() {
        // Prevent the user from closing the splash early
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Register an event handler to close this splash screen
        LocalBroadcastManager.getInstance(this).registerReceiver(
                onHide, new IntentFilter("splash-screen:hide"));
    }

    protected void onPause() {
        super.onPause();

        // Unregister event handler
        LocalBroadcastManager.getInstance(this).unregisterReceiver(onHide);
    }
}
