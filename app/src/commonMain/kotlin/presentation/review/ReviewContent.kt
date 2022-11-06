package presentation.review

import Design
import GlobalState
import PointCircle
import PointLine
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import components.BackHandler
import components.Error
import components.Header
import components.Loading
import components.Popup
import components.Root
import components.items.LineChartItem
import components.labels.WeekDayLabel
import controls.ButtonSecondary
import controls.DividerPrimary
import controls.IconPrimary
import controls.TextFieldBody2
import controls.secondaryBackground
import items.ExerciseItem
import items.ShortTrainingItem
import presentation.training.Training
import selectState

@Composable
fun ReviewContent(vm: ReviewViewModel) {

    val state by selectState<GlobalState, ReviewState> { this.reviewState }

    Root(
        modifier = Modifier.fillMaxSize(),
        loading = {
            Loading(state.loading)
        },
        popup = {
            Popup(
                visibility = state.removeTrainingId != null,
                title = "Warning",
                message = "Are you sure to remove this training?",
                button = "Yes",
                click = {
                    val id = state.removeTrainingId
                    if (id == null) {
                        vm.showError("Invalid Training ID")
                        return@Popup
                    }
                    vm.closeRemoveTrainingPopup()
                    vm.removeTraining(id)
                },
                back = vm::closeRemoveTrainingPopup
            )
        },
        error = {
            Error(message = state.error, close = vm::clearError)
        },
        back = {
            BackHandler(action = vm::back)
        },
        header = {
            Header(
                title = "Review!",
                exit = vm::back
            )
        },
        scrollableContent = {
            item(key = "date") {
                DateItem(
                    weekDay = state.reviewTraining.weekDay,
                    startTime = state.reviewTraining.startTime,
                    startDate = state.reviewTraining.shortStartDate
                )
            }

            item(key = "tonnage_chart") {
                ChartSection(
                    label = "Tonnage",
                    data = state.reviewTraining.exercises.map { it.tonnage.toFloat() },
                    compareData = state.compareTraining?.exercises?.map { it.tonnage.toFloat() },
                    color = Design.colors.unique.color1,
                    onClick = { point, index -> }
                )
            }

            item(key = "intensity_chart") {
                ChartSection(
                    label = "Intensity",
                    data = state.reviewTraining.exercises.map { it.intensity.toFloat() },
                    compareData = state.compareTraining?.exercises?.map { it.intensity.toFloat() },
                    color = Design.colors.unique.color4,
                    onClick = { point, index -> }
                )
            }

            if (state.otherTrainings.isNotEmpty()) {
                item(key = "comparing") {
                    Comparing(
                        list = state.otherTrainings,
                        selected = state.compareTraining,
                        compare = { vm.compareWith(it) },
                        clear = { vm.clearComparing() }
                    )
                }
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
                    color = Design.colors.accent_tertiary,
                    onClick = {
                        vm.openRemoveTrainingPopup(state.reviewTraining.id)
                    }
                )
            }
        }
    )
}

@Composable
private fun Comparing(
    selected: Training?,
    list: List<Training>,
    compare: (Training) -> Unit,
    clear: () -> Unit
) = Column(
    verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(Design.dp.padding)
    ) {

        TextFieldBody2(
            modifier = Modifier.padding(start = Design.dp.padding),
            text = "Compare with...",
            color = Design.colors.caption
        )

        if (selected != null) IconPrimary(
            modifier = Modifier
                .width(16.dp)
                .height(16.dp)
                .background(
                    color = Design.colors.accent_secondary,
                    shape = Design.shape.default
                ),
            imageVector = Icons.Default.Clear,
            onClick = clear
        )
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(Design.dp.padding)
    ) {

        items(list, key = { it.id ?: it.hashCode() }) {
            ShortTrainingItem(
                training = it,
                highlight = it == selected,
                onClick = { compare.invoke(it) }
            )
        }
    }
}

@Composable
private fun DateItem(
    modifier: Modifier = Modifier,
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
        weekDayEnglish = weekDay
    )

    TextFieldBody2(
        modifier = Modifier.padding(end = 4.dp),
        text = startTime,
        color = Design.colors.caption,
        fontWeight = FontWeight.Bold
    )

    TextFieldBody2(
        text = startDate,
        color = Design.colors.caption,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun ChartSection(
    label: String,
    color: Color,
    data: List<Float>,
    compareData: List<Float>? = null,
    onClick: (PointLine, Int) -> Unit
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
        if (compareData != null) add(
            PointLine(
                yValue = compareData,
                lineColor = Design.colors.caption,
                fillColor = Design.colors.caption.copy(alpha = 0.2f),
                label = "Compare",
            )
        )
    },
    onClick = onClick
)

@Composable
private fun Summary(
    state: Training
) = Column(
    verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
) {

    TextFieldBody2(
        modifier = Modifier.padding(start = Design.dp.padding),
        text = "Summary",
        color = Design.colors.caption
    )

    Column(
        modifier = Modifier
            .secondaryBackground()
            .padding(horizontal = Design.dp.padding),
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
private fun Section(label: String, value: String) = Row(
    modifier = Modifier.fillMaxWidth().padding(vertical = Design.dp.padding),
    horizontalArrangement = Arrangement.SpaceBetween
) {
    TextFieldBody2(
        text = label,
        color = Design.colors.caption,
    )
    TextFieldBody2(
        text = value,
        fontWeight = FontWeight.Bold,
    )
}
