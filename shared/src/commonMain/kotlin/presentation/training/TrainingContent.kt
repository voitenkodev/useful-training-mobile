package presentation.training

import PlatformBackHandler
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import design.Design
import design.components.Error
import design.components.Header
import design.components.Loading
import design.components.Popup
import design.components.items.EditExerciseItem
import design.components.roots.ScrollableRoot
import design.controls.TextFieldH2
import design.controls.tertiaryBackground
import kotlinx.coroutines.delay
import utils.recomposeHighlighter

@Composable
internal fun TrainingContent(vm: TrainingViewModel, trainingId: String?) {

    val state by vm.state.collectAsState()

    LaunchedEffect(trainingId) {
        if (trainingId != null) {
            delay(500)
            vm.getTraining(trainingId)
        }
    }

    ScrollableRoot(
        modifier = Modifier.fillMaxWidth().recomposeHighlighter(),
        loading = { Loading(state.loading) },
        error = { Error(message = state.error, close = vm::clearError) },
        back = { PlatformBackHandler(vm::tryBack) },
        popups = {
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
                back = vm::openExitScreenPopup,
                save = vm::saveTraining
            )
        },
        content = {

            itemsIndexed(state.training.exercises, key = { _, exercise -> exercise.id }) { index, exercise ->

                val updateNameProvider by remember {
                    mutableStateOf({ value: String ->
                        vm.updateName(exercise.id, value)
                    })
                }
                val removeExerciseProvider by remember {
                    mutableStateOf({
                        vm.openRemoveExercisePopup(exercise.id)
                    })
                }
                val updateWeightProvider by remember {
                    mutableStateOf({ number: Int, value: String ->
                        vm.updateWeight(exercise.id, number, value)
                    })
                }
                val updateRepeatProvider by remember {
                    mutableStateOf({ number: Int, value: String ->
                        vm.updateRepeat(exercise.id, number, value)
                    })
                }

                EditExerciseItem(
                    modifier = Modifier.recomposeHighlighter(),
                    provideNumber = { (index + 1) },
                    provideName = { exercise.name },
                    updateName = updateNameProvider,
                    updateWeight = updateWeightProvider,
                    updateRepeat = updateRepeatProvider,
                    provideIterations = { exercise.iterations },
                    remove = removeExerciseProvider,
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
        .tertiaryBackground()
        .border(width = 1.dp, shape = Design.shape.default, color = Design.colors.accent_secondary)
        .clickable(onClick = onClick),
    content = {
        TextFieldH2(
            modifier = Modifier.align(Alignment.Center),
            text = "Add Exercise",
            color = Design.colors.accent_secondary
        )
    }
)