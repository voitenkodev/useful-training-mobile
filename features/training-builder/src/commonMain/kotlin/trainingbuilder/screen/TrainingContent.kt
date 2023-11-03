package trainingbuilder.screen

import PlatformBackHandler
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import atom.Design
import components.Error
import components.Loading
import components.Popup
import components.roots.ScrollableRoot
import icons.ArrowLeft
import icons.Done
import kotlinx.coroutines.delay
import molecule.ButtonIconSecondary
import molecule.TextH4
import recomposeHighlighter
import trainingbuilder.components.EditExercise
import trainingbuilder.state.Exercise

@Composable
internal fun TrainingContent(
    vm: TrainingViewModel,
    trainingId: String?,
    toReview: (trainingId: String) -> Unit,
    back: () -> Unit
) {

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
        back = {
            vm.closeExitScreenPopup()
            back.invoke()
        },

        removeExerciseIndex = { state.removeExerciseIndex },
        removeExercise = vm::removeExercise,
        closeRemoveExercisePopup = vm::closeRemoveExercisePopup,

        openExitScreenPopup = vm::openExitScreenPopup,
        saveTraining = { vm.saveTraining(toReview) },

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

    exitWarningVisibility: Boolean,
    closeExitScreenPopup: () -> Unit,

    removeExerciseIndex: () -> Int?,
    removeExercise: (index: Int?) -> Unit,
    closeRemoveExercisePopup: () -> Unit,

    openExitScreenPopup: () -> Unit,
    saveTraining: () -> Unit,

    exerciseNames: () -> List<String>,
    removeExerciseNameOption: (String) -> Unit,

    exercises: State<List<Exercise>>,
    updateName: (exerciseNumber: Int, value: String) -> Unit,
    updateWeight: (exerciseNumber: Int, iterationNumber: Int, value: String) -> Unit,
    updateRepeat: (exerciseNumber: Int, iterationNumber: Int, value: String) -> Unit,
    openRemoveExercisePopup: (index: Int) -> Unit,
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
                visibility = removeExerciseIndex() != null,
                title = "Warning",
                message = "Are you sure to remove exercise?",
                button = "Yes",
                click = {
                    removeExercise(removeExerciseIndex())
                    closeRemoveExercisePopup()
                },
                back = closeRemoveExercisePopup
            )
        },
        header = {
            Row {
                ButtonIconSecondary(
                    modifier = Modifier.size(Design.dp.componentL),
                    imageVector = ArrowLeft,
                    onClick = openExitScreenPopupProvider
                )

                Spacer(Modifier.weight(1f))

                ButtonIconSecondary(
                    modifier = Modifier.size(Design.dp.componentL),
                    imageVector = Done,
                    onClick = saveTrainingProvider
                )
            }
        },
        content = {

            itemsIndexed(exercises.value) { index, exercise ->
                val indexProvider by rememberUpdatedState(index)
                val name by rememberUpdatedState(exercise.name)
                val number by rememberUpdatedState(index + 1)
                val iterations by rememberUpdatedState(exercise.iterations)

                EditExercise(
                    modifier = Modifier.recomposeHighlighter(),
                    number = { number },
                    nameOptions = exerciseNamesProvider,
                    name = { name },
                    updateName = { updateName(indexProvider, it) },
                    updateWeight = { num, value -> updateWeight(indexProvider, num, value) },
                    updateRepeat = { num, value -> updateRepeat(indexProvider, num, value) },
                    iterations = { iterations },
                    remove = { openRemoveExercisePopup(indexProvider) },
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
            .border(
                width = 1.dp,
                shape = Design.shape.default, color = Design.colors.accentPrimary
            )
            .clickable(onClick = onClick)
            .recomposeHighlighter(),
        content = {
            TextH4(
                modifier = Modifier
                    .align(Alignment.Center)
                    .recomposeHighlighter(),
                provideText = { "Add Exercise" },
                color = Design.colors.accentPrimary
            )
        }
    )
}