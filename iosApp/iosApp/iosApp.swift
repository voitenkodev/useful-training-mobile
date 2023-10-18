import UIKit
import shared

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    var window: UIWindow?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        DiKt.doInitCommonKoin { Koin_coreKoinApplication in
            
        }
        window = UIWindow(frame: UIScreen.main.bounds)
        let mainViewController = Main_iosKt.main()
        window?.rootViewController = mainViewController
        window?.makeKeyAndVisible()
        return true
    }
}
