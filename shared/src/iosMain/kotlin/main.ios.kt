import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController {
    Main(modifier = Modifier)
}

internal actual fun Modifier.platformInsets(): Modifier = this
    .padding(top = 44.dp, bottom = 30.dp)