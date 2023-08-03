import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun VideoPlayer(
    modifier: Modifier = Modifier,
    nativeLocalResource: NativeLocalResource,
    allowControls: Boolean = false
)