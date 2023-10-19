import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier

public actual fun Modifier.platformInsets(): Modifier = this
    .systemBarsPadding()

public actual fun Modifier.platformTopInset(): Modifier = this
    .statusBarsPadding()

public actual fun Modifier.platformBottomInset(): Modifier = this
    .navigationBarsPadding()