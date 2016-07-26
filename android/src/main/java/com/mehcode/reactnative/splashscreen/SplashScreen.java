package com.mehcode.reactnative.splashscreen;

import android.app.Activity;
import android.app.Dialog;

import java.lang.ref.WeakReference;

public class SplashScreen {
    private static Dialog mSplashDialog;
    private static WeakReference<Activity> mActivity;

    /**
     * Show the splash screen.
     */
    public static void show(final Activity activity) {
        if (activity == null) return;

        // Store weak-reference to showing activity (in case we try to hide too early)
        // NOTE: For instance in direct execution of index.android.js
        mActivity = new WeakReference<Activity>(activity);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!activity.isFinishing()) {
                    mSplashDialog = new Dialog(activity, R.style.RNSplashScreen_SplashTheme);
                    mSplashDialog.setCancelable(false);
                    
                    if (!mSplashDialog.isShowing()) {
                        mSplashDialog.show();
                    }
                }
            }
        });
    }

    /**
     * Close the active splash screen.
     */
    public static void hide(Activity activity) {
        if (activity == null) activity = mActivity.get();
        if (activity == null) return;

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mSplashDialog != null && mSplashDialog.isShowing()) {
                    mSplashDialog.dismiss();
                }
            }
        });
    }
}
