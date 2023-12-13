import shared
import SwiftUI

@main
struct IosApp: App {
    @UIApplicationDelegateAdaptor var delegate: AppDelegate
    @Environment(\.scenePhase)  var scenePhase: ScenePhase
    
    init() {
      DiKt.doInitCommonKoin { Koin_coreKoinApplication in }
    }
    
    var defaultRouterContext: RouterContext { delegate.holder.defaultRouterContext }
    
    var body: some Scene {
        WindowGroup {
            ContentView(routerContext: defaultRouterContext)
                .ignoresSafeArea(.all)
        }
        .onChange(of: scenePhase) { newPhase in
            switch newPhase {
            case .background: defaultRouterContext.stop()
            case .inactive: defaultRouterContext.pause()
            case .active: defaultRouterContext.resume()
            @unknown default: break
            }
        }
    }
}

class DefaultRouterHolder : ObservableObject {
  let defaultRouterContext: RouterContext = DefaultRouterContextKt.defaultRouterContext()

  deinit {
    // Destroy the root component before it is deallocated
    defaultRouterContext.destroy()
  }
}

class AppDelegate: NSObject, UIApplicationDelegate {
    let holder: DefaultRouterHolder = DefaultRouterHolder()
}


struct ContentView: UIViewControllerRepresentable {
  let routerContext: RouterContext

  func makeUIViewController(context: Context) -> UIViewController {
    return Main_iosKt.MainUIController(routerContext: routerContext)
  }

  func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
