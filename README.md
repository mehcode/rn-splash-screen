# React Native Splash Screen
[![npm](https://img.shields.io/npm/v/rn-splash-screen.svg?maxAge=2592000)](https://www.npmjs.com/package/rn-splash-screen)
[![npm](https://img.shields.io/npm/dm/rn-splash-screen.svg?maxAge=2592000)](https://www.npmjs.com/package/rn-splash-screen)
[![npm](https://img.shields.io/npm/dt/rn-splash-screen.svg?maxAge=2592000?style=flat)](https://www.npmjs.com/package/rn-splash-screen)
[![npm](https://img.shields.io/npm/l/rn-splash-screen.svg?maxAge=2592000)](https://github.com/mehcode/rn-splash-screen/blob/master/LICENSE)
> A JavaScript-controlled splash-screen designed to be run directly after the native splash-screen.

## Install

1. `npm install --save rn-splash-screen`

2. `react-native link rn-splash-screen`

## Configure

 - [Android](./docs/android.md)
 - [iOS](./docs/ios.md)

## Usage

The splash screen must be hidden from JavaScript. This can be done
as late as possible so as to give your application more time to "load".

```js
import SplashScreen from "rn-splash-screen";

// Hide the active splash screen
SplashScreen.hide();
```

## Credits
 - [@remobile](https://github.com/remobile)
