package presentation.review

import PlatformBackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import design.chart.PointCircle
import design.chart.PointLine
import design.Design
import design.components.Error
import design.components.Header
import design.components.Loading
import design.components.Popup
import design.components.items.ExerciseItem
import design.components.items.LineChartItem
import design.components.items.ShortTrainingItem
import design.components.labels.WeekDayLabel
import design.components.roots.ScrollableRoot
import design.controls.ButtonSecondary
import design.controls.DividerPrimary
import design.controls.IconPrimary
import design.controls.TextFieldBody2
import design.controls.secondaryBackground
import presentation.training.Training

@Composable
internal fun ReviewContent(vm: ReviewViewModel, trainingId: String) {

    val state by vm.state

    LaunchedEffect(Unit) {
        vm.getTraining(trainingId)
        vm.getTrainings()
    }

    ScrollableRoot(
        modifier = Modifier.fillMaxSize(),
        loading = { Loading(state.loading) },
        error = { Error(message = state.error, close = vm::clearError) },
        back = { PlatformBackHandler(vm::back) },
        popups = {
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
        header = {
            Header(
                title = "Review!",
                exit = vm::back
            )
        },
        content = {
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
                )
            }

            item(key = "intensity_chart") {
                ChartSection(
                    label = "Intensity",
                    data = state.reviewTraining.exercises.map { it.intensity.toFloat() },
                    compareData = state.compareTraining?.exercises?.map { it.intensity.toFloat() },
                    color = Design.colors.unique.color4,
                )
            }

            item(key = "summary") {
                Summary(
                    training = state.reviewTraining,
                    compareTraining = state.compareTraining
                )
            }

            item(key = "exercises") {
                state.reviewTraining.exercises.forEachIndexed { index, item ->
                    ExerciseItem(
                        number = index + 1,
                        exercise = item
                    )
                }
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

            item(key = "remove_action") {
                ButtonSecondary(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Remove Training",
                    color = Design.colors.accent_tertiary,
                    onClick = { vm.openRemoveTrainingPopup(state.reviewTraining.id) }
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

        items(list, key = { it.id!! }) {
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
    horizontalArrangement = Arrangement.spacedBy(4.dp),
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
) {

    val colorDataPoint = Design.colors.content
    val colorCompareDataPoint = Design.colors.caption

    val lines by remember(data, compareData) {
        mutableStateOf(buildList {
            add(
                PointLine(
                    yValue = data,
                    lineColor = color,
                    fillColor = color.copy(alpha = 0.2f),
                    label = label,
                    point = PointCircle(color = colorDataPoint)
                )
            )
            if (compareData != null) add(
                PointLine(
                    yValue = compareData,
                    lineColor = colorCompareDataPoint,
                    fillColor = colorCompareDataPoint.copy(alpha = 0.2f),
                    label = "Compare",
                )
            )
        })
    }

    LineChartItem(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.7f),
        lines = { lines }
    )
}

@Composable
private fun Summary(
    training: Training,
    compareTraining: Training?
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
            label = "Tonnage",
            value = "${training.tonnage}kg",
            compareValue = compareTraining?.tonnage?.let { " / ${it}kg" }
        )

        DividerPrimary()

        Section(
            label = "Repeats",
            value = "${training.countOfLifting}",
            compareValue = compareTraining?.countOfLifting?.let { " / $it" }
        )

        DividerPrimary()

        Section(
            label = "Intensity",
            value = "${training.intensity}%",
            compareValue = compareTraining?.intensity?.let { " / ${it}%" }
        )

        DividerPrimary()

        Section(
            label = "Duration",
            value = training.durationTime,
            compareValue = compareTraining?.durationTime?.let { " / $it" }
        )
    }
}

@Composable
private fun Section(
    label: String,
    value: String,
    compareValue: String?
) = Row(
    modifier = Modifier.fillMaxWidth().padding(vertical = Design.dp.padding),
) {

    TextFieldBody2(
        text = label,
        color = Design.colors.caption,
    )

    Spacer(
        modifier = Modifier.weight(1f)
    )

    TextFieldBody2(
        text = value,
        fontWeight = FontWeight.Bold,
    )
    if (compareValue != null) TextFieldBody2(
        text = compareValue,
        fontWeight = FontWeight.Bold,
        color = Design.colors.caption
    )
}
