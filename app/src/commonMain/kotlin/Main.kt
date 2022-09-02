import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import ui.designsystem.DesignComponent
import ui.designsystem.common.DesignTheme

@Composable
fun Main() {
    DesignTheme {
        Surface(color = DesignComponent.colors.primary) {
//            AuthScreen()
        }
    }
}