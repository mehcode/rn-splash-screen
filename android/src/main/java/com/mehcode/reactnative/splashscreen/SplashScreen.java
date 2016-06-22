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
    Dialog mSplashDialog;

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
        if (mSplashDialog != null && mSplashDialog.isShowing()) {
            // Splash screen is open
            return;
        }

        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mSplashDialog == null) {
                    mSplashDialog = new Dialog(mActivity, R.style.SplashTheme);
                    mSplashDialog.setCancelable(false);
                }

                if (!mActivity.isFinishing()) {
                    mSplashDialog.show();
                }
            }
        });
    }

    /**
     * Close the active splash screen.
     */
    @ReactMethod
    public void hide() {
        if (mSplashDialog == null || !mSplashDialog.isShowing()) {
            // Not showing splash screen
            return;
        }

        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mSplashDialog.dismiss();
            }
        });
    }
}
