import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication

fun main() = singleWindowApplication(
    title = "UsefulTraining",
    state = WindowState(size = DpSize(400.dp, 800.dp))
) {
    Main()
}