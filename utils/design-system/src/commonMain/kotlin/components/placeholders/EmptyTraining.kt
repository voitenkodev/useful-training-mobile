package components.placeholders

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import controls.TextFieldH3

@Composable
fun EmptyTraining(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Design.dp.paddingM)
    ) {

        TextFieldH3(
            modifier = Modifier,
            provideText = { "There is no Trainings" },
            color = Design.colors.caption.copy(alpha = 0.5f),
            textAlign = TextAlign.Center
        )
    }
}