package presentation.summary

import PlatformBackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import design.Design
import design.calendara.Calendar
import design.chart.PointCircle
import design.chart.PointLine
import design.components.Error
import design.components.Header
import design.components.Loading
import design.components.inputs.InputSearch
import design.components.items.ExerciseItem
import design.components.items.LineChartItem
import design.components.labels.WeekDayLabel
import design.components.roots.ScrollableRoot
import design.controls.TextFieldBody2

@Composable
internal fun SummaryContent(vm: SummaryViewModel) {

    val state by vm.state

    LaunchedEffect(Unit) {
        vm.getTrainings()
    }

    ScrollableRoot(
        modifier = Modifier.fillMaxSize(),
        loading = { Loading(state.loading) },
        error = { Error(message = state.error, close = vm::clearError) },
        back = { PlatformBackHandler(vm::back) },
        popups = {},
        header = {
            Header(
                title = "Summary!",
                exit = vm::back
            )
        },
        content = {
            item(key = "search_input") {
                InputSearch(
                    value = state.query,
                    onValueChange = vm::setQuery
                )
            }

            if (state.listOfSelectedDays.isNotEmpty())
                item(key = "calendar_view") {
                    LazyRow(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(Design.dp.padding)
                    ) {
                        items(12) {
                            Calendar(
                                modifier = Modifier
                                    .width(300.dp)
                                    .aspectRatio(1.4f),
                                month = it + 1,
                                year = 2022,
                                listOfValues = state.listOfSelectedDays,
                                Design.colors.unique.asList().getOrElse(it) { Design.colors.accent_primary }
                            )
                        }
                    }
                }

            if (state.listOfTonnage.isNotEmpty())
                item(key = "tonnage_chart") {
                    ChartSection(
                        label = "Tonnage",
                        data = state.listOfTonnage,
                        color = Design.colors.unique.color1,
                    )
                }


            item(key = "exercises") {

                state.exercises.forEach { item ->

                    Spacer(
                        modifier = Modifier.height(Design.dp.padding)
                    )

                    ExerciseHeader(
                        weekDay = item.key.weekDay,
                        date = item.key.dateTime
                    )

                    item.value.forEachIndexed { index, exercise ->
                        ExerciseItem(
                            number = index + 1,
                            exercise = exercise
                        )
                    }
                }
            }
        }
    )
}

@Composable
private fun ExerciseHeader(
    modifier: Modifier = Modifier,
    weekDay: String,
    date: String,
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(4.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    WeekDayLabel(
        modifier = Modifier.padding(end = 4.dp),
        weekDayEnglish = weekDay,
    )

    TextFieldBody2(
        text = date,
        color = Design.colors.caption,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ChartSection(
    label: String,
    color: Color,
    data: List<Float>,
) = LineChartItem(
    modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1.7f),
    lines = buildList {
        add(
            PointLine(
                yValue = data,
                lineColor = color,
                fillColor = color.copy(alpha = 0.2f),
                label = label,
                point = PointCircle(color = Design.colors.content)
            )
        )
    }
)