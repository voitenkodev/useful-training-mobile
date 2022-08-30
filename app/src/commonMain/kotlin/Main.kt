import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import designsystem.DesignComponent
import designsystem.common.DesignTheme

@Composable
fun Main() {
    DesignTheme {
        Surface(color = DesignComponent.colors.primary) {
        }
    }
}