import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Application
import di.PlatformConfiguration
import di.PlatformSDK
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = Application("UsefulTraining") {
    PlatformSDK.init(PlatformConfiguration())

    Spacer(Modifier.fillMaxSize().background(Color.Cyan))
}
