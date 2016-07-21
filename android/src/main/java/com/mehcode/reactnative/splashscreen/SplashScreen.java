package com.mehcode.reactnative.splashscreen;

import android.app.Activity;
import android.app.Dialog;

public class SplashScreen {
    private static Dialog mSplashDialog;

    /**
     * Show the splash screen.
     */
    public static void show(final Activity activity) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!activity.isFinishing()) {
                    if (mSplashDialog == null) {
                        mSplashDialog = new Dialog(activity, R.style.RNSplashScreen_SplashTheme);
                        mSplashDialog.setCancelable(false);
                    }

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
    public static void hide(final Activity activity) {
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
