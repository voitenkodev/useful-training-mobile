import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun BackHandler(action: () -> Unit)

@Composable
expect fun RemoteImage(imageUrl: String, modifier: Modifier, contentDescription: String?)