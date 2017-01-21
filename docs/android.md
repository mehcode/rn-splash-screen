# Android

## Configure

1. Add a `splash` drawable to your project. I recommend using 9-png _and_ adding a size for each screen density.

    http://stackoverflow.com/a/34726279

2. In `android/app/src/main/res/values/styles.xml`: Adjust your `AppTheme` and add a `windowBackground` of the recently added drawable.

    ```xml
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        <item name="android:windowBackground">@drawable/splash</item>
    </style>
    ```

3. Move your `AppTheme` from your Application to your Activity ( see https://github.com/mehcode/rn-splash-screen/commit/3cdbb187c38ef8dcc129baef804aed70e2bce0e1 )

4. In `android/app/src/main/java/com/__APPNAMES__/MainActivity.java`: Show this (from rn-splash-screen) splash screen and hide
   the native splash screen (from your modified theme) in `onCreate`.

    ```java
    // [...]
    import android.graphics.Color;
    import android.os.Bundle;

    import com.facebook.react.ReactInstanceManager;
    import com.facebook.react.bridge.ReactContext;
    import com.mehcode.reactnative.splashscreen.SplashScreen;
    
    public class MainActivity extends ReactActivity {
      // [...]
    
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          // Show the js-controlled splash screen
          SplashScreen.show(this, getReactInstanceManager());
    
          super.onCreate(savedInstanceState);
    
          // [...]
      }
    
      // [...]
    }
    ```
