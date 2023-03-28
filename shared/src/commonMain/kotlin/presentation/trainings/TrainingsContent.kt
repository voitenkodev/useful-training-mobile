package presentation.trainings

import PlatformBackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import chart.LineChart
import chart.PointLine
import design.Design
import design.components.Error
import design.components.Loading
import design.components.items.TrainingItem
import design.components.items.WeekSummary
import design.components.roots.BottomSheetRoot
import design.controls.IconPrimary
import design.controls.TextFieldBody1
import design.controls.TextFieldH1
import kotlinx.coroutines.launch

@Composable
internal fun TrainingsContent(vm: TrainingsViewModel) {

    val state by vm.state

    LaunchedEffect(Unit) { vm.getTrainings() }

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    BottomSheetRoot(
        modifier = Modifier.fillMaxSize(),
        loading = { Loading(state.loading) },
        error = { Error(message = state.error, close = vm::clearError) },
        back = { PlatformBackHandler(vm::back) },
        collapsed = Design.dp.collapsedAppBar,
        expanded = Design.dp.expandedAppBar,
        listState = listState,
        topBar = {

            LineChart(
                modifier = Modifier.fillMaxWidth()
                    .requiredHeight(Design.dp.expandedAppBar)
                    .alpha(0.2f)
                    .alpha(it),
                lines = listOf(
                    PointLine(
                        yValue = listOf(1f, 3f, 5f, 4f, 6f, 8f, 7f, 12f, 13f),
                        lineColor = Design.colors.accent_secondary,
                        fillColor = Design.colors.accent_secondary.copy(alpha = 0.15f)
                    )
                )
            )

            HeaderButtons(vm)

            Title(weekDay = state.weekDay, date = state.date, progress = it)

        },

        content = {
            state.weekTrainings.onEach {

                stickyHeader(key = "week_by_${it.key}") {
                    WeekSummary(info = it.key) {
                        coroutineScope.launch {
                            listState.animateScrollToItem(index = 4)
                        }
                    }
                }

                items(it.value, key = { it.id ?: it.hashCode() }) { training ->
                    TrainingItem(
                        training = training,
                        edit = { vm.editTraining(training) },
                        review = { vm.reviewTraining(training) }
                    )
                }
            }
        }
    )
}

@Composable
private fun BoxScope.HeaderButtons(vm: TrainingsViewModel) = Row(
    modifier = Modifier
        .height(Design.dp.collapsedAppBar)
        .align(Alignment.BottomEnd)
        .padding(end = Design.dp.padding, bottom = Design.dp.padding),
    verticalAlignment = Alignment.Bottom,
    horizontalArrangement = Arrangement.spacedBy(Design.dp.padding, Alignment.End)
) {

    IconPrimary(
        imageVector = Icons.Default.Search,
        modifier = Modifier
            .size(Design.dp.component)
            .background(
                color = Design.colors.accent_secondary,
                shape = Design.shape.default
            ),
        onClick = vm::moveToSummary
    )

    IconPrimary(
        imageVector = Icons.Default.Add,
        modifier = Modifier
            .size(Design.dp.component)
            .background(
                color = Design.colors.accent_primary,
                shape = Design.shape.default
            ),
        onClick = vm::addTraining
    )
}

@Composable
private fun Title(
    weekDay: String,
    date: String,
    progress: Float
) = Column(modifier = Modifier.padding(start = Design.dp.padding)) {

    TextFieldH1(
        modifier = Modifier
            .height(Design.dp.collapsedAppBar)
            .wrapContentHeight(),
        text = weekDay,
    )

    TextFieldBody1(
        modifier = Modifier.alpha(progress),
        text = date,
    )
}