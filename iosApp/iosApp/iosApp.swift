import UIKit
import shared

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    var window: UIWindow?

    var rootRouterContext = Router_contextKt.defaultRouterContext()

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        DiKt.doInitCommonKoin { Koin_coreKoinApplication in
        
        }
        window = UIWindow(frame: UIScreen.main.bounds)
        let mainViewController = Main_iosKt.MainUIController(routerContext: rootRouterContext)
        window?.rootViewController = mainViewController
        window?.makeKeyAndVisible()
        return true
    }

    func applicationDidBecomeActive(_ application: UIApplication) {
        Router_contextKt.resume(rootRouterContext.lifecycle)
      }

      func applicationWillResignActive(_ application: UIApplication) {
        Router_contextKt.stop(rootRouterContext.lifecycle)
      }

      func applicationWillTerminate(_ application: UIApplication) {
        Router_contextKt.destroy(rootRouterContext.lifecycle)
      }
}
