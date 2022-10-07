package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.atomic.DesignComponent
import designsystem.components.CollapsedTrainingItem
import designsystem.components.ExerciseItem
import designsystem.components.labels.WeekDayLabel
import designsystem.controls.ButtonSecondary
import designsystem.controls.DividerPrimary
import designsystem.components.Header
import designsystem.components.LineChartBoard
import designsystem.controls.LineChart
import designsystem.components.Root
import designsystem.controls.TextFieldBody2
import redux.GlobalState
import redux.ReviewState
import redux.TrainingState
import redux.rememberDispatcher
import redux.selectState

@Composable
fun ReviewContent(
    modifier: Modifier = Modifier,
    chart: @Composable (String, List<Float>, Color) -> Unit,
    back: () -> Unit,
    remove: (TrainingState) -> Unit
) {
    val dispatcher = rememberDispatcher()
    val state by selectState<GlobalState, ReviewState> { this.reviewState }

    Root(
        modifier = modifier,
        header = {
            Header(
                title = "Review!",
                exit = back
            )
        },
        content = {
            item(key = "date") {
                DateItem(
                    modifier = Modifier,
                    weekDay = state.reviewTraining.weekDay,
                    startTime = state.reviewTraining.startTime,
                    startDate = state.reviewTraining.shortStartDate
                )
            }

            item(key = "tonnage_chart") {
                ChartSection(
                    label = "Tonnage",
                    data = state.reviewTraining.exercises.map { it.tonnage.toFloat() },
                    color = DesignComponent.colors.unique.color1,
                    chart = chart
                )
            }
            item(key = "intensity_chart") {
                ChartSection(
                    label = "Intensity",
                    data = state.reviewTraining.exercises.map { it.intensity.toFloat() },
                    color = DesignComponent.colors.unique.color4,
                    chart = chart
                )
            }

            item(key = "comparing") {
                Comparing(state.otherTraining)
            }

            item(key = "summary") {
                Summary(state = state.reviewTraining)
            }

            item(key = "exercises") {
                state.reviewTraining.exercises.forEachIndexed { index, item ->
                    ExerciseItem(
                        number = index + 1,
                        exercise = item
                    )
                }
            }

            item(key = "remove_action") {
                ButtonSecondary(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Remove Training",
                    onClick = { remove.invoke(state.reviewTraining) },
                )
            }
        }
    )
}

@Composable
private fun Comparing(
    list: List<TrainingState>
) = Column(
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
) {

    TextFieldBody2(
        modifier = Modifier.padding(start = DesignComponent.size.space),
        text = "Compare with...",
        color = DesignComponent.colors.caption
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
    ) {
        items(list) {
            CollapsedTrainingItem(state = it)
        }
    }
}

@Composable
private fun DateItem(
    modifier: Modifier,
    weekDay: String,
    startTime: String,
    startDate: String
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(2.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    WeekDayLabel(
        modifier = Modifier.padding(end = 4.dp),
        weekDay = weekDay
    )

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Date",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = startTime,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )

    TextFieldBody2(
        text = startDate,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ChartSection(
    label: String,
    data: List<Float>,
    color: Color,
    chart: @Composable (String, List<Float>, Color) -> Unit,
) = LineChartBoard(
    modifier = Modifier
        .fillMaxWidth()
        .aspectRatio(1.8f),
    yPoints = data,
    label = label,
    lineColor = color,
    fillColor = color.copy(alpha = 0.2f),
    pointColor = color
)

//@Composable
//private fun ChartSection(
//    label: String,
//    data: List<Float>,
//    color: Color,
//    chart: @Composable (String, List<Float>, Color) -> Unit,
//) = Column(
//    modifier = Modifier.fillMaxWidth().aspectRatio(1.5f).background(
//        color = DesignComponent.colors.secondary, shape = DesignComponent.shape.default
//    ).padding(DesignComponent.size.space),
//    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
//) {
//    Row(
//        modifier = Modifier.align(Alignment.End),
//        horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Spacer(Modifier.size(14.dp).background(color))
//        TextFieldBody2(text = label, color = DesignComponent.colors.caption)
//    }
//
//    LineChartBoard(
//        modifier = Modifier
//            .fillMaxWidth()
//            .aspectRatio(1.8f),
//        yPoints = data,
//        label = label,
//        lineColor = color,
//        fillColor = color.copy(alpha = 0.2f),
//        pointColor = color
//    )
//}

@Composable
private fun Summary(
    state: TrainingState
) = Column(
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
) {

    TextFieldBody2(
        modifier = Modifier.padding(start = DesignComponent.size.space),
        text = "Summary",
        color = DesignComponent.colors.caption
    )

    Column(
        modifier = Modifier.background(
            color = DesignComponent.colors.secondary,
            shape = DesignComponent.shape.default
        ).padding(horizontal = DesignComponent.size.space),
    ) {

        Section(
            label = "Tonnage", value = "${state.tonnage}kg"
        )

        DividerPrimary()

        Section(
            label = "Repeats", value = "${state.countOfLifting}"
        )

        DividerPrimary()

        Section(
            label = "Intensity", value = "${state.intensity}%"
        )

        DividerPrimary()

        Section(
            label = "Duration", value = state.durationTime
        )
    }
}

@Composable
private fun Section(
    label: String, value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = DesignComponent.size.space),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextFieldBody2(
            text = label,
            color = DesignComponent.colors.caption,
        )
        TextFieldBody2(
            text = value,
            fontWeight = FontWeight.Bold,
        )
    }
}