import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier

actual fun Modifier.platformInsets(): Modifier = this
    .systemBarsPadding()

actual fun Modifier.platformTopInset(): Modifier = this
    .statusBarsPadding()

actual fun Modifier.platformBottomInset(): Modifier = this
    .navigationBarsPadding()