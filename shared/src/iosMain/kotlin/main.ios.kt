import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Application
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = Application("UsefulTraining") {
    Column {
        Box(modifier = Modifier.fillMaxWidth().height(44.dp).background(Color.Black))
        Main { }
        Box(modifier = Modifier.fillMaxWidth().height(44.dp).background(Color.Black))
    }
}
