import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {

    return ComposeUIViewController {
        Main(
            modifier = Modifier,
        )
    }
}