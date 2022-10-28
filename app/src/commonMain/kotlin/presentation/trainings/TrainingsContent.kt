package presentation.trainings

import DesignComponent
import GlobalState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import components.BackHandler
import components.Error
import components.Header
import components.Loading
import components.Root
import controls.ButtonPrimary
import items.TrainingItem
import items.WeekSummary
import selectState

@Composable
fun TrainingsContent(vm: TrainingsViewModel) {

    val state by selectState<GlobalState, TrainingsState> { this.trainingsState }

    LaunchedEffect(Unit) {
        vm.fetchTrainings()
    }

    Root(
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
            Header(title = "Trainings!")
        },
        footer = {
            ButtonPrimary(
                modifier = Modifier.fillMaxWidth()
                    .background(
                        color = DesignComponent.colors.accent_primary,
                        shape = DesignComponent.shape.default
                    ),
                text = "New Training",
                onClick = vm::addTraining
            )
        },
        scrollableContent = {

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

