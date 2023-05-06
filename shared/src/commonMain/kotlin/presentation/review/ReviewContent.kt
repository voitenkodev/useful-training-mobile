package presentation.review

import PlatformBackHandler
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
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import design.Design
import design.chart.PointCircle
import design.chart.PointLine
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

    Content(
        loading = state.loading,
        error = state.error,
        clearError = vm::clearError,
        back = vm::back,

        removeTrainingId = state.removeTrainingId,
        showError = vm::showError,
        closeRemoveTrainingPopup = vm::closeRemoveTrainingPopup,
        removeTraining = vm::removeTraining,

        provideReviewTraining = { state.reviewTraining },
        provideCompareTraining = { state.compareTraining },
        provideOtherTrainings = { state.otherTrainings },
        clearComparing = vm::clearComparing,
        compareWith = vm::compareWith,
        openRemoveTrainingPopup = vm::openRemoveTrainingPopup
    )
}

@Composable
private fun Content(
    loading: Boolean,
    error: String?,
    clearError: () -> Unit,
    back: () -> Unit,

    // POPUPS
    removeTrainingId: String?,
    showError: (String) -> Unit,
    closeRemoveTrainingPopup: () -> Unit,
    removeTraining: (String) -> Unit,

    // CONTENT
    provideReviewTraining: () -> Training,
    provideCompareTraining: () -> Training?,
    provideOtherTrainings: () -> List<Training>,
    clearComparing: () -> Unit,
    compareWith: (Training) -> Unit,
    openRemoveTrainingPopup: (String?) -> Unit
) {
    ScrollableRoot(
        modifier = Modifier.fillMaxSize(),
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(back) },
        popups = {
            Popup(
                visibility = removeTrainingId != null,
                title = "Warning",
                message = "Are you sure to remove this training?",
                button = "Yes",
                click = {
                    val id = removeTrainingId
                    if (id == null) {
                        showError("Invalid Training ID")
                        return@Popup
                    }
                    closeRemoveTrainingPopup()
                    removeTraining(id)
                },
                back = closeRemoveTrainingPopup
            )
        },
        header = {
            Header(
                title = "Review!",
                exit = back
            )
        },
        content = {
            item(key = "date") {
                DateItem(
                    weekDay = provideReviewTraining().weekDay,
                    startTime = provideReviewTraining().startTime,
                    startDate = provideReviewTraining().shortStartDate
                )
            }

            item(key = "exercises") {
                provideReviewTraining().exercises.forEachIndexed { index, item ->
                    ExerciseItem(
                        number = index + 1,
                        exercise = item
                    )
                }
            }

            item(key = "tonnage_chart") {
                ChartSection(
                    label = "Tonnage",
                    data = provideReviewTraining().exercises.map { it.tonnage.toFloat() },
                    compareData = provideCompareTraining()?.exercises?.map { it.tonnage.toFloat() },
                    color = Design.colors.unique.color1,
                )
            }

            item(key = "intensity_chart") {
                ChartSection(
                    label = "Intensity",
                    data = provideReviewTraining().exercises.map { it.intensity.toFloat() },
                    compareData = provideCompareTraining()?.exercises?.map { it.intensity.toFloat() },
                    color = Design.colors.unique.color4,
                )
            }

            item(key = "summary") {
                Summary(
                    training = provideReviewTraining(),
                    compareTraining = provideCompareTraining()
                )
            }

            if (provideOtherTrainings().isNotEmpty()) {
                item(key = "comparing") {
                    Comparing(
                        provideList = provideOtherTrainings,
                        provideSelected = provideCompareTraining,
                        compare = compareWith,
                        clear = clearComparing
                    )
                }
            }

            item(key = "remove_action") {
                ButtonSecondary(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Remove Training",
                    color = Design.colors.accent_tertiary,
                    onClick = { openRemoveTrainingPopup(provideReviewTraining().id) }
                )
            }
        }
    )
}

@Composable
private fun Comparing(
    provideSelected: () -> Training?,
    provideList: () -> List<Training>,
    compare: (Training) -> Unit,
    clear: () -> Unit
) = Column(
    verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
) {

    val provideClear by rememberUpdatedState(clear)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextFieldBody2(
            modifier = Modifier.padding(start = Design.dp.padding),
            provideText = { "Compare with..." },
            color = Design.colors.caption
        )

        if (provideSelected() != null) IconPrimary(
            modifier = Modifier
                .width(24.dp)
                .height(24.dp),
            imageVector = Icons.Default.Clear,
            onClick = provideClear
        )
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(Design.dp.padding)
    ) {

        items(provideList(), key = { it.id!! }) {
            ShortTrainingItem(
                training = it,
                highlight = it == provideSelected(),
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
        provideText = { startTime },
        color = Design.colors.caption,
        fontWeight = FontWeight.Bold
    )

    TextFieldBody2(
        provideText = { startDate },
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
        provideText = { "Summary" },
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
        provideText = { label },
        color = Design.colors.caption,
    )

    Spacer(
        modifier = Modifier.weight(1f)
    )

    TextFieldBody2(
        provideText = { value },
        fontWeight = FontWeight.Bold,
    )
    if (compareValue != null) TextFieldBody2(
        provideText = { compareValue },
        fontWeight = FontWeight.Bold,
        color = Design.colors.caption
    )
}
