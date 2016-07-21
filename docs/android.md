# Android

## Configure

The idiomatic method of doing a
native android splash screen is to use a `SplashActivity` and configure it
to immediately launch your `MainActivity`.

Your `SplashActivity` should be treated as your launch activity and receive
all intents that the `MainActivity` would otherwise (an integration with
`branch.io` for instance).

1. Add a `splash` drawable to your project. I recommend using 9-png _and_ adding a size for each screen density.

http://stackoverflow.com/a/34726279

2. Adjust your `AppTheme` and add a `windowBackground` of the recently added drawable.

```xml
<style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
    <item name="android:windowBackground">@drawable/splash</item>
</style>
```

3. Show this (from rn-splash-screen) splash screen and hide
   the native splash screen (from your modified theme) in `onCreate`.

```java
import com.mehcode.reactnative.splashscreen.SplashScreen;
// [...]

public class MainActivity extends ReactActivity {
  // [...]

  @Override
  protected void onCreate(Bundle savedInstanceState) {
      // Show the js-controlled splash screen
      SplashScreen.show(this);

      // After react is initialized; set our background color (override splash screen theme)
      getReactNativeHost().getReactInstanceManager().addReactInstanceEventListener(new ReactInstanceManager.ReactInstanceEventListener() {
          @Override
          public void onReactContextInitialized(ReactContext context) {
              // Hide the native splash screen
              getWindow().getDecorView().setBackgroundColor(Color.WHITE);
          }
      });

      super.onCreate(savedInstanceState);

      // [...]
  }

  // [...]
}
```
