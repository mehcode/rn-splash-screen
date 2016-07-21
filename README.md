# React Native Splash Screen
> A JavaScript-controlled splash-screen designed to be run directly after the native splash-screen.

## Install

1. `npm install --save rn-splash-screen`

2. `react-native link rn-splash-screen`

## Configure

 - [Android](./docs/android.md)
 - iOS (documentation coming soon)

## Usage

### Hide
The splash screen must be hidden from JavaScript. This can be done
as late as possible so as to give your application more time to "load".

```js
import SplashScreen from "rn-splash-screen";

// Hide the active splash screen
SplashScreen.hide();
```

## Credits
 - [@remobile](https://github.com/remobile)
