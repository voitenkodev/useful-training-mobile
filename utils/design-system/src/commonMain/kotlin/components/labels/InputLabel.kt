package components.labels

import Design
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import controls.TextFieldBody1
import utils.recomposeHighlighter

@Composable
fun InputLabel(
    modifier: Modifier = Modifier,
    provideText: () -> String
) = TextFieldBody1(
    modifier = modifier
        .width(64.dp)
        .recomposeHighlighter(),
    provideText = provideText,
    color = Design.colors.caption,
    maxLines = 1,
    overflow = TextOverflow.Ellipsis
)