package components.labels

import Design
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import controls.TextFieldLabel
import recomposeHighlighter

@Composable
public fun InputLabel(
    modifier: Modifier = Modifier,
    provideText: () -> String
) {
    TextFieldLabel(
        modifier = modifier
            .width(72.dp)
            .recomposeHighlighter(),
        provideText = provideText,
        color = Design.colors.primary,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}