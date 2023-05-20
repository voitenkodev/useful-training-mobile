package design.components.items

import androidx.compose.foundation.background
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
import utils.recomposeHighlighter

@Composable
internal fun WeekSummary(
    modifier: Modifier = Modifier,
    info: WeekInfo
) = Box(
    modifier = modifier
        .requiredHeight(114.dp)
        .background(color = Design.colors.secondary, shape = Design.shape.default)
        .fillMaxWidth()
        .recomposeHighlighter()
) {

    val lineColor = Design.colors.accent_secondary

    LineChart(
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.15f)
            .padding(bottom = 10.dp)
            .recomposeHighlighter(),
        lines = {
            listOf(
                PointLine(
                    yValue = listOf(1f, 3f, 5f, 4f, 6f, 8f, 7f, 12f, 13f),
                    lineColor = lineColor,
                    fillColor = lineColor.copy(alpha = 0.15f)
                )
            )
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Design.dp.padding)
            .recomposeHighlighter(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .recomposeHighlighter(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Column(
                modifier = Modifier
                    .height(44.dp)
                    .recomposeHighlighter(),
                verticalArrangement = Arrangement.SpaceAround
            ) {

                TextFieldBody2(
                    modifier = Modifier.recomposeHighlighter(),
                    provideText = { info.startWeekDate + " →" },
                    fontWeight = FontWeight.Bold,
                )

                TextFieldBody2(
                    modifier = modifier
                        .padding(start = Design.dp.padding)
                        .recomposeHighlighter(),
                    provideText = { "← " + info.endWeekDate },
                    fontWeight = FontWeight.Bold,
                )
            }

            WeekDayStatusLine(
                modifier = Modifier
                    .width(180.dp)
                    .height(44.dp)
                    .recomposeHighlighter(),
                listOfWeekDaysEnglish = listOf("MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"),
                availableList = info.trainingWeekDays
            )
        }

        WeekInfoFooter(
            modifier = Modifier.recomposeHighlighter(),
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
internal fun WeekInfoFooter(
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