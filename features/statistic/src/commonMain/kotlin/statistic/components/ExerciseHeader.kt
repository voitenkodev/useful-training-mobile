package statistic.components

import Design
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import controls.TextFieldBody2
import controls.TextFieldH4


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

    TextFieldH4(
        modifier = Modifier
            .padding(end = 4.dp),
        provideText = { weekDay },
    )

    TextFieldBody2(
        modifier = Modifier,
        provideText = { date },
        color = Design.colors.caption,
        fontWeight = FontWeight.Bold
    )
}