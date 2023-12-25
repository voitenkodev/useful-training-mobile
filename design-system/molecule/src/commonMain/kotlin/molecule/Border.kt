package molecule

import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design

@Composable
public fun Modifier.borderSmall(): Modifier {
    return border(
        color = Design.colors.white5,
        width = 1.dp,
        shape = Design.shape.small
    )
}