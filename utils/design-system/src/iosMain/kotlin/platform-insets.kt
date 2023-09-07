import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

actual fun Modifier.platformInsets(): Modifier = this
    .padding(top = 44.dp, bottom = 30.dp)