import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Application
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = Application("UsefulTraining") {
    Main(modifier = Modifier.padding(top = 44.dp, bottom = 30.dp))
}
