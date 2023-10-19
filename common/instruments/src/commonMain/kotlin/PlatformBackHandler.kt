import androidx.compose.runtime.Composable

@Composable
public expect fun PlatformBackHandler(action: () -> Unit)