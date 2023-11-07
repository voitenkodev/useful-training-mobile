import androidx.compose.runtime.Composable

@Deprecated("Use decompose callback")
@Composable
public expect fun PlatformBackHandler(action: () -> Unit)