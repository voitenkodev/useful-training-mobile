package components.placeholders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import atom.Design
import molecule.TextH3

@Composable
public fun EmptyTraining(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM, Alignment.CenterVertically)
    ) {

        TextH3(
            provideText = { "There is no Trainings" },
            color = Design.colors.caption.copy(alpha = 0.5f),
            textAlign = TextAlign.Center
        )
    }
}