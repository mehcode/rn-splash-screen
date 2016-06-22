// Simple proxy to the native module so JS code doesn't have to deal with
// the dirty module directly.
import {NativeModules} from "react-native";
export default NativeModules.SplashScreen;
