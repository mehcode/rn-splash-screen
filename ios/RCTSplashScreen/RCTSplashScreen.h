#import <React/RCTBridgeModule.h>
#import <React/RCTRootView.h>

@interface RCTSplashScreen : NSObject <RCTBridgeModule>

+ (NSString *)splashImageNameForOrientation;
+ (void)show:(RCTRootView *)v;

@end
