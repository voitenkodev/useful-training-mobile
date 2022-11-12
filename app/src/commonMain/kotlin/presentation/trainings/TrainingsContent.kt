package presentation.trainings

import Design
import GlobalState
import LineChart
import PointLine
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import atomic.icons.BarChart
import components.BackHandler
import components.Error
import components.Loading
import controls.BottomSheet
import controls.IconPrimary
import controls.TextFieldBody1
import controls.TextFieldH1
import items.TrainingItem
import items.WeekSummary
import selectState

@Composable
fun TrainingsContent(vm: TrainingsViewModel) {

    val state by selectState<GlobalState, TrainingsState> { this.trainingsState }

    LaunchedEffect(Unit) { vm.fetchTrainings() }

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    BottomSheet(
        modifier = Modifier.fillMaxSize(),
        collapsed = Design.dp.collapsedAppBar,
        expanded = Design.dp.expandedAppBar,
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
                ),
                onClick = { p0, p1 -> }
            )

            Row(
                modifier = Modifier.height(Design.dp.collapsedAppBar).align(Alignment.BottomEnd).padding(horizontal = Design.dp.padding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.dp.padding, Alignment.End)
            ) {

                IconPrimary(
                    imageVector = BarChart,
                    modifier = Modifier
                        .size(Design.dp.component)
                        .background(
                            color = Design.colors.accent_secondary,
                            shape = Design.shape.default
                        ),
                    onClick = vm::addTraining
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

            Title(
                state = state,
                progress = it
            )
        },

        content = {
            state.weekTrainings.onEach {

                stickyHeader(key = "week_by_${it.key}") {
                    WeekSummary(info = it.key)
                }

                items(it.value, key = { it.id ?: it.hashCode() }) { training ->
                    TrainingItem(
                        training = training,
                        edit = { vm.editTraining(training) },
                        review = { vm.reviewTraining(training) }
                    )
                }
            }
        },
    )

    Error(message = state.error, close = vm::clearError)
    Loading(state.loading)
    // todo popup
    BackHandler(action = vm::back)
}

@Composable
private fun Title(
    state: TrainingsState,
    progress: Float
) {
    Column(modifier = Modifier.padding(start = Design.dp.padding)) {

        TextFieldH1(
            modifier = Modifier
                .height(Design.dp.collapsedAppBar)
                .wrapContentHeight(),
            text = state.weekDay,
        )

        TextFieldBody1(
            modifier = Modifier.alpha(progress),
            text = state.date,
        )
    }
}