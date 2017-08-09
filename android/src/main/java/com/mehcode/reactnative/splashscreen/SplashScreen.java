package com.mehcode.reactnative.splashscreen;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.TypedArray;
import android.graphics.Color;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;

import java.lang.ref.WeakReference;

public class SplashScreen {
    private static Dialog mSplashDialog;
    private static WeakReference<ReactActivity> mActivity;

    /**
     * Show the splash screen.
     */
    public static void show(final ReactActivity activity, final ReactInstanceManager instanceManager) {
        if (activity == null) return;

        // Store weak-reference to showing activity (in case we try to hide too early)
        // NOTE: For instance in direct execution of index.android.js
        mActivity = new WeakReference<ReactActivity>(activity);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!activity.isFinishing()) {
                    mSplashDialog = new Dialog(activity, R.style.RNSplashScreen_SplashTheme);
                    mSplashDialog.setCancelable(false);

                    if (!mSplashDialog.isShowing()) {
                        mSplashDialog.show();
                    }

                    // Use color of "splashBackgroundColor" attribute in user theme, fallback to white if not set
                    TypedArray styledAttributes = activity.getTheme().obtainStyledAttributes(R.styleable.RNSplashScreen_Styleable);
                    final int backgroundColor = styledAttributes.getColor(R.styleable.RNSplashScreen_Styleable_splashBackgroundColor, Color.WHITE);

                    // If given an instance manager; ensure that we transition to the stage-2
                    // splash screen
                    // TODO: If you think of a better way to do this; PR please
                    if (instanceManager != null) {
                        // A non-null context means that we are resuming from a
                        // background state and we will not get the context created event
                        ReactContext ctx = instanceManager.getCurrentReactContext();
                        if (ctx != null) {
                            activity.getWindow().getDecorView().setBackgroundColor(backgroundColor);
                        } else {
                            // Else; wait until react is initialized before we release the native splash
                            instanceManager.addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
                                @Override
                                public void onReactContextInitialized(ReactContext context) {
                                    // Hide the native splash screen
                                    activity.getWindow().getDecorView().setBackgroundColor(backgroundColor);
                                }
                            });
                        }
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
