package components.buttons

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import controls.ButtonSecondary
import controls.TextFieldBody1
import utils.recomposeHighlighter

@Composable
fun ButtonQuestion(
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