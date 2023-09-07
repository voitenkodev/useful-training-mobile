import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier

actual fun Modifier.platformInsets(): Modifier = this
    .statusBarsPadding()
    .systemBarsPadding()