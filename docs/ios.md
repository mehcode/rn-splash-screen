# iOS

## Configure

1. Remove `LaunchScreen.xib` (auto-generated file from react-native init)

2. Add a `LaunchImage` to `Images.xcassets` – Open `Images.xcassets` in Xcode, right-click under the already-defined AppIcon and choose `App Icons & Launch Images > New iOS Launch Image`

3. Show this (from rn-splash-screen) splash screen directly after creation of the `rootView` in `didFinishLaunchingWithOptions`:

  ```objectivec
  // [...]
  #import "RCTSplashScreen.h"
  
  - (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
 {
    // [...]
   
    RCTRootView *rootView = // [...]
    
    // Show splash screen (rn-splash-screen)
    [RCTSplashScreen show:rootView];
  
    // [...]
 }
  ```
