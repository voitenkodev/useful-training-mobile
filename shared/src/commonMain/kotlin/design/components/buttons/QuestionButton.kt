package design.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import design.Design
import design.controls.ButtonSecondary
import design.controls.TextFieldBody1
import utils.recomposeHighlighter

@Composable
internal fun ButtonQuestion(
    modifier: Modifier = Modifier,
    question: String,
    answer: String,
    onClick: () -> Unit
) = Row(
    modifier = modifier.recomposeHighlighter(),
    horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
    verticalAlignment = Alignment.CenterVertically
) {

    TextFieldBody1(
        modifier = Modifier.recomposeHighlighter(),
        provideText = { question },
        color = Design.colors.caption
    )

    ButtonSecondary(
        modifier = Modifier.recomposeHighlighter(),
        text = answer,
        onClick = onClick
    )
}