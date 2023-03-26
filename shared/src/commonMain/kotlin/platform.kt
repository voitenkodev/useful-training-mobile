import androidx.compose.runtime.Composable
import org.koin.core.module.Module

internal expect val platformModule: Module

@Composable
internal expect fun BackHandler(action: () -> Unit)