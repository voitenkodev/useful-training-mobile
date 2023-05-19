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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import design.Design
import design.components.Error
import design.components.Header
import design.components.Loading
import design.components.Popup
import design.components.charts.IntensityChart
import design.components.charts.TonnageChart
import design.components.items.ExerciseItem
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
                        modifier = Modifier.animateItemPlacement(),
                        number = index + 1,
                        exercise = item
                    )
                }
            }

            item(key = "charts") {
                ChartsSection(
                    modifier = Modifier.animateItemPlacement(),
                    provideCompareTraining = provideCompareTraining,
                    provideReviewTraining = provideReviewTraining
                )
            }

            if (provideOtherTrainings().isNotEmpty()) {
                item(key = "comparing") {
                    Comparing(
                        modifier = Modifier.animateItemPlacement(),
                        provideList = provideOtherTrainings,
                        provideSelected = provideCompareTraining,
                        compare = compareWith,
                        clear = clearComparing
                    )
                }
            }

            item(key = "remove_action") {
                ButtonSecondary(
                    modifier = Modifier.fillMaxWidth().animateItemPlacement(),
                    text = "Remove Training",
                    color = Design.colors.accent_tertiary,
                    onClick = { openRemoveTrainingPopup(provideReviewTraining().id) }
                )
            }
        }
    )
}

@Composable
private fun ChartsSection(
    modifier: Modifier = Modifier,
    provideCompareTraining: () -> Training?,
    provideReviewTraining: () -> Training,
) = Column(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
) {
    HorizontalPager(
        pageCount = 3,
        pageSpacing = 8.dp,
        pageSize = PageSize.Fixed(Design.dp.fixedWidth),
        pageContent = { page ->
            when (page) {
                0 -> Summary(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.7f),
                    provideTraining = provideReviewTraining,
                    provideCompareTraining = provideCompareTraining
                )

                1 -> TonnageChart(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.7f),
                    provideData = {
                        provideReviewTraining().exercises.map { it.tonnage.toFloat() }
                    },
                    compareData = {
                        provideCompareTraining()?.exercises?.map { it.tonnage.toFloat() } ?: emptyList()
                    }
                )

                2 -> IntensityChart(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.7f),
                    provideData = {
                        provideReviewTraining().exercises.map { it.intensity.toFloat() }
                    },
                    compareData = {
                        provideCompareTraining()?.exercises?.map { it.intensity.toFloat() } ?: emptyList()
                    },
                )
            }
        }
    )
}

@Composable
private fun Comparing(
    modifier: Modifier = Modifier,
    provideSelected: () -> Training?,
    provideList: () -> List<Training>,
    compare: (Training) -> Unit,
    clear: () -> Unit
) = Column(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(Design.dp.padding)
) {

    val provideClear by rememberUpdatedState(clear)

    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = Design.dp.padding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextFieldBody2(
            provideText = { "Compare with..." },
            color = Design.colors.caption
        )

        if (provideSelected() != null) IconPrimary(
            modifier = Modifier
                .width(14.dp)
                .height(14.dp),
            imageVector = Icons.Default.Clear,
            onClick = provideClear
        )
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(Design.dp.padding)
    ) {

        items(provideList(), key = { it.id ?: it.hashCode() }) {
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
private fun Summary(
    modifier: Modifier = Modifier,
    provideTraining: () -> Training,
    provideCompareTraining: () -> Training?
) {

    val training by rememberUpdatedState(provideTraining())
    val compareTraining by rememberUpdatedState(provideCompareTraining())

    Column(
        modifier = modifier
            .secondaryBackground()
            .padding(horizontal = Design.dp.padding),
        verticalArrangement = Arrangement.SpaceAround
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
