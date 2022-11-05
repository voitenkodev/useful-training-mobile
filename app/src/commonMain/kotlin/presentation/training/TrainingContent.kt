package presentation.training

import Design
import GlobalState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.BackHandler
import components.Error
import components.Header
import components.Loading
import components.Popup
import components.Root
import controls.TextFieldH2
import controls.dashedBorder
import items.EditExerciseItem
import selectState

@Composable
fun TrainingContent(vm: TrainingViewModel) {

    val state by selectState<GlobalState, TrainingState> { this.trainingState }

    Root(
        modifier = Modifier.fillMaxSize(),
        loading = {
            Loading(state.loading)
        },
        error = {
            Error(message = state.error, close = vm::clearError)
        },
        back = {
            BackHandler(
                action = {
                    if (state.removeExerciseId != null) {
                        vm.closeRemoveExercisePopup()
                        return@BackHandler
                    }
                    if (state.exitWarningVisibility.not()) {
                        vm.openExitScreenPopup()
                        return@BackHandler
                    }
                    if (state.exitWarningVisibility) {
                        vm.closeExitScreenPopup()
                        return@BackHandler
                    }
                }
            )
        },
        popup = {
            Popup(
                visibility = state.exitWarningVisibility,
                title = "Warning",
                message = "Are you sure to exit from training?",
                button = "Back",
                click = vm::back,
                back = vm::closeExitScreenPopup
            )
            Popup(
                visibility = state.removeExerciseId != null,
                title = "Warning",
                message = "Are you sure to remove exercise?",
                button = "Yes",
                click = {
                    vm.removeExercise(state.removeExerciseId)
                    vm.closeRemoveExercisePopup()
                },
                back = vm::closeRemoveExercisePopup
            )
        },
        header = {
            Header(
                title = "Exercises!",
                save = {
                    vm.processingTraining()
                    vm.saveTraining(state.training)
                },
                back = vm::openExitScreenPopup
            )
        },
        scrollableContent = {
            itemsIndexed(state.training.exercises, key = { _, exercise -> exercise.id }) { index, exercise ->
                EditExerciseItem(
                    modifier = Modifier.animateItemPlacement(),
                    number = index + 1,
                    exercise = exercise,
                    updateName = vm::updateName,
                    removeExercise = vm::openRemoveExercisePopup,
                    updateWeight = vm::updateWeight,
                    updateRepeat = vm::updateRepeat
                )
            }
            item(key = "new_exercise") {
                NewExercise(
                    modifier = Modifier.animateItemPlacement(),
                    onClick = vm::addExercise
                )
            }
        }
    )
}

@Composable
private fun NewExercise(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) = Box(
    modifier = modifier
        .fillMaxWidth()
        .height(128.dp)
        .dashedBorder(
            width = 2.dp,
            color = Design.colors.accent_secondary.copy(alpha = 0.5f),
            shape = Design.shape.default, on = 8.dp, off = 8.dp
        ).clickable(onClick = onClick),
    content = {
        TextFieldH2(
            modifier = Modifier.align(Alignment.Center),
            text = "Add Exercise",
            color = Design.colors.accent_secondary
        )
    }
)