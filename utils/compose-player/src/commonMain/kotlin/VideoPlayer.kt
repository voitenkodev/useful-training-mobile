import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.icerock.moko.resources.FileResource

@Composable
expect fun VideoPlayer(
    modifier: Modifier = Modifier,
    fileResource: FileResource,
    allowControls: Boolean = false
)