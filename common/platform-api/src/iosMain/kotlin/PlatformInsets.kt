import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

public actual fun Modifier.platformInsets(): Modifier = this
    .platformTopInset()
    .platformBottomInset()

public actual fun Modifier.platformTopInset(): Modifier = this
    .statusBarsPadding()

public actual fun Modifier.platformBottomInset(): Modifier = this
    .navigationBarsPadding()