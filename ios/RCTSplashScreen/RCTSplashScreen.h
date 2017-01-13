#import <React/RCTBridgeModule.h>
#import <React/RCTRootView.h>

@interface RCTSplashScreen : NSObject <RCTBridgeModule>

+ (void)show:(RCTRootView *)v;

@end
