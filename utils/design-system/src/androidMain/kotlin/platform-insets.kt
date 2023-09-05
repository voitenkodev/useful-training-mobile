import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier

internal actual fun Modifier.platformInsets(): Modifier = this
    .statusBarsPadding()
    .systemBarsPadding()