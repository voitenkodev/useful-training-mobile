package presentation.training

import Design
import PlatformBackHandler
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.EditExerciseItem
import components.Error
import components.Header
import components.Loading
import components.Popup
import components.roots.ScrollableRoot
import controls.TextFieldH2
import controls.tertiaryBackground
import kotlinx.coroutines.delay
import recomposeHighlighter

@Composable
internal fun TrainingContent(vm: TrainingViewModel, trainingId: String?) {

    val state by vm.state.collectAsState()

    LaunchedEffect(Unit) {
        vm.getExerciseNameOptions()
    }

    LaunchedEffect(trainingId) {
        if (trainingId != null) {
            delay(500)
            vm.getTraining(trainingId)
        }
    }

    val exercisesProvider = rememberUpdatedState(state.training.exercises)

    Content(
        loading = { state.loading },
        error = { state.error },
        clearError = vm::clearError,
        tryBack = vm::tryBack,

        exitWarningVisibility = state.exitWarningVisibility,
        closeExitScreenPopup = vm::closeExitScreenPopup,
        back = vm::back,

        removeExerciseId = { state.removeExerciseId },
        removeExercise = vm::removeExercise,
        closeRemoveExercisePopup = vm::closeRemoveExercisePopup,

        openExitScreenPopup = vm::openExitScreenPopup,
        saveTraining = vm::saveTraining,

        exerciseNames = { state.exerciseNameOptions },

        exercises = exercisesProvider,
        updateName = vm::updateName,
        updateWeight = vm::updateWeight,
        updateRepeat = vm::updateRepeat,
        openRemoveExercisePopup = vm::openRemoveExercisePopup,
        addExercise = vm::addExercise,
        removeExerciseNameOption = vm::removeExerciseNameOption
    )
}

@Composable
private fun Content(
    loading: () -> Boolean,
    error: () -> String?,
    clearError: () -> Unit,
    tryBack: () -> Unit,
    back: () -> Unit,

    // Popups
    exitWarningVisibility: Boolean,
    closeExitScreenPopup: () -> Unit,

    removeExerciseId: () -> String?,
    removeExercise: (id: String?) -> Unit,
    closeRemoveExercisePopup: () -> Unit,

    // Header
    openExitScreenPopup: () -> Unit,
    saveTraining: () -> Unit,

    // Exercise names for help input
    exerciseNames: () -> List<String>,
    removeExerciseNameOption: (String) -> Unit,

    // Main Content
    exercises: State<List<Exercise>>,
    updateName: (id: String, value: String) -> Unit,
    updateWeight: (id: String, number: Int, value: String) -> Unit,
    updateRepeat: (id: String, number: Int, value: String) -> Unit,
    openRemoveExercisePopup: (id: String) -> Unit,
    addExercise: () -> Unit,
) {

    val tryBackProvider by rememberUpdatedState(tryBack)
    val saveTrainingProvider by rememberUpdatedState(saveTraining)
    val openExitScreenPopupProvider by rememberUpdatedState(openExitScreenPopup)
    val addExerciseProvider by rememberUpdatedState(addExercise)
    val exerciseNamesProvider by rememberUpdatedState(exerciseNames)
    val removeExerciseNameOptionProvider by rememberUpdatedState(removeExerciseNameOption)

    ScrollableRoot(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter(),
        loading = { Loading(loading) },
        error = { Error(message = error, close = clearError) },
        back = { PlatformBackHandler(tryBackProvider) },
        popups = {
            Popup(
                visibility = exitWarningVisibility,
                title = "Warning",
                message = "Are you sure to exit from training?",
                button = "Back",
                click = back,
                back = closeExitScreenPopup
            )
            Popup(
                visibility = removeExerciseId() != null,
                title = "Warning",
                message = "Are you sure to remove exercise?",
                button = "Yes",
                click = {
                    removeExercise(removeExerciseId())
                    closeRemoveExercisePopup()
                },
                back = closeRemoveExercisePopup
            )
        },
        header = {
            Header(
                title = "Exercises!",
                back = openExitScreenPopupProvider,
                save = saveTrainingProvider
            )
        },
        content = {


            itemsIndexed(exercises.value, key = { _, exercise -> exercise.id }) { index, exercise ->

                val id by rememberUpdatedState(exercise.id)
                val name by rememberUpdatedState(exercise.name)
                val number by rememberUpdatedState(index + 1)
                val iterations by rememberUpdatedState(exercise.iterations)

                EditExerciseItem(
                    modifier = Modifier.recomposeHighlighter(),
                    number = { number },
                    nameOptions = exerciseNamesProvider,
                    name = { name },
                    updateName = { updateName(id, it) },
                    updateWeight = { num, value -> updateWeight(id, num, value) },
                    updateRepeat = { num, value -> updateRepeat(id, num, value) },
                    iterations = { iterations },
                    remove = { openRemoveExercisePopup(id) },
                    removeNameOption = removeExerciseNameOptionProvider
                )
            }

            item(key = "new_exercise_btn") {
                NewExercise(
                    modifier = Modifier
                        .animateItemPlacement()
                        .recomposeHighlighter(),
                    onClick = addExerciseProvider
                )
            }
        }
    )
}

@Composable
private fun NewExercise(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(128.dp)
            .tertiaryBackground()
            .border(width = 1.dp, shape = Design.shape.default, color = Design.colors.accent_secondary)
            .clickable(onClick = onClick)
            .recomposeHighlighter(),
        content = {
            TextFieldH2(
                modifier = Modifier
                    .align(Alignment.Center)
                    .recomposeHighlighter(),
                provideText = { "Add Exercise" },
                color = Design.colors.accent_secondary
            )
        }
    )
}