package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import designsystem.common.DesignComponent
import designsystem.components.ExerciseItem
import designsystem.components.ShortTrainingItem
import designsystem.components.labels.WeekDayLabel
import designsystem.controls.*
import presentation.state.ShortTrainingState
import presentation.state.TrainingState

@Composable
fun ReviewContent(
    modifier: Modifier = Modifier,
    trainingState: TrainingState,
    comparingState: List<ShortTrainingState>,
    chart: @Composable (String, List<Float>, Color) -> Unit,
    back: () -> Unit,
    remove: (TrainingState) -> Unit
) = Root(
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
                state = trainingState
            )
        }

        item(key = "tonnage_chart") {
            ChartSection(
                label = "Tonnage",
                data = trainingState.exercises.map { it.tonnage.toFloat() },
                color = DesignComponent.colors.unique.color1,
                chart = chart
            )
        }

        item(key = "intensity_chart") {
            ChartSection(
                label = "Intensity",
                data = trainingState.exercises.map { it.intensity.toFloat() },
                color = DesignComponent.colors.unique.color4,
                chart = chart
            )
        }

        item(key = "comparing") {
            Comparing(comparingState)
        }

        item(key = "summary") {
            Summary(state = trainingState)
        }

        item(key = "exercises") {
            trainingState.exercises.forEachIndexed { index, item ->
                ExerciseItem(
                    number = index + 1, exercise = item
                )
            }
        }

        item(key = "remove_action") {
            ButtonSecondary(
                modifier = Modifier.fillMaxWidth(),
                text = "Remove Training",
                onClick = { remove.invoke(trainingState) },
            )
        }
    }
)

@Composable
private fun Comparing(
    list: List<ShortTrainingState>
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
            ShortTrainingItem(
                state = ShortTrainingState(
                    id = it.id,
                    startDateTime = it.startDateTime,
                    duration = it.duration,
                    exercises = it.exercises,
                )
            )
        }
    }
}

@Composable
private fun DateItem(
    modifier: Modifier, state: TrainingState
) = Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.spacedBy(2.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    WeekDayLabel(
        modifier = Modifier.padding(end = 4.dp), weekDay = state.weekDay
    )

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = "Date",
        color = DesignComponent.colors.caption,
    )

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = state.startTime,
        color = DesignComponent.colors.content,
        fontWeight = FontWeight.Bold
    )

    TextFieldBody2(
        text = state.shortStartDate, color = DesignComponent.colors.content, fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ChartSection(
    label: String,
    data: List<Float>,
    color: Color,
    chart: @Composable (String, List<Float>, Color) -> Unit,
) = Column(
    modifier = Modifier.fillMaxWidth().aspectRatio(1.5f).background(
        color = DesignComponent.colors.secondary, shape = DesignComponent.shape.default
    ).padding(DesignComponent.size.space),
    verticalArrangement = Arrangement.spacedBy(DesignComponent.size.space)
) {
    Row(
        modifier = Modifier.align(Alignment.End),
        horizontalArrangement = Arrangement.spacedBy(DesignComponent.size.space),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.size(14.dp).background(color))
        TextFieldBody2(text = label, color = DesignComponent.colors.caption)
    }
    chart.invoke(label, data, color)
}

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