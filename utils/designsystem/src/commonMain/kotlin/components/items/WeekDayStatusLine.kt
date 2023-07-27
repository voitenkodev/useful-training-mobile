package components.items

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import controls.TextFieldBody2
import utils.recomposeHighlighter

@Composable
fun WeekDayStatusLine(
    modifier: Modifier = Modifier,
    listOfWeekDaysEnglish: List<String>,
    availableList: List<String>
) = Column(
    modifier = modifier.recomposeHighlighter(),
    verticalArrangement = Arrangement.SpaceAround
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listOfWeekDaysEnglish.forEach {

            val weekShort by rememberUpdatedState(toShortWeek(it))

            TextFieldBody2(
                modifier = Modifier.recomposeHighlighter(),
                provideText = { weekShort }
            )
        }
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listOfWeekDaysEnglish.forEach {
            Spacer(
                modifier = Modifier
                    .size(14.dp)
                    .background(
                        color = if (availableList.contains(it)) Design.colors.accent_secondary else Design.colors.caption,
                        shape = CircleShape
                    ).recomposeHighlighter()
            )
        }
    }
}

@Composable
fun WeekInfoFooter(
    modifier: Modifier = Modifier,
    intensity: Double?,
    tonnage: Double?,
) {
    val tonnageKg = remember(tonnage) { "${tonnage}kg" }
    val intensityPercents = remember(intensity) { "${intensity}%" }

    Row(
        modifier = modifier.recomposeHighlighter(),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        TextFieldBody2(
            modifier = Modifier
                .padding(end = 4.dp)
                .recomposeHighlighter(),
            provideText = { "Intensity:" },
            color = Design.colors.caption,
        )

        TextFieldBody2(
            modifier = Modifier.recomposeHighlighter(),
            provideText = { intensityPercents },
            color = Design.colors.content,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
                .recomposeHighlighter()
        )

        TextFieldBody2(
            modifier = Modifier
                .padding(end = 4.dp)
                .recomposeHighlighter(),
            provideText = { "Tonnage:" },
            color = Design.colors.caption,
        )

        TextFieldBody2(
            modifier = Modifier
                .recomposeHighlighter(),
            provideText = { tonnageKg },
            color = Design.colors.content,
            fontWeight = FontWeight.Bold
        )
    }
}

private fun toShortWeek(weekDayEnglish: String) = when (weekDayEnglish.uppercase()) {
    "MONDAY" -> "Mon"
    "TUESDAY" -> "Tue"
    "WEDNESDAY" -> "Wed"
    "THURSDAY" -> "Thu"
    "FRIDAY" -> "Fri"
    "SATURDAY" -> "Sat"
    "SUNDAY" -> "Sun"
    else -> ""
}