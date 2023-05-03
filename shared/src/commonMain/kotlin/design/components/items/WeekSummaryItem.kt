package design.components.items

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import design.Design
import design.chart.LineChart
import design.chart.PointLine
import design.controls.TextFieldBody2
import presentation.trainings.WeekInfo

@Composable
internal fun WeekSummary(
    modifier: Modifier = Modifier,
    info: WeekInfo
) = Box(
    modifier = modifier
        .requiredHeight(114.dp)
        .background(color = Design.colors.secondary, shape = Design.shape.default)
        .border(0.5.dp, Design.colors.accent_secondary, shape = Design.shape.default)
        .fillMaxWidth()
) {

    LineChart(
        modifier = Modifier.fillMaxSize().alpha(0.15f).padding(bottom = 10.dp),
        lines = listOf(
            PointLine(
                yValue = listOf(1f, 3f, 5f, 4f, 6f, 8f, 7f, 12f, 13f),
                lineColor = Design.colors.accent_secondary,
                fillColor = Design.colors.accent_secondary.copy(alpha = 0.15f)
            )
        )
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(Design.dp.padding),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Column(
                modifier = Modifier.height(44.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {

                TextFieldBody2(
                    provideText = { info.startWeekDate + " →" },
                    fontWeight = FontWeight.Bold,
                )

                TextFieldBody2(
                    modifier = modifier.padding(start = Design.dp.padding),
                    provideText = { "← " + info.endWeekDate },
                    fontWeight = FontWeight.Bold,
                )
            }

            WeekDayStatusLine(
                modifier = Modifier.width(180.dp).height(44.dp),
                listOfWeekDaysEnglish = listOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"),
                availableList = info.trainingWeekDays
            )
        }

        WeekInfoFooter(
            intensity = info.intensity,
            tonnage = info.tonnage
        )
    }
}

@Composable
private fun WeekDayStatusLine(
    modifier: Modifier = Modifier,
    listOfWeekDaysEnglish: List<String>,
    availableList: List<String>
) = Column(
    modifier = modifier,
    verticalArrangement = Arrangement.SpaceAround
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listOfWeekDaysEnglish.forEach {

            val weekShort by rememberUpdatedState(toShortWeek(it))

            TextFieldBody2(
                provideText = { weekShort }
            )
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listOfWeekDaysEnglish.forEach {
            Spacer(
                modifier = Modifier
                    .size(14.dp)
                    .background(
                        color = if (availableList.contains(it)) Design.colors.accent_secondary else Design.colors.caption,
                        shape = CircleShape
                    )
            )
        }
    }
}

@Composable
internal fun WeekInfoFooter(
    modifier: Modifier = Modifier,
    intensity: Double?,
    tonnage: Double?,
) {
    val tonnageKg = remember(tonnage) { "${tonnage}kg" }
    val intensityPercents = remember(intensity) { "${intensity}%" }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        TextFieldBody2(
            modifier = Modifier.padding(end = 4.dp),
            provideText = { "Intensity:" },
            color = Design.colors.caption,
        )

        TextFieldBody2(
            provideText = { intensityPercents },
            color = Design.colors.content,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        TextFieldBody2(
            modifier = Modifier.padding(end = 4.dp),
            provideText = { "Tonnage:" },
            color = Design.colors.caption,
        )

        TextFieldBody2(
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