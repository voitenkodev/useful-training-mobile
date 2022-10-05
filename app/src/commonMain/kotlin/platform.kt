import androidx.compose.runtime.Composable

@Composable
expect fun BackHandler(
    action: () -> Unit,
    content: @Composable () -> Unit
)