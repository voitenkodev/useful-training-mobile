import androidx.compose.ui.window.Application
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = Application("UsefulTraining") {
//    firebaseInitialization()
//    initCommonKoin()
    Main { }
}
