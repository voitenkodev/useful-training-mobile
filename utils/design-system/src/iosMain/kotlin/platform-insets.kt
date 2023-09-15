import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

actual fun Modifier.platformInsets(): Modifier = this
    .platformTopInset()
    .platformBottomInset()

actual fun Modifier.platformTopInset(): Modifier = this
    .padding(top = 44.dp)

actual fun Modifier.platformBottomInset(): Modifier = this
    .padding(bottom = 30.dp)