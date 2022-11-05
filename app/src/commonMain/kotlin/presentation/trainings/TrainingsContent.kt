package presentation.trainings

import Design
import GlobalState
import LineChart
import PointLine
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import components.BackHandler
import components.Error
import components.Loading
import components.Scaffold
import components.inputs.InputSearch
import controls.IconPrimary
import controls.TextFieldH1
import controls.TextFieldH2
import items.TrainingItem
import items.WeekSummary
import selectState

@Composable
fun TrainingsContent(vm: TrainingsViewModel) {

    val state by selectState<GlobalState, TrainingsState> { this.trainingsState }

    LaunchedEffect(Unit) {
        vm.fetchTrainings()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        loading = {
            Loading(state.loading)
        },
        error = {
            Error(message = state.error, close = vm::clearError)
        },
        back = {
            BackHandler(action = vm::back)
        },
        header = {
            LineChart(
                modifier = Modifier.fillMaxSize().alpha(it).padding(bottom = 30.dp),
                lines = listOf(
                    PointLine(
                        yValue = listOf(2f, 5f, 4f, 6f, 8f, 7f, 12f, 13f),
                        lineColor = Design.colors.accent_secondary,
                        fillColor = Design.colors.accent_secondary.copy(alpha = 0.15f)
                    )
                ),
                onClick = { p0, p1 -> }
            )

            Column(modifier = Modifier.padding(Design.size.space)) {

                TextFieldH1(
                    text = "Trainings!"
                )

                TextFieldH2(
                    modifier = Modifier.alpha(it),
                    text = "Stay strong and perfect...",
                    color = Design.colors.caption
                )
            }

            Row(
                modifier = Modifier.align(Alignment.BottomEnd).padding(Design.size.space),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(Design.size.space, Alignment.End)
            ) {

                InputSearch(
                    modifier = Modifier.alpha(it).weight(1f),
                    value = "",
                    onValueChange = {}
                )

                IconPrimary(
                    imageVector = Icons.Default.Add,
                    modifier = Modifier
                        .size(56.dp)
                        .background(
                            color = Design.colors.accent_primary,
                            shape = Design.shape.default
                        ),
                    onClick = vm::addTraining
                )
            }
        },
        content = {

            state.weekTrainings.onEach {

                item(key = "week_by_${it.key}") {
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
        }
    )
}

@Composable
fun animateAlignmentAsState(
    targetAlignment: Alignment,
): State<Alignment> {
    val biased = targetAlignment as BiasAlignment
    val horizontal by animateFloatAsState(biased.horizontalBias)
    val vertical by animateFloatAsState(biased.verticalBias)
    return derivedStateOf { BiasAlignment(horizontal, vertical) }
}
