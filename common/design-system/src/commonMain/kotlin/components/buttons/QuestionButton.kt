package components.buttons

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import molecular.ButtonTextLink
import molecular.TextBody1
import recomposeHighlighter

@Composable
public fun ButtonQuestion(
    modifier: Modifier = Modifier,
    question: String,
    answer: String,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.recomposeHighlighter(),
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextBody1(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { question },
            color = Design.colors.caption
        )

        ButtonTextLink(
            modifier = Modifier.recomposeHighlighter(),
            text = answer,
            onClick = onClick
        )
    }
}