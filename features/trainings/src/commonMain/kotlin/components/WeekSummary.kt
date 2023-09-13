package components

import Design
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import chart.LineChart
import chart.PointLine
import components.items.WeekDayStatusLine
import components.items.WeekInfoFooter
import controls.TextFieldBody2
import recomposeHighlighter
import trainings.WeekInfo

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
            .padding(Design.dp.paddingM)
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
                        .padding(start = Design.dp.paddingM)
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
