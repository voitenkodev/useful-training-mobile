import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

public actual fun Modifier.platformInsets(): Modifier = this
    .platformTopInset()
    .platformBottomInset()

public actual fun Modifier.platformTopInset(): Modifier = this
    .padding(top = 50.dp)

public actual fun Modifier.platformBottomInset(): Modifier = this
    .padding(bottom = 30.dp)