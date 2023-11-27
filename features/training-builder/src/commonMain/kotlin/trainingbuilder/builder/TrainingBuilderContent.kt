package trainingbuilder.builder

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import components.Error
import components.roots.ScreenRoot
import molecule.PopupSheet
import trainingbuilder.builder.components.Footer
import trainingbuilder.builder.components.Header
import trainingbuilder.builder.popups.FindExercisePopup
import trainingbuilder.builder.popups.SetExercisePopup

@Composable
internal fun TrainingBuilderContent(
    vm: TrainingBuilderViewModel,
    toSummary: (trainingId: String) -> Unit,
    back: () -> Unit
) {

    val state by vm.state.collectAsState()

    if (state.setExercisePopupVisibleIndex != null) PopupSheet(
        onDismiss = vm::closeSetExercisePopup,
        content = { hideLambda ->

            val index = state.setExercisePopupVisibleIndex ?: return@PopupSheet
            val exercise = state.training.exercises.getOrNull(index) ?: return@PopupSheet
            val name by rememberUpdatedState(exercise.name)
            val number by rememberUpdatedState(index + 1)
            val iterations by rememberUpdatedState(exercise.iterations)

            SetExercisePopup(
                close = hideLambda,
                number = { number },
                name = { name },
                updateName = { vm.updateName(index, it) },
                updateWeight = { num, value -> vm.updateWeight(index, num, value) },
                updateRepeat = { num, value -> vm.updateRepeat(index, num, value) },
                iterations = { iterations }
            )
        }
    )

    if (state.findExercisePopupIsVisibleIndex) PopupSheet(
        onDismiss = vm::closeFindExercisePopup,
        content = { hideLambda ->

            FindExercisePopup(
                close = hideLambda,
                exerciseExamples = state.exerciseExamples,
                muscles = state.muscles,
                setMuscleTarget = vm::setMuscleTarget,
                selectedMuscle = state.selectedMuscle,
                selectExercise = vm::openAddExercisePopup,
                createExercise = vm::openAddExercisePopup
            )
        }
    )

    Content(
        error = state.error,
        clearError = vm::clearError,
        addExercise = vm::openFindExercisePopup
    )
}

@Composable
private fun Content(
    error: String?,
    clearError: () -> Unit,

    addExercise: () -> Unit
) {

    ScreenRoot(error = { Error(message = { error }, close = clearError) }) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Header()

            LazyColumn(modifier = Modifier.fillMaxWidth().weight(1f)) {

            }

            Footer(addExercise = addExercise)
        }
    }
}

//@Deprecated("use Content")
//@Composable
//private fun Content2(
//    loading: () -> Boolean,
//    error: () -> String?,
//    clearError: () -> Unit,
//    tryBack: () -> Unit,
//    back: () -> Unit,
//
//    exitWarningVisibility: Boolean,
//    closeExitScreenPopup: () -> Unit,
//
//    removeExerciseIndex: () -> Int?,
//    removeExercise: (index: Int?) -> Unit,
//    closeRemoveExercisePopup: () -> Unit,
//
//    openExitScreenPopup: () -> Unit,
//    saveTraining: () -> Unit,
//
//    exerciseNames: () -> List<String>,
//    removeExerciseNameOption: (String) -> Unit,
//
//    exercises: State<List<Exercise>>,
//    updateName: (exerciseNumber: Int, value: String) -> Unit,
//    updateWeight: (exerciseNumber: Int, iterationNumber: Int, value: String) -> Unit,
//    updateRepeat: (exerciseNumber: Int, iterationNumber: Int, value: String) -> Unit,
//    openRemoveExercisePopup: (index: Int) -> Unit,
//    addExercise: () -> Unit,
//) {
//
//    val tryBackProvider by rememberUpdatedState(tryBack)
//    val saveTrainingProvider by rememberUpdatedState(saveTraining)
//    val openExitScreenPopupProvider by rememberUpdatedState(openExitScreenPopup)
//    val addExerciseProvider by rememberUpdatedState(addExercise)
//
//    ScrollableRoot(
//        modifier = Modifier
//            .fillMaxWidth()
//            .recomposeHighlighter(),
//        loading = { Loading(loading) },
//        error = { Error(message = error, close = clearError) },
//        back = { PlatformBackHandler(tryBackProvider) },
//        popups = {
//            Popup(
//                visibility = exitWarningVisibility,
//                title = "Warning",
//                message = "Are you sure to exit from training?",
//                button = "Back",
//                click = back,
//                back = closeExitScreenPopup
//            )
//            Popup(
//                visibility = removeExerciseIndex() != null,
//                title = "Warning",
//                message = "Are you sure to remove exercise?",
//                button = "Yes",
//                click = {
//                    removeExercise(removeExerciseIndex())
//                    closeRemoveExercisePopup()
//                },
//                back = closeRemoveExercisePopup
//            )
//        },
//        header = {
//            Row {
//                ButtonIconSecondary(
//                    modifier = Modifier.size(Design.dp.componentL),
//                    imageVector = Icons.arrowLeft,
//                    onClick = openExitScreenPopupProvider
//                )
//
//                Spacer(Modifier.weight(1f))
//
//                ButtonIconSecondary(
//                    modifier = Modifier.size(Design.dp.componentL),
//                    imageVector = Icons.done,
//                    onClick = saveTrainingProvider
//                )
//            }
//        },
//        content = {
//
//            itemsIndexed(exercises.value) { index, exercise ->
//                val indexProvider by rememberUpdatedState(index)
//                val name by rememberUpdatedState(exercise.name)
//                val number by rememberUpdatedState(index + 1)
//                val iterations by rememberUpdatedState(exercise.iterations)
//
//                EditExercise(
//                    modifier = Modifier.recomposeHighlighter(),
//                    number = { number },
//                    name = { name },
//                    updateName = { updateName(indexProvider, it) },
//                    updateWeight = { num, value -> updateWeight(indexProvider, num, value) },
//                    updateRepeat = { num, value -> updateRepeat(indexProvider, num, value) },
//                    iterations = { iterations }
//                )
//            }
//
//            item(key = "new_exercise_btn") {
//                NewExercise(
//                    modifier = Modifier
//                        .animateItemPlacement()
//                        .recomposeHighlighter(),
//                    onClick = addExerciseProvider
//                )
//            }
//        }
//    )
//}
//
//@Composable
//private fun NewExercise(
//    modifier: Modifier = Modifier,
//    onClick: () -> Unit
//) {
//    Box(
//        modifier = modifier
//            .fillMaxWidth()
//            .height(128.dp)
//            .border(
//                width = 1.dp,
//                shape = Design.shape.default, color = Design.colors.orange
//            )
//            .clickable(onClick = onClick)
//            .recomposeHighlighter(),
//        content = {
//            TextH4(
//                modifier = Modifier
//                    .align(Alignment.Center)
//                    .recomposeHighlighter(),
//                provideText = { "Add Exercise" },
//                color = Design.colors.orange
//            )
//        }
//    )
//}