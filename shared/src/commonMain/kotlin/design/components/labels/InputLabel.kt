package design.components.labels

import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import design.Design
import design.controls.TextFieldBody1

@Composable
internal fun InputLabel(
    modifier: Modifier = Modifier,
    text: String
) = TextFieldBody1(
    modifier = modifier.width(64.dp),
    text = text,
    color = Design.colors.caption,
    maxLines = 1,
    overflow = TextOverflow.Ellipsis
)