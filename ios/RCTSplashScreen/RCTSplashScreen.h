#import "RCTBridgeModule.h"
#import "RCTRootView.h"

@interface RCTSplashScreen : NSObject <RCTBridgeModule>

+ (NSString *)splashImageNameForOrientation;
+ (void)show:(RCTRootView *)v;

@end
