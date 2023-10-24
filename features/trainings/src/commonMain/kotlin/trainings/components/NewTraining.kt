package trainings.components

import Design
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import molecular.TextH3

@Composable
internal fun NewTraining(newTraining: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2f)
            .padding(Design.dp.paddingM)
            .border(
                width = 1.dp,
                shape = Design.shape.default,
                color = Design.colors.caption
            ).clickable(onClick = newTraining)
            .clip(shape = Design.shape.default),
        content = {

            TextH3(
                modifier = Modifier
                    .align(Alignment.Center),
                provideText = { "ADD WORKOUT" },
                color = Design.colors.content
            )
        }
    )
}