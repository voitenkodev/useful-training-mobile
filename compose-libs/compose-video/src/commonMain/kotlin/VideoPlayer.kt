import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
public expect fun VideoPlayer(
    modifier: Modifier = Modifier,
    url: String
)