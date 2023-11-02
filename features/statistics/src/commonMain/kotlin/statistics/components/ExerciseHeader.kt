package statistics.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import atom.Design
import molecule.TextBody2
import molecule.TextH4


@Composable
internal fun ExerciseHeader(
    modifier: Modifier = Modifier,
    weekDay: String,
    date: String,
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(Design.dp.paddingS),
    verticalAlignment = Alignment.CenterVertically,
) {

    TextH4(
        modifier = Modifier
            .padding(end = 4.dp),
        provideText = { weekDay },
    )

    TextBody2(
        modifier = Modifier,
        provideText = { date },
        color = Design.colors.caption,
        fontWeight = FontWeight.Bold
    )
}