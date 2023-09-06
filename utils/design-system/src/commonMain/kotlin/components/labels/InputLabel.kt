package components.labels

import Design
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import controls.TextFieldLabel
import utils.recomposeHighlighter

@Composable
fun InputLabel(
    modifier: Modifier = Modifier,
    provideText: () -> String
) = TextFieldLabel(
    modifier = modifier
        .width(74.dp)
        .recomposeHighlighter(),
    provideText = provideText,
    color = Design.colors.caption,
    maxLines = 1,
    overflow = TextOverflow.Ellipsis
)