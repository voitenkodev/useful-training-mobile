import androidx.compose.ui.window.Application
import di.PlatformConfiguration
import di.PlatformSDK
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = Application("UsefulTraining") {
    PlatformSDK.init(PlatformConfiguration())
    Main { }
}
