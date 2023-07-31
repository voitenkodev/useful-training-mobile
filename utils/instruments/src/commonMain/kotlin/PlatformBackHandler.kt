import androidx.compose.runtime.Composable

@Composable
expect fun PlatformBackHandler(action: () -> Unit)