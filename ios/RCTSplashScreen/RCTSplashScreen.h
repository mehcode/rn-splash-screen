#import "RCTBridgeModule.h"
#import "RCTRootView.h"

@interface RCTSplashScreen : NSObject <RCTBridgeModule>

+ (void)show:(RCTRootView *)v;

@end
