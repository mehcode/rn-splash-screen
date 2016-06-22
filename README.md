# React Native Splash Screen
> A JavaScript-controlled splash-screen designed to be run directly after the native splash-screen.

## Install
```sh
npm install --save rn-splash-screen
```

## Configure

#### iOS

* Drag RCTSplashScreen.xcodeproj to your project on Xcode.
* Click on your main project file (the one that represents the .xcodeproj) select Build Phases and drag libRCTSplashScreen.a from the Products folder inside the RCTSplashScreen.xcodeproj.
* Look for Header Search Paths and make sure it contains $(SRCROOT)/../../../react-native/React as recursive.

* In your project, Look for Header Search Paths and make sure it contains $(SRCROOT)/../node_modules/rn-splash-screen/ios/RCTSplashScreen

* delete your project's LaunchScreen.xib
* Dray SplashScreenResource to your project [if you want change image, replace splash.png]

* In AppDelegate.m
```objc
...
#import "RCTSplashScreen.h" //<--- import
...
RCTRootView *rootView = [[RCTRootView alloc] initWithBundleURL:jsCodeLocation
                                                      moduleName:@"KitchenSink"
                                               initialProperties:nil
                                                   launchOptions:launchOptions];
  [RCTSplashScreen show:rootView]; //<--- add show SplashScreen

  self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];
  UIViewController *rootViewController = [[UIViewController alloc] init];
  rootViewController.view = rootView;
  self.window.rootViewController = rootViewController;
  [self.window makeKeyAndVisible];
  return YES;
```


#### Android
```gradle
...
include ':react-native-splashscreen'
project(':react-native-splashscreen').projectDir = new File(rootProject.projectDir, '../node_modules/rn-splash-screen/android')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':react-native-splashscreen')
}
```
* if you want change image, replace res/drawable/splash.png

* register module (in MainActivity.java)

```java
import com.mehcode.reactnative.splashscreen.SplashScreen; // <--------

public class MainActivity /*...*/ {
  /*...*/

  protected List<ReactPackage> getPackages() {
    return Arrays.<ReactPackage>asList(
      new SplashScreenPackage(),                                 // <--------
      new MainReactPackage(),
    );
  }

  /*...*/
}
```

## Usage

### Hide
The splash screen must be hidden from JavaScript. This can be done as early
as late as possible so as to give your application more time to "load".

```js
import SplashScreen from "rn-splash-screen";

// Hide the active splash screen
SplashScreen.hide();
```

## Credits

 - [@remobile](https://github.com/remobile)
