import androidx.compose.ui.Modifier
import org.koin.core.module.Module

internal expect val platformModule: Module

internal expect fun Modifier.platformInsets(): Modifier