package com.mehcode.reactnative.splashscreen;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

class SplashScreen extends ReactContextBaseJavaModule {
    Activity mActivity;

    public SplashScreen(ReactApplicationContext reactContext, Activity activity) {
        super(reactContext);
        mActivity = activity;

        // Immediately show the splash screen (again) when we get here
        show();
    }

    @Override
    public String getName() {
        return "SplashScreen";
    }

    void show() {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!mActivity.isFinishing()) {
                    Intent intent = new Intent(mActivity, SplashActivity.class);
                    mActivity.startActivity(intent);
                }
            }
        });
    }

    /**
     * Close the active splash screen.
     */
    @ReactMethod
    public void hide() {
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent("splash-screen:hide");
                LocalBroadcastManager.getInstance(mActivity).sendBroadcast(intent);
            }
        });
    }
}
