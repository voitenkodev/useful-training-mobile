package components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import atom.Design
import molecular.molecule.ButtonTextLink
import molecular.molecule.TextBody1

@Composable
public fun ButtonQuestion(
    modifier: Modifier = Modifier,
    question: String,
    answer: String,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextBody1(
            provideText = { question },
            color = Design.colors.caption
        )

        ButtonTextLink(
            text = answer,
            onClick = onClick
        )
    }
}